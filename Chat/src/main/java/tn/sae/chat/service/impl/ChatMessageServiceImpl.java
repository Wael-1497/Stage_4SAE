package tn.sae.chat.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.sae.chat.model.ChatMessage;
import tn.sae.chat.repository.ChatMessageRepository;
import tn.sae.chat.service.ChatMessageService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage add(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessage> getAllByChatId(Long chatId) {
        return chatMessageRepository.findAllByChatId(chatId);
    }
}
