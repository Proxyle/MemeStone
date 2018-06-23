package REST.Client;


import Models.Card.Card;
import Models.Card.Spell.HealSpell;
import REST.RESTmodels.Minion;
import REST.RESTmodels.Player;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MemeStoneRest implements IRestClient {
    private final String url = "http://192.168.2.4:8105/api";
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
        List<Card> collection = new ArrayList<>();


        for (REST.RESTmodels.Card c : player.getCollection()){
            if (c.getName().equals("Harambe") || c.getName().equals("Wilrekt") || c.getName().equals("Pepe") ||
                    c.getName().equals("Trololololol") || c.getName().equals("Ugandan Knuckles") || c.getName().equals("MonkaS") ||
                    c.getName().equals("Ben Swolo") || c.getName().equals("Salt bae") || c.getName().equals("Roll Safe") ||
                    c.getName().equals("Turn Hackerman") || c.getName().equals("Pedobear") || c.getName().equals("Tochnoviking") ||
                    c.getName().equals("Star Ward Kid") || c.getName().equals("Good Guy Greg") || c.getName().equals("Dramatic Chipmunk") ||
                    c.getName().equals("Scumbag Steve") || c.getName().equals("Tron Guy") || c.getName().equals("Disaster Girl") ||
                    c.getName().equals("Afro Ninja") || c.getName().equals("Angry German Kid") || c.getName().equals("Bad Luck Brian") ||
                    c.getName().equals("Dick Butt") || c.getName().equals("Stoner") || c.getName().equals("Wat") ||
                    c.getName().equals("Nyan Cat") || c.getName().equals("Succes Kid") || c.getName().equals("Doge") ||
                    c.getName().equals("TheLegend27") || c.getName().equals("He-Man") || c.getName().equals("Epic Sax Guy") ||
                    c.getName().equals("Skull Trumpet")){
                collection.add(new Models.Card.Minion.Minion(c.getName(), "Minion", c.getManaCost(), 5, 10));
                System.out.println("----------");
                System.out.println(c.getName());
                System.out.println("Minion");
            }
            else {
                collection.add(new HealSpell(c.getName(), "DrawSpell", c.getManaCost(), c.getAbilityStrength()));
                System.out.println("----------");
                System.out.println(c.getName());
                System.out.println("Spell");
            }
        }
        Models.User.Player p = new Models.User.Player(player.getUserName(), player.getPassword(), player.getEmail(), player.getId(), player.getRankPoints(), collection);
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
