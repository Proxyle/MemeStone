package Card.Minion;

public abstract class IMinionState {
    private Minion minion;

    protected abstract void updateState(final Minion context);
}
