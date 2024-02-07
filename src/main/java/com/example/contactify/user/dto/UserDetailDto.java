package com.example.contactify.user.dto;

import com.example.contactify.contact.dto.ContactListDto;
import com.example.contactify.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link User}
 */
@Value
public class UserDetailDto implements Serializable {
    Long id;
    String firstName;
    String lastName;
    @NotNull
    @NotEmpty
    @NotBlank
    String username;
    @Email
    String email;
    @NotNull List<ContactListDto> contacts;
}