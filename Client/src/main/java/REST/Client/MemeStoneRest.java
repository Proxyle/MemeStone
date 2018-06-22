package REST.Client;

import REST.RESTmodels.Player;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MemeStoneRest implements IRestClient {
    private final String url = "http://145.116.44.209:8105/api";
    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseUrl() {
        return url;
    }

    public Models.User.Player Login(String username, String password) {
        HttpEntity<Player> requestBody = new HttpEntity<>(new Player(username, password));
        String query = url + "/player/login";
        ResponseEntity<Player> result = restTemplate.postForEntity(query, requestBody, Player.class);
        Player player = new Player();
        if (result.getStatusCode() == HttpStatus.OK) {
            player = result.getBody();
            System.out.println("Log in request");
            System.out.println("username is: " + player.getUserName());
            System.out.println("password is: " + player.getPassword());
        } else {
            System.out.println("Error while logging in");
        }
        Models.User.Player p = new Models.User.Player(player.getUserName(), player.getPassword(), player.getEmail(), player.getId(), player.getRankPoints(), player.getCollection());
        return p;
    }

    public void register(String username, String password, String email){
        HttpEntity<Player> requestBody = new HttpEntity<>(new Player(username, password, email));
        String query = url + "/player/register";
        ResponseEntity<Player> result = restTemplate.postForEntity(query, requestBody, Player.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            Player player = result.getBody();
        } else {
            System.out.println("Error while signing up");
        }
    }
}
