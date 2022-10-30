package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.models.User;
import ee.taltech.iti0302.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/users")
    public void registerNewEmployee(@RequestBody User user) {
        userService.addUser(user);
    }
}
