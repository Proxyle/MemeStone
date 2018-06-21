package ServerApp;

import Communication.MessageGenerator.IMessageGenerator;
import Communication.MessageGenerator.MessageGenerator;
import Communication.MessageHandlers.IMessageHandler;
import Communication.MessageHandlers.MessageHandler;
import Communication.MessageProcessor.IMessageProcessor;
import Communication.MessageProcessor.MessageProcessor;
import Communication.WebSockets.ServerWebSocket;
import Logic.GameLobby.GameLogic;
import Logic.GameLobby.IGameLogic;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

public class ServerApp {

    private static final int PORT = 8095;


    public static void main(String[] args) {

        IMessageHandler factory = new MessageHandler();
        IMessageProcessor messageHandler = new MessageProcessor(factory);
        final ServerWebSocket socket = new ServerWebSocket();
        socket.setMessageHandler(messageHandler);

        IMessageGenerator messageGenerator = new MessageGenerator(socket);

        IGameLogic gameLobby = new GameLogic(messageGenerator);
        messageHandler.connectLobby(gameLobby);

        Server webSocketServer = new Server();
        ServerConnector connector = new ServerConnector(webSocketServer);
        connector.setPort(PORT);
        webSocketServer.addConnector(connector);

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler webSocketContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        webSocketContext.setContextPath("/");
        webSocketServer.setHandler(webSocketContext);

        try {
            // Initialize javax.websocket layer
            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(webSocketContext);

            // Add ServerWebSocket endpoint to javax.websocket layer
            ServerEndpointConfig config = ServerEndpointConfig.Builder.create(socket.getClass(), socket.getClass().getAnnotation(ServerEndpoint.class).value())
                    .configurator(new ServerEndpointConfig.Configurator() {
                        @Override
                        public <T> T getEndpointInstance(Class<T> endpointClass) {
                            return (T) socket;
                        }
                    })
                    .build();
            wscontainer.addEndpoint(config);
            webSocketServer.start();
            webSocketServer.join();

        } catch (Exception ex) {
        }
    }
}