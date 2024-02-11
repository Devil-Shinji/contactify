import React from "react";

interface ModalProps {
    show: boolean;
    isOpen: boolean;
    closeModal: () => void;
    children: React.ReactNode;
}

const Modal: React.FC<ModalProps> = ({ isOpen, closeModal, children }) => {
    if (!isOpen) {
        return null;
    }

    const handleBackgroundClick = (event: React.MouseEvent<HTMLDivElement, MouseEvent>) => {
        if (event.currentTarget === event.target) {
            closeModal();
        }
    }

    return (
        <div style={{
            position: 'fixed',
            top: 0,
            bottom: 0,
            left: 0,
            right: 0,
            display: 'grid',
            justifyContent: 'center',
            alignItems: 'center',
            backgroundColor: 'rgba(0,0,0,0.3)',
        }} onClick={handleBackgroundClick}>
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
            }}>
                {children}
            </div>
        </div>
    );
}

export default Modal;