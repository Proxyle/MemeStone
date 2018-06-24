import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import RESTmodels.*;


public class MemeStoneRest {
    private final String url = "http://145.93.105.181:8105/api";
    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseUrl() {
        return url;
    }

    public void updateCollection() {
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)) {
            System.out.println(result.getStatusCode());
        }
    }

    public void updateScore(){
        HttpEntity<PlayerCard> requestBody = new HttpEntity<>(new Deck());
        String query = url + "";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)){
            System.out.println(result.getStatusCode());
        }
    }

    public void updateDeck(){
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

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
