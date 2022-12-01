package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.mapper.UserMapper;
import ee.taltech.iti0302.mapper.UserMapperImpl;
import ee.taltech.iti0302.model.User;
import ee.taltech.iti0302.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = new UserMapperImpl();

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById() {
        // given
        User user = User.builder().id(1).firstName("Ilja").lastName("Lastovko").build();
        given(userRepository.findById(1)).willReturn(Optional.of(user));

        // when
        var result = userService.getUserById(1);

        // then
        then(userMapper).should().entityToDto(user);
        then(userRepository).should().findById(1);
        assertEquals(UserDto.builder().id(1).firstName("Ilja").lastName("Lastovko").build(), result);
    }
}