package tn.sae.chat.service;

public interface AuthenticationService {
    void register(String nickName, String password);

    String login(String nickName, String password);
}
