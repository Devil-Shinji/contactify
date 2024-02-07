package com.example.contactify.user.mapper;

import com.example.contactify.user.dto.UserDetailDto;
import com.example.contactify.user.dto.UserEditDto;
import com.example.contactify.user.dto.UserListDto;
import com.example.contactify.user.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        builder = @Builder(disableBuilder = true),
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    User toEntity(UserListDto userDto);
    User toEntity(UserDetailDto userDto);
    User toEntity(UserEditDto userDto);

    UserListDto toListDto(User user);
    UserDetailDto toDetailDto(User user);

    List<UserListDto> toListDto(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserListDto userDto, @MappingTarget User user);
}