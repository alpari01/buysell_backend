package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.exception.ApplicationException;
import ee.taltech.iti0302.mapper.UserMapper;
import ee.taltech.iti0302.model.User;
import ee.taltech.iti0302.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void addUser(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        userRepository.save(user);
    }

    public UserDto getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User not found"));
        return userMapper.entityToDto(user);
    }
}
