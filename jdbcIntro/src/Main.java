import java.sql.*;
import java.util.ArrayList;

public class Main {
public static void main(String[] args) throws SQLException {

    Connection connection=null;
    DbHelper helper=new DbHelper();
    Statement statement=null;
    ResultSet resultSet;
    try{
        connection= helper.getConnection();
        statement=connection.createStatement();
        resultSet=statement.executeQuery("insert actor_id,first_name,last_name from actor");
        ArrayList<Actor> actors=new ArrayList<Actor>();//nesne arrayine veriyi atayabildik.
        while(resultSet.next()){
            actors.add(new Actor(
                    resultSet.getInt("actor_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")));
                /*System.out.print(resultSet.getInt("actor_id"));
                System.out.print("\t");
                System.out.print(resultSet.getString("first_name"));
                System.out.print("\t");
                System.out.print(resultSet.getString("last_name"));
                System.out.println();*/
        }
        System.out.println(actors.size());
        for(Actor a:actors){
            //isteresek döngü içinde listeyi yazdırırız.
        }
    } catch (SQLException e) {
        helper.showErrorMessage(e);
    }
    finally {
        connection.close();
    }
    }
    public static void selectDemo()throws SQLException{
        Connection connection=null;
        DbHelper helper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet;
        try{
            connection= helper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select actor_id,first_name,last_name from actor");
            ArrayList<Actor> actors=new ArrayList<Actor>();//nesne arrayine veriyi atayabildik.
            while(resultSet.next()){
                actors.add(new Actor(
                        resultSet.getInt("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
                /*System.out.print(resultSet.getInt("actor_id"));
                System.out.print("\t");
                System.out.print(resultSet.getString("first_name"));
                System.out.print("\t");
                System.out.print(resultSet.getString("last_name"));
                System.out.println();*/
            }
            System.out.println(actors.size());
            for(Actor a:actors){
                //isteresek döngü içinde listeyi yazdırırız.
            }
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}