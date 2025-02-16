package com.app.OneToOneChatApplication.Repository;

import com.app.OneToOneChatApplication.Entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findByChatId(String s);
}
