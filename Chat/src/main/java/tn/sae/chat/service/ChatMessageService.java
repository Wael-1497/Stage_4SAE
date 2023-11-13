package tn.sae.chat.service;

import tn.sae.chat.model.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    ChatMessage add(ChatMessage chatMessage);

    List<ChatMessage> getAllByChatId(Long chatId);
}
