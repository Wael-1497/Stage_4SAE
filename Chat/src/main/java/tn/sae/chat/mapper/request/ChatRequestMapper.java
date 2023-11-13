package tn.sae.chat.mapper.request;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.sae.chat.dto.ChatRequestDto;
import tn.sae.chat.model.Chat;
import tn.sae.chat.model.User;
import tn.sae.chat.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class ChatRequestMapper {
    private final UserRepository userRepository;

    public Chat toModel(ChatRequestDto chatRequestDto) {
        Chat chat = new Chat();
        User user = userRepository.findUserByNickName(chatRequestDto.getNickName()).orElseThrow();
        chat.setName(chatRequestDto.getName());
        chat.setUser(user);
        return chat;
    }
}
