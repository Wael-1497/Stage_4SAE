package tn.sae.chat.mapper.response;


import org.springframework.stereotype.Service;
import tn.sae.chat.dto.ChatMessageResponseDto;
import tn.sae.chat.model.ChatMessage;

@Service
public class ChatMessageResponseMapper {
    public ChatMessageResponseDto toDto(ChatMessage chatMessage) {
        ChatMessageResponseDto chatMessageResponseDto = new ChatMessageResponseDto();
        chatMessageResponseDto.setId(chatMessage.getId());
        chatMessageResponseDto.setMessage(chatMessage.getMessage());
        chatMessageResponseDto.setFrom(chatMessage.getSendFrom().getNickName());
        chatMessageResponseDto.setDate(chatMessage.getDate());
        chatMessageResponseDto.setChatId(chatMessage.getChat().getId());
        return chatMessageResponseDto;
    }
}
