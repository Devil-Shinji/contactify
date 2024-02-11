package com.example.contactify.user.dto;

import com.example.contactify.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class UserEditDto implements Serializable {
    String firstName;
    String lastName;
    @NotNull
    @NotEmpty
    @NotBlank
    String username;
    @Email
    String email;
    @NotNull
    @NotEmpty
    @NotBlank
    String password;
}