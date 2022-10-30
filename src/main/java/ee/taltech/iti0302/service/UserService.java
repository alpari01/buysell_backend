package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.mapper.UserMapper;
import ee.taltech.iti0302.models.User;
import ee.taltech.iti0302.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void addUser(UserDto userDto) {
        try {
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setBirthdate(userDto.getBirthdate());
            user.setGender(userDto.getGender());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
