package Websockets.Client;



public class ClientMessageGenerator implements Websockets.Client.IClientMessageGenerator {
    private Websockets.Client.IClientWebSocket clientWebSocket;

    public ClientMessageGenerator(Websockets.Client.IClientWebSocket clientWebSocket){
        this.clientWebSocket = clientWebSocket;
    }
    public void registerPlayerOnServer(String name) {
        clientWebSocket.send(new Messages.ClientToServer.RegisterPlayerMessage(name, null));
    }
    //TODO Message Methods
}
