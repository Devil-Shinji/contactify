package com.example.contactify.user.service;

import com.example.contactify.user.dto.UserDetailDto;
import com.example.contactify.user.dto.UserEditDto;
import com.example.contactify.user.dto.UserListDto;
import com.example.contactify.user.entity.User;
import com.example.contactify.user.mapper.UserMapper;
import com.example.contactify.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDetailDto save(UserEditDto dto) {
        User user = userMapper.toEntity(dto);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        return userMapper.toDetailDto(user);
    }

    @Transactional(readOnly = true)
    public UserDetailDto findByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::toDetailDto).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public List<UserListDto> getAll() {
        List<User> users = userRepository.findAll();

        return userMapper.toListDto(users);
    }

    @Transactional
    public UserDetailDto get(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return userMapper.toDetailDto(user);
    }

    @Transactional
    public void delete(Long id) { userRepository.deleteById(id); }
}