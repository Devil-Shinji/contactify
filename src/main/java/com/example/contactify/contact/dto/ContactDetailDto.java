package com.example.contactify.contact.dto;

import com.example.contactify.contact.entity.Contact;
import com.example.contactify.user.dto.UserListDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Value
public class ContactDetailDto implements Serializable {
    Long id;
    String realName;
    String codeName;
    String phoneNumber;
    UserListDto user;
}