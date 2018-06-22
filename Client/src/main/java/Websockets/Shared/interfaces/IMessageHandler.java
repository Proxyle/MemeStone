package Websockets.Shared.interfaces;

public interface IMessageHandler {
    void handleMessage(String message, String sessionId);
}
