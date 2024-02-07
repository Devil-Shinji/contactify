package com.example.contactify.contact.dto;

import com.example.contactify.contact.entity.Contact;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Value
public class ContactEditDto implements Serializable {
    String realName;
    String codeName;
    String phoneNumber;
    Long userId;
}