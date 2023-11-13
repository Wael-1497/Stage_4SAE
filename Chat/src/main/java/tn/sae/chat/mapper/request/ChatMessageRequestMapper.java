package tn.sae.chat.mapper.request;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.sae.chat.dto.ChatMessageRequestDto;
import tn.sae.chat.model.ChatMessage;
import tn.sae.chat.model.User;
import tn.sae.chat.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class ChatMessageRequestMapper {
    private final UserRepository userRepository;

    public ChatMessage toModel(ChatMessageRequestDto dto) {
        ChatMessage chatMessage = new ChatMessage();
        User user = userRepository.findUserByNickName(dto.getFrom()).orElseThrow();
        chatMessage.setSendFrom(user);
        chatMessage.setMessage(dto.getMessage());
        return chatMessage;
    }
}
