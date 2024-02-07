package com.example.contactify.contact.repository;

import com.example.contactify.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}