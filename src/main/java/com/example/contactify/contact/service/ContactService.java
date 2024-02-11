package com.example.contactify.contact.service;

import com.example.contactify.contact.dto.ContactDetailDto;
import com.example.contactify.contact.dto.ContactEditDto;
import com.example.contactify.contact.dto.ContactListDto;
import com.example.contactify.contact.entity.Contact;
import com.example.contactify.contact.mapper.ContactMapper;
import com.example.contactify.contact.repository.ContactRepository;
import com.example.contactify.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    private final UserRepository userRepository;

    @Autowired
    public ContactService(
            ContactRepository contactRepository,
            ContactMapper contactMapper,
            UserRepository userRepository
    ) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.userRepository = userRepository;
    }

    public ContactDetailDto save(ContactEditDto dto) {
        Contact contact = contactMapper.toEntity(dto);

        contact.setUser(
                userRepository.findById(dto.getUserId()).orElseThrow(
                        () -> new RuntimeException("User not found with id: " + dto.getUserId()))
        );

        contact = contactRepository.save(contact);

        return contactMapper.toDetailDto(contact);
    }

    public ContactDetailDto update(Long id, ContactEditDto dto) {
        Contact dbContact = contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contact with id " + id + " not found"));
        Contact changedContact = contactMapper.toEntity(dto);

        dbContact.setUser(
                userRepository.findById(dto.getUserId()).orElseThrow(
                        () -> new RuntimeException("User not found with id: " + dto.getUserId()))
        );
        dbContact.setCodeName(changedContact.getCodeName());
        dbContact.setPhoneNumber(changedContact.getPhoneNumber());
        dbContact.setRealName(changedContact.getRealName());

        dbContact = contactRepository.save(dbContact);

        return contactMapper.toDetailDto(dbContact);
    }

    public List<ContactListDto> getAll() {
        List<Contact> contacts = contactRepository.findAll();

        return contactMapper.toListDto(contacts);
    }

    @Transactional
    public ContactDetailDto get(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow();

        return contactMapper.toDetailDto(contact);
    }

    @Transactional
    public void delete(Long id) { contactRepository.deleteById(id); }
}