package tn.sae.chat.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import tn.sae.chat.dto.ChatMessageRequestDto;
import tn.sae.chat.dto.ChatMessageResponseDto;
import tn.sae.chat.mapper.request.ChatMessageRequestMapper;
import tn.sae.chat.mapper.response.ChatMessageResponseMapper;
import tn.sae.chat.model.ChatMessage;
import tn.sae.chat.service.ChatMessageService;
import tn.sae.chat.service.ChatService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@CrossOrigin(origins = "http://localhost:4200")

public class StompController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final ChatMessageRequestMapper chatMessageRequestMapper;
    private final ChatMessageResponseMapper chatMessageResponseMapper;

    @MessageMapping("/chats/{chatId}")
    @SendTo("/topic/chats")
    public ChatMessageResponseDto chat(@DestinationVariable Long chatId,
                                       ChatMessageRequestDto dto) {
        ChatMessage chatMessage = chatMessageRequestMapper.toModel(dto);
        chatMessage.setChat(chatService.get(chatId));
        chatMessage.setDate(LocalDateTime.now());
        return chatMessageResponseMapper.toDto(chatMessageService.add(chatMessage));
    }
}
