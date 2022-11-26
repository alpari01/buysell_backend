package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.exception.ApplicationException;
import ee.taltech.iti0302.mapper.UserMapper;
import ee.taltech.iti0302.model.User;
import ee.taltech.iti0302.repository.UserRepository;
import ee.taltech.iti0302.security.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDto getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User not found"));
        return userMapper.entityToDto(user);
    }

    public void createUser(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public LoginResponse login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User not found"));
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            // TODO
            return null;
        } else {
            throw new ApplicationException("Wrond email or password");
        }
    }
}
