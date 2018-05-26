package Communication.EncapsulatingMessageGenerator;

import Messages.EncapsulatingMessage;

public interface IEncapsulatingMessageGenerator {
    EncapsulatingMessage generateMessage(Object content);
    String generateMessageString(Object object);
}
