package Websockets.Shared.interfaces;


import Websockets.Shared.messages.EncapsulatingMessage;

public interface IEncapsulatingMessageGenerator {
    EncapsulatingMessage generateMessage(Object content);

    String generateMessageString(Object content);

}
