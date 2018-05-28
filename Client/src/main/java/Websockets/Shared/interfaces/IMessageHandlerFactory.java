package Websockets.Shared.interfaces;

public interface IMessageHandlerFactory {
    IMessageHandler getHandler(String simpleType, Object game);
}
