package model.interfaces;

public interface IPlayer {
    String registerPlayer(IPlayer player);
    String login(IPlayer player);
    String getSettings(String userId);
    String changePassword(String userId, String newPassword);
}
