package model.interfaces;

public interface IPlayer {
    String registerPlayer(IPlayer player);
    String login(IPlayer player);
    String getSettings(String playerId);
    String changePassword(String playerId, String newPassword);
}
