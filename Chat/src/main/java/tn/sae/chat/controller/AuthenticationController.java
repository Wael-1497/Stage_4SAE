package tn.sae.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.sae.chat.dto.Token;
import tn.sae.chat.dto.UserDto;
import tn.sae.chat.service.AuthenticationService;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserDto userDto) {
        authenticationService.register(userDto.getNickName(),
                userDto.getPassword());
    }

    @PostMapping("/login")
    public Token login(@RequestBody UserDto userDto) {
        String value = authenticationService
                .login(userDto.getNickName(), userDto.getPassword());
        return new Token(value);
    }
}
