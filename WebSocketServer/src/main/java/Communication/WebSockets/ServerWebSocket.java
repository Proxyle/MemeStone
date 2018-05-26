package Communication.WebSockets;

import Communication.EncapsulatingMessageGenerator.EncapsulatingMessageGenerator;
import Communication.EncapsulatingMessageGenerator.IEncapsulatingMessageGenerator;
import Communication.MessageProcessor.IMessageProcessor;
import Messages.EncapsulatingMessage;
import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;

@ServerEndpoint(value="/memestone/")
public class ServerWebSocket implements IServerWebSocket {

    private IMessageProcessor handler;

    public IEncapsulatingMessageGenerator getEncapsulatingMessageGenerator() {
        return encapsulatingMessageGenerator;
    }

    private IEncapsulatingMessageGenerator encapsulatingMessageGenerator = new EncapsulatingMessageGenerator();

    private Gson gson;

    public ServerWebSocket()
    {
        gson = new Gson();
    }

    public void setMessageHandler(IMessageProcessor handler)
    {
        this.handler = handler;
    }

    public Gson getGson() {
        return gson;
    }

    public IMessageProcessor getHandler() {
        return handler;
    }

    private static ArrayList<Session> sessions = new ArrayList<Session>();

    @OnOpen
    public void onConnect(Session session) {
        sessions.add(session);
        System.out.println("[Connected] SessionID:" + session.getId());
    }

    @OnMessage
    public void onText(String message, Session session) {
        String sessionId = session.getId();
        System.out.println(session.getId() + " send message " + message);
        EncapsulatingMessage msg = getGson().fromJson(message, EncapsulatingMessage.class);
        getHandler().processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        sessions.remove(session);
        System.out.println("[Disconnected] SessionID:" + session.getId());
    }

    public void sendTo(String sessionId, Object object)
    {
        String msg = getEncapsulatingMessageGenerator().generateMessageString(object);
        sendToClient(getSessionFromId(sessionId), msg);
    }

    public Session getSessionFromId(String sessionId)
    {
        for(Session s : sessions)
        {
            if(s.getId().equals(sessionId))
                return s;
        }
        return null;
    }

    public void broadcast(Object object)
    {
        for(Session session : sessions) {
            sendTo(session.getId(), object);
        }
    }

    public void sendToGroup(String[] sessionIds, Object object)
    {
        for (String sessionId : sessionIds){
            for(Session ses : sessions) {
                if(!ses.getId().equals(sessionId))
                    sendTo(ses.getId(), object);
            }
        }
    }

    private void sendToClient(Session session, String message)
    {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
        }
    }
}
