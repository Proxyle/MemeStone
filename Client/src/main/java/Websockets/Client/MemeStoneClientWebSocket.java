package Websockets.Client;

import Logic.GameMaster.IGameMaster;
import Websockets.Shared.MemeStoneSocketMessage;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.websocket.*;

import java.net.URI;

public class MemeStoneClientWebSocket implements ICommunicator {
    private Gson gson;
    private static MemeStoneClientWebSocket instance = null;
    private final String uri = ""; //TODO
    private Session session;
    private IGameMaster gameMaster;
    private boolean isRunning = false;
    private String message;

    public MemeStoneClientWebSocket() {
        gson = new Gson();
    }

    public static MemeStoneClientWebSocket getInstance(){
        if(instance == null){
            instance = new MemeStoneClientWebSocket();
        }
        return instance;
    }

    public void setGameMaster(IGameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("[WebSocket Client open session] " + session.getRequestURI());
        this.session = session;
    }

    @OnMessage
    public void onText(String message, Session session) {
        this.message = message;
        System.out.println("[WebSocket Client message received] " + message);
        processMessage(message);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[WebSocket Client connection error] " + cause.toString());
    }

    @OnClose
    public void onClose(CloseReason reason) {
        System.out.println("[WebSocket Client close session] " + session.getRequestURI());
        System.out.println(" for reason " + reason);
        session = null;
    }


    public void start() {
        if (!isRunning){
            isRunning = true;
            startClient();
        }
    }

    private void startClient() {
        System.out.println("[WebSocket Client start]");
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(uri));
        } catch (Exception ex) {
            // Not the way to go, ...
            ex.printStackTrace();
        }
    }

    private void stopClient() {
        System.out.println("[WebSocket Client stop]");
        try {
            session.close();
        } catch (Exception ex) {
            // Not the way to go, ...
            ex.printStackTrace();
        }
    }

    public void stop() {

    }

    private void sendMessageToServer(MemeStoneSocketMessage message) {
        String jsonMessage = gson.toJson(message);
        session.getAsyncRemote().sendText(jsonMessage);
    }


    private void processMessage(String jsonMessage) {
        MemeStoneSocketMessage message;
        try {
            message = gson.fromJson(jsonMessage, MemeStoneSocketMessage.class);
        } catch (JsonSyntaxException ex) {
            System.out.println("[WebSocket Client ERROR]: cannot parse Json message " + jsonMessage);
            return;
        }
    }

}
