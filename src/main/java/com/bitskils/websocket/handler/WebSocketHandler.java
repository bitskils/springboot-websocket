package com.bitskils.websocket.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String sessionId = session.getId();
        String remoteAddress = session.getRemoteAddress().toString();
        log.info("WebSocket connection established: Session ID=" + sessionId + ", Remote Address=" + remoteAddress);
        String welcomeMessage = "Welcome to the WebSocket chat!";
        session.sendMessage(new TextMessage(welcomeMessage));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String messageContent = message.getPayload();
        log.info("Received message: " + messageContent);
        session.sendMessage(new TextMessage("You said: " + messageContent));
    }
}
