import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class MemeStoneRest {
    private final String url = "http://145.93.105.181:8105/api";
    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseUrl() {
        return url;
    }

    /*public void getLogin(String username, String password) {
        HttpEntity<Player> requestBody = new HttpEntity<>(new Player(username, password));
        String query = url + "/player/login";
        ResponseEntity<Player> result = restTemplate.postForEntity(query, requestBody, Player.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            Player player = result.getBody();
            System.out.println("Log in request");
            System.out.println("username is: " + player.getUserName());
            System.out.println("password is: " + player.getPassword());
        } else {
            System.out.println("Error while logging in");
        }
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
    }*/

}
