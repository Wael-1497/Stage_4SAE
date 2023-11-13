package tn.sae.chat.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.sae.chat.exception.AuthenticationException;
import tn.sae.chat.model.User;
import tn.sae.chat.repository.UserRepository;
import tn.sae.chat.security.TokenService;
import tn.sae.chat.service.AuthenticationService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public void register(String nickName, String password) {
        Optional<User> userByNickName = userRepository.findUserByNickName(nickName);
        if (userByNickName.isPresent()) {
            throw new AuthenticationException("User with such nick name already exists!");
        }
        User user = new User();
        user.setNickName(nickName);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public String login(String nickName, String password) {
        Optional<User> userByNickName = userRepository.findUserByNickName(nickName);
        if (userByNickName.isPresent()) {
            User user = userByNickName.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return tokenService.generateToken(user);
            }
        }
        throw new AuthenticationException("Nickname or password are incorrect");
    }
}
