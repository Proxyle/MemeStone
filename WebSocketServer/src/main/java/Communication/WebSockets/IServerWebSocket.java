package Communication.WebSockets;

public interface IServerWebSocket {
    void sendTo(String sessionId, Object object);

    void broadcast(Object object);

    void sendToGroup(String[] sessionIds, Object object);
}
