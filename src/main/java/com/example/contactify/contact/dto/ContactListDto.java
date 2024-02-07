package com.example.contactify.contact.dto;

import com.example.contactify.contact.entity.Contact;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Value
public class ContactListDto implements Serializable {
    Long id;
    String realName;
    String codeName;
    String phoneNumber;
}