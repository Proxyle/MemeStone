package Database;

import java.sql.*;

public class DataAccessLayerTemp {

    String connectionString = "jdbc:sqlserver://mssql.fhict.local;database=dbi341449;user=dbi341449;password=i like trains;loginTimeout=5;";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = null;

    public DataAccessLayerTemp() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.DriverJDBCVersion");
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getCard(int id){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.DriverJDBCVersion");
            connection = DriverManager.getConnection(connectionString);
            //statement = connection.prepareStatement("SELECT card_id, name, manacost, attackpoints, healthpoints, minion FROM Card WHERE card_id = ?");
            //statement.setInt(1, id);
            String sql = "SELECT card_id, name, manacost, attackpoints, healthpoints, minion FROM Card WHERE card_id = " + id;
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int card_id = resultSet.getInt("card_id");
                String name = resultSet.getString("name");
                int manacost = resultSet.getInt("manacost");
                int attackpoints = resultSet.getInt("attackpoints");
                int healthpoints = resultSet.getInt("healthpoints");
                boolean minion = resultSet.getBoolean("minion");

                System.out.println(card_id + ", " + name + ", " + manacost + " cost, " + attackpoints + " DMG, " + healthpoints + " HP, " + minion + " minion");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (connection != null){
                try {
                    connection.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public void getAllCards(){

    }

}
