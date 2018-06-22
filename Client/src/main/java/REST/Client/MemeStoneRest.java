package REST.Client;


import Models.Card.Card;
import REST.RESTmodels.Minion;
import REST.RESTmodels.Player;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        List<Card> collection = new ArrayList<>();
        for (REST.RESTmodels.Card c : player.getCollection()){
            if (c instanceof Minion){
                collection.add(new Models.Card.Minion.Minion(c.getName(), "Minion", c.getManaCost(), ((Minion) c).getAttackPoints(), ((Minion) c).getHealthPoints()));
            } else if (c instanceof REST.RESTmodels.DamageSpell){
                collection.add(new Models.Card.Spell.DamageSpell(c.getName(), "DamageSpell", c.getManaCost(), c.getAbilityStrength()));
            } else if (c instanceof REST.RESTmodels.DrawSpell){
                collection.add(new Models.Card.Spell.DamageSpell(c.getName(), "DrawSpell", c.getManaCost(), c.getAbilityStrength()));
            } else if (c instanceof REST.RESTmodels.HealSpell){
                collection.add(new Models.Card.Spell.HealSpell(c.getName(), "HealSpell", c.getManaCost(), c.getAbilityStrength()));
            } else if (c instanceof REST.RESTmodels.ResurrectSpell){
                collection.add(new Models.Card.Spell.ResurrectSpell(c.getName(), "RessurectSpell", c.getManaCost(), c.getAbilityStrength()));
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
