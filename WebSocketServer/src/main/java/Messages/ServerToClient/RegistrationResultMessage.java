package Messages.ServerToClient;

public class RegistrationResultMessage {
    public boolean isResult() {
        return result;
    }

    private boolean result;

    public RegistrationResultMessage(boolean result)
    {
        this.result = result;
    }
}