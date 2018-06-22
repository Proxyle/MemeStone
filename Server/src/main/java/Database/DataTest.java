package Database;

public class DataTest {

    public static void main(String[] args){
        DataAccessLayerTemp dal = new DataAccessLayerTemp();
        dal.getCard(17);
        dal.getAllCards();
    }
}
