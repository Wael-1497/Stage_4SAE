package tn.sae.chat.controller;

import org.springframework.web.bind.annotation.*;
import tn.sae.chat.dto.ChatMessageResponseDto;
import tn.sae.chat.dto.ChatRequestDto;
import tn.sae.chat.dto.ChatResponseDto;
import tn.sae.chat.mapper.request.ChatRequestMapper;
import tn.sae.chat.mapper.response.ChatMessageResponseMapper;
import tn.sae.chat.mapper.response.ChatResponseMapper;
import tn.sae.chat.model.Chat;
import tn.sae.chat.service.ChatMessageService;
import tn.sae.chat.service.ChatService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chats")
public class ChatController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final ChatMessageResponseMapper chatMessageResponseMapper;
    private final ChatRequestMapper chatRequestMapper;
    private final ChatResponseMapper chatResponseMapper;

    @PostMapping
    public ChatResponseDto createChat(@RequestBody ChatRequestDto chatRequestDto) {
        Chat chat = chatRequestMapper.toModel(chatRequestDto);
        chat.setCreatedOn(LocalDateTime.now());
        return chatResponseMapper.toDto(chatService.add(chat));
    }

    @GetMapping
    public List<ChatResponseDto> getAllChats() {
        return chatService.getAll().stream()
                .map(chatResponseMapper::toDto)
                .toList();
    }

    @GetMapping("/{chatId}")
    public List<ChatMessageResponseDto> getAllMessages(
            @PathVariable Long chatId) {
        return chatMessageService.getAllByChatId(chatId).stream()
                .map(chatMessageResponseMapper::toDto)
                .toList();
    }
}
