package edu.application.mill.socket;

import edu.application.mill.bean.MillService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfiguration implements WebSocketConfigurer {

    private final MillService millService;

    public SocketConfiguration(MillService millService) {
        this.millService = millService;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new MillSocketHandler(millService), "/websocket").setAllowedOrigins("*");
    }
}
