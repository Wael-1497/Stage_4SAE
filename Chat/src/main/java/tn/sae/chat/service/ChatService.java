package tn.sae.chat.service;


import tn.sae.chat.model.Chat;

import java.util.List;

public interface ChatService {
    Chat get(Long id);

    Chat add(Chat chat);

    List<Chat> getAll();
}
