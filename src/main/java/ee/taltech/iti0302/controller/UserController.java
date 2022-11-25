package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/api/users/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/api/users")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
}
