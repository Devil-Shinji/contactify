package com.example.contactify.contact.controller;

import com.example.contactify.contact.dto.ContactDetailDto;
import com.example.contactify.contact.dto.ContactEditDto;
import com.example.contactify.contact.dto.ContactListDto;
import com.example.contactify.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ContactDetailDto save(@RequestBody ContactEditDto dto) {
        return contactService.save(dto);
    }

    @GetMapping
    public Iterable<ContactListDto> getAll() { return contactService.getAll(); }

    @GetMapping("/{id}")
    public ContactDetailDto get(@PathVariable Long id) { return contactService.get(id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { contactService.delete(id); }
}