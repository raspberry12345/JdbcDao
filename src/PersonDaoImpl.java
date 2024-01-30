import java.sql.*;
import java.util.ArrayList;

public class PersonDaoImpl implements PersonDao{

    private String url = "jdbc:mysql://localhost:3306/hausverwaltung";
    private String username = "root";
    private String password = "";

    private Connection connection;
    public PersonDaoImpl(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void create(int input1, int input2, int input3, String name) {

        String query = "insert into person(name, household) values(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            if (input2 == 2 || input2 == 3) {
                ps.setInt(2, input3);
            }
            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Person read( int input3) {


        String query = "select * from person where id = ?";
        try {
            java.sql.Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = connection.prepareStatement(query);
            Class.forName("com.mysql.cj.jdbc.Driver");

            ps.setInt(1, input3);
            ResultSet rs = ps.executeQuery();

            //rs.next();
            if (rs.next()) {
                return new Person(rs.getInt("id"), rs.getString("name"),rs.getInt("household"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(int input2, int input3, String name) {


        String query = "UPDATE person SET name='" + name + "' where id=" + input3;

        try (
                Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int input3) {
        String query1 = "DELETE FROM pet WHERE person=" + input3;
        String query2 = "DELETE FROM person WHERE id=" + input3;

        try (
                Statement ps = connection.createStatement()) {
            ps.executeUpdate(query1);
            ps.executeUpdate(query2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
