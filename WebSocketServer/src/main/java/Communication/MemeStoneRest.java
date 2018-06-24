package Communication;

import Models.Cards.Card;
/*import RESTmodels.resources.PlayerCard;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import RESTmodels.*;*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemeStoneRest {
    //private final String url = "http://145.93.105.181:8105/api";
    //private RestTemplate restTemplate = new RestTemplate();

    //public String getBaseUrl() {
    //    return url;
    //}

    /*public void updateCollection(int userId, int cardId) {
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "/collection/update";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)) {
            System.out.println(result.getStatusCode());
        }
    }*/

    public void updateCollection(int userId, int cardId){
        String query = "INSERT INTO User_Card (user_id, card_id) VALUES ("+userId+", "+cardId+")";
        executeStatement(query, 0, false);
    }

    /*public void updateScore(int userId, int score){
        Long id = Long.valueOf(userId);
        Player p = new Player(); p.setId(id);
        HttpEntity<PlayerCard> requestBody = new HttpEntity<>(new PlayerCard());
        String query = url + "";
        ResponseEntity<Deck> result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)){
            System.out.println(result.getStatusCode());
        }
    }*/

    public void updateScore(int userId, int score){
        String query = "UPDATE User SET rank = rank+"+score+" WHERE user_id = " + userId;
        executeStatement(query, 0, false);
    }

    /*public void updateDeck(int userId, List<Models.Cards.Card> deck){
        HttpEntity<Deck> requestBody = new HttpEntity<>(new Deck());
        String query = url + "";
        ResponseEntity result = restTemplate.postForEntity(query, requestBody, Deck.class);

        if (!(result.getStatusCode() == HttpStatus.OK)){
            System.out.println(result.getStatusCode());
        }
    }*/

    public void updateDeck(int userId, List<Card> deck){
        String query = "DELETE FROM User_Card WHERE user_id = " + userId;
        executeStatement(query, 0, false);
        for(Card c : deck){
            query = "INSERT INTO User_Card (user_id, card_id) VALUES (" + userId + ", " + c.getId() + ")";
            executeStatement(query, 0, false);
        }
    }
    /*public A getCards(){
        String query = url + "/card/";
        ResponseEntity<A> result = restTemplate.getForEntity(query, A.class);

        if (result.getStatusCode() == HttpStatus.OK){
            return result.getBody();
        }
        else{
            return null;
        }
    }*/

    public ArrayList getCards(){
        //gets all cardId's from the database
        ArrayList cards = new ArrayList<>();
        String query = "SELECT card_id FROM Card";
        List<String> output = executeStatement(query, -1, true);
        try {
            for (String s : output) {
                cards.add(Integer.parseInt(s));
            }
        }
        catch(Exception e){}
        return cards;
    }

    private static Connection conn = null;

    private static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            conn = DriverManager.getConnection("jdbc:sqlserver://mssql.fhict.local;database=dbi341449;user=dbi341449;password=i like trains;loginTimeout=5;");


        } catch (SQLException e) {
        }
    }

    private List<String> executeStatement(String query, int amount, boolean select) {//amount stands for how many output lines it expects
        makeJDBCConnection();
        ArrayList<String> output = new ArrayList<>();
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            try {
                if (select) {
                    ResultSet rs = stmt.executeQuery(query);
                    try {
                        while (rs.next() && amount != count) {
                            count++;
                            int numColumns = rs.getMetaData().getColumnCount();
                            String outputLine = "";
                            for (int i = 1; i <= numColumns; i++) {
                                outputLine += rs.getString(i) + " ";
                            }
                            output.add(outputLine);
                        }
                    } finally {
                        try {
                            rs.close();
                        } catch (Throwable ignore) {
                        }
                    }
                }
                else {
                    output.add(stmt.execute(query)+"");
                }
            } finally {
                try {
                    stmt.close();
                } catch (Throwable ignore) {
                }
            }
        } catch(SQLException e){
            output.add("Failure");
        } finally {
            try { conn.close(); } catch (Throwable ignore) {}
        }
        return output;
    }
}
