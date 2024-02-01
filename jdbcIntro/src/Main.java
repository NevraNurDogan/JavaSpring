import java.sql.*;
import java.util.ArrayList;

public class Main {
public static void main(String[] args) throws SQLException {

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
    public static void insertData() throws SQLException {
        Connection connection=null;
        DbHelper helper=new DbHelper();
        PreparedStatement statement=null;
        try{
            connection= helper.getConnection();
            String sql="INSERT INTO actor (first_name, last_name) VALUES (?,?);";
            statement=connection.prepareStatement(sql);
       /*         ("INSERT INTO actor (first_name, last_name) VALUES ('ccc', 'bbb');");
        //      ("INSERT INTO actor (first_name, last_name) VALUES (?,?);");normalde kullnıcıdan giriş alınır
      */
            statement.setString(1,"nevra");
            statement.setString(2,"dogan");
            int result=  statement.executeUpdate();//çalıştır
            System.out.println("Kayıt eklendi.");

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
    public static void updateData() throws SQLException {
        Connection connection=null;
        DbHelper helper=new DbHelper();
        PreparedStatement statement=null;
        try{
            connection= helper.getConnection();
            String sql="update actor set first_name='vera' where actor_id =?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,206);
            int result=  statement.executeUpdate();//çalıştır
            System.out.println("Kayıt güncellendi.");

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
    public static void deleteData() throws SQLException {
        Connection connection=null;
        DbHelper helper=new DbHelper();
        PreparedStatement statement=null;
        try{
            connection= helper.getConnection();
            String sql="delete from actor where actor_id =?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,207);
            int result=  statement.executeUpdate();//çalıştır
            System.out.println("Kayıt silindi.");

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
}