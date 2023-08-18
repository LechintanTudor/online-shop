package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateUserDto;
import xyz.lechi.onlineshop.dto.UserDto;
import xyz.lechi.onlineshop.dto.mapper.UserMapper;
import xyz.lechi.onlineshop.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto addUser(CreateUserDto createDto) {
        var user = userMapper.fromCreateDto(createDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
