package com.example.contactify.contact.mapper;

import com.example.contactify.contact.dto.ContactDetailDto;
import com.example.contactify.contact.dto.ContactEditDto;
import com.example.contactify.contact.dto.ContactListDto;
import com.example.contactify.contact.entity.Contact;
import com.example.contactify.user.mapper.UserMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        builder = @Builder(disableBuilder = true),
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ContactMapper {
    Contact toEntity(ContactListDto contactDto);
    Contact toEntity(ContactDetailDto contactDto);
    Contact toEntity(ContactEditDto contactDto);

    ContactListDto toListDto(Contact contact);
    ContactDetailDto toDetailDto(Contact contact);

    List<ContactListDto> toListDto(List<Contact> contacts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact partialUpdate(ContactListDto contactListDto, @MappingTarget Contact contact);
}