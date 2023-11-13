package tn.sae.chat.mapper.response;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.sae.chat.dto.ChatResponseDto;
import tn.sae.chat.model.Chat;
import tn.sae.chat.model.ChatMessage;
import tn.sae.chat.repository.ChatMessageRepository;

@RequiredArgsConstructor
@Service
public class ChatResponseMapper {
    private final ChatMessageRepository chatMessageRepository;

    public ChatResponseDto toDto(Chat chat) {
        ChatResponseDto chatResponseDto = new ChatResponseDto();
        chatResponseDto.setId(chat.getId());
        chatResponseDto.setName(chat.getName());
        ChatMessage lastMessage = chatMessageRepository
                .findAllByChatId(chat.getId(),
                        PageRequest.of(0, 1,
                                Sort.by(Sort.Direction.DESC,"date")))
                .stream()
                .findFirst().orElse(new ChatMessage());
        chatResponseDto.setLastMessageSend(lastMessage.getMessage());
        chatResponseDto.setLastMessageSendTime(lastMessage.getDate());
        return chatResponseDto;
    }
}
