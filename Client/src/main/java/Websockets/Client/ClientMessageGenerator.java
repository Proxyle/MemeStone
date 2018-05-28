package Websockets.Client;

import Websockets.Shared.messages.RegisterPlayerMessage;

public class ClientMessageGenerator implements Websockets.Client.IClientMessageGenerator {
    private Websockets.Client.IClientWebSocket clientWebSocket;

    public ClientMessageGenerator(Websockets.Client.IClientWebSocket clientWebSocket){
        this.clientWebSocket = clientWebSocket;
    }
    public void registerPlayerOnServer(String name) {
        clientWebSocket.send(new RegisterPlayerMessage(name));
    }
    //TODO Message Methods
}
