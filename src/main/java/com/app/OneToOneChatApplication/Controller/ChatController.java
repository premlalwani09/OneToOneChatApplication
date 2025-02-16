package com.app.OneToOneChatApplication.Controller;

import com.app.OneToOneChatApplication.Entity.ChatMessage;
import com.app.OneToOneChatApplication.Entity.ChatNotification;
import com.app.OneToOneChatApplication.Service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage){

        ChatMessage savedMessage = chatMessageService.save(chatMessage);

        // john/queue/messages
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                ChatNotification.builder()
                        .id(savedMessage.getId())
                        .senderId(savedMessage.getSenderId())
                        .recipientId(savedMessage.getRecipientId())
                        .content(savedMessage.getContent())
                        .build()
        );
    }


    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(
            @PathVariable("senderId") String senderId,
            @PathVariable("recipientId") String recipientId
    ){

        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }


}
