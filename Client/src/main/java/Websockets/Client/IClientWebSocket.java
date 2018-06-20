package Websockets.Client;

public interface IClientWebSocket {
    void start();
    void stop();
    void send(Object object);
    void setMessageHandler(IClientMessageProcessor handler);
    void onWebSocketMessageReceived(String message, String sessionId);
}
