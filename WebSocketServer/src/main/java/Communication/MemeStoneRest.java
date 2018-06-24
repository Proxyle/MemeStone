package Communication;

import RESTmodels.resources.PlayerCard;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import RESTmodels.*;

import java.util.List;


public class MemeStoneRest {
    private final String url = "http://145.93.105.181:8105/api";
    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseUrl() {
        return url;
    }

    public void updateCollection(int userId, int cardId) {
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "/collection/update";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)) {
            System.out.println(result.getStatusCode());
        }
    }

    public void updateScore(int userId, int score){
        Long id = Long.valueOf(userId);
        Player p = new Player(); p.setId(id);
        HttpEntity<PlayerCard> requestBody = new HttpEntity<>(new PlayerCard());
        String query = url + "";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)){
            System.out.println(result.getStatusCode());
        }
    }

    public void updateDeck(int userId, List<Models.Cards.Card> deck){
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "";
        ResponseEntity result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)){
            System.out.println(result.getStatusCode());
        }
    }

    public A getCards(){
        String query = url + "/card/";
        ResponseEntity<A> result = restTemplate.getForEntity(query, A.class);

        if (result.getStatusCode() == HttpStatus.OK){
            return result.getBody();
        }
        else{
            return null;
        }
    }
}
