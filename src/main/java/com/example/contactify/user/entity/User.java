package com.example.contactify.user.entity;

import com.example.contactify.contact.entity.Contact;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") // because "user" (singular) is a reserved keyword on Oracle DB
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Contact> contacts = new ArrayList<>();
}