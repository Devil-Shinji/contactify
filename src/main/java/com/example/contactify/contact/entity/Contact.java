package com.example.contactify.contact.entity;

import com.example.contactify.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String realName;

    @Column
    @NotNull
    private String codeName;

    @Column
    @NotNull
    private String phoneNumber;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private User user;
}