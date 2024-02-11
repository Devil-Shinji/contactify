package com.example.contactify.contact.dto;

import com.example.contactify.contact.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEditDto implements Serializable {
    String realName;
    String codeName;
    String phoneNumber;
    Long userId;
}