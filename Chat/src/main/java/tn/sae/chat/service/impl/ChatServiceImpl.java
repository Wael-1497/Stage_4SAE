package tn.sae.chat.service.impl;


import java.util.List;
import java.util.NoSuchElementException;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.sae.chat.model.Chat;
import tn.sae.chat.repository.ChatRepository;
import tn.sae.chat.service.ChatService;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public Chat get(Long id) {
        return chatRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("No such char with id " + id));
    }

    @Override
    public Chat add(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAllByOrderByCreatedOnDesc();
    }
}
