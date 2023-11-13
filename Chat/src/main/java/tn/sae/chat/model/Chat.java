package tn.sae.chat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "chat")
    private Set<ChatMessage> messages;
    private String name;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}