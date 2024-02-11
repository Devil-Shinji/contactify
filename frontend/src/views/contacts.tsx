import {IContactEdit, IContactList} from "../lib/contacts/models";
import React, {useEffect, useState} from "react";
import {apiClient} from "../lib/api/APIClient";
import {IUserLogin} from "../lib/users/models";
import Modal from "../lib/modals/editModal";

interface ContactsListPageProps {
    user: IUserLogin
}

const ContactsListPage: React.FC<ContactsListPageProps> = ({user}: ContactsListPageProps) => {
    const [data, setData] = useState<IContactList[]>([]);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [userId, setUserId] = useState(undefined);
    const [newContact, setNewContact] = useState<IContactEdit>({
        userId: undefined,
        realName: '',
        codeName: '',
        phoneNumber: '',
    });

    useEffect(() => {
        const fetchContacts = async () => {
            try {
                const response = await apiClient.getAllRequest("contacts", user);
                const { data } = await apiClient.getSingleByUsernameRequest("users", user.username, user);
                setUserId(data.id);
                setData(response.data);
            } catch (error) {
                console.error('Failed to fetch contacts:', error);
            }
        };

        fetchContacts().catch(error => {
            // Log an error to console or handle it appropriately
            console.error(`Unexpected error occurred: ${error}`);
        });
    }, [user]);

    const handleInputChange = (index: number, key: keyof IContactList, value: any) => {
        if (key === 'id') {
            return; // Don't allow changing ID
        }
        const newData = [...data];
        newData[index][key] = value;
        const updatedContact: IContactEdit = {
            ...newData[index],
            userId: userId,
        };
        handleUpdateContact(updatedContact, newData[index].id);
        setData(newData);
    };

    const handleUpdateContact = async (updatedContact: IContactEdit, contactId: number) => {
        try {
            await apiClient.putRequest("contacts", contactId, updatedContact, user);
        } catch (error) {
            console.error('Failed to update contact:', error);
        }
    };

    const handleDeleteContact = async (id: number) => {
        try {
            await apiClient.deleteRequest("contacts", id, user);
            setData(prevData => prevData.filter(contact => contact.id !== id));
        } catch (error) {
            console.error('Failed to delete contact:', error);
        }
    };

    const openModal = async () => {
        setNewContact(prevContact => ({
            ...prevContact,
            userId: userId
        }));
        setModalIsOpen(true);
    };

    const closeModal = () => {
        setModalIsOpen(false);
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setNewContact(prevContact => ({ ...prevContact, [e.target.name]: e.target.value }));
    };

    const handleAddContact = async (event: React.FormEvent) => {
        event.preventDefault();
        try {
            const response = await apiClient.postRequest('contacts', newContact, user);
            setData(prevData => [...prevData, response.data]);
            // reset the form fields
            setNewContact({
                userId: undefined,
                realName: '',
                codeName: '',
                phoneNumber: '',
            });
            closeModal();
        } catch (error) {
            console.error('Failed to add contact:', error);
        }
    };

    return (
        <div className="App">
            <header className="App-header">
                <table>
                    <thead>
                    <tr>
                        <td>
                            <button onClick={openModal}>Add Contact</button>
                            <Modal isOpen={modalIsOpen} closeModal={closeModal} show>
                                <div style={{
                                    padding: 20,
                                    background: '#fff',
                                    borderRadius: '2px',
                                    display: 'inline-block',
                                    minHeight: '300px',
                                    margin: '1rem',
                                    position: 'relative',
                                    minWidth: '300px',
                                    boxShadow: '0px 5px 15px rgba(0, 0, 0, 0.5)',
                                    justifySelf: 'center',
                                    color: '#000',
                                    fontWeight: 'bold'
                                }}>
                                    <form style={{
                                        display: 'flex',
                                        flexDirection: 'column',
                                        gap: '10px',
                                    }} onSubmit={handleAddContact}>
                                        <input type="hidden" name="userId" value={newContact.userId}/>
                                        <div>
                                            <label htmlFor="realName">Real Name:</label>
                                            <input type="text" id="realName" name="realName" value={newContact.realName}
                                                   onChange={handleChange}/>
                                        </div>
                                        <div>
                                            <label htmlFor="codeName">Code Name:</label>
                                            <input type="text" id="codeName" name="codeName" value={newContact.codeName}
                                                   onChange={handleChange}/>
                                        </div>
                                        <div>
                                            <label htmlFor="phoneNumber">Phone Number:</label>
                                            <input type="tel" id="phoneNumber" name="phoneNumber"
                                                   value={newContact.phoneNumber} onChange={handleChange}/>
                                        </div>
                                        <button type="submit">Save</button>
                                        <button onClick={closeModal}>Cancel</button>
                                    </form>
                                </div>
                            </Modal>
                        </td>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <th>Real Name</th>
                        <th>Code Name</th>
                        <th>Phone Number</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {data.map(({ id, realName, codeName, phoneNumber}, i) => (
                        <tr key={id}>
                            <td><input value={id} readOnly={true}/></td>
                            <td><input value={realName}
                                       onChange={e => handleInputChange(i, 'realName', e.target.value)}/></td>
                            <td><input value={codeName}
                                       onChange={e => handleInputChange(i, 'codeName', e.target.value)}/></td>
                            <td><input value={phoneNumber}
                                       onChange={e => handleInputChange(i, 'phoneNumber', e.target.value)}/></td>
                            <td>
                                <button onClick={() => handleDeleteContact(id)}>
                                    Delete
                                </button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </header>
        </div>
    )
};

export default ContactsListPage;