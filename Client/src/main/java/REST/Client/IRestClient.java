package REST.Client;

import Models.User.Player;

public interface IRestClient {
        Player Login(String username, String password);

}
