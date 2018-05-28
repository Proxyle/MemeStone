package Websockets.Shared;

import Websockets.Shared.interfaces.IEncapsulatingMessageGenerator;
import Websockets.Shared.messages.EncapsulatingMessage;
import com.google.gson.Gson;

public class EncapsulatingMessageGenerator implements IEncapsulatingMessageGenerator {
    private Gson gson = new Gson();

    public EncapsulatingMessage generateMessage(Object content)
    {
        String messageForServerJson = gson.toJson(content);
        String type = content.getClass().toGenericString();
        return new EncapsulatingMessage(type, messageForServerJson);
    }

    public String generateMessageString(Object content)
    {
        EncapsulatingMessage msg = generateMessage(content);
        return gson.toJson(msg);
    }

}
