package Logic.GameMaster;

import Models.Card.Card;
import Models.Setting.Setting;

public interface IGameMaster {
    Card drawCard(int amount);
    boolean healCard(Card target);
    boolean attackCard(Card target);
    Card resurrectMinion();
    boolean nextTurn();
    boolean escapeConcede();
    Setting getSettings();
    boolean changeVolume();
    boolean changeDisplay();
}
