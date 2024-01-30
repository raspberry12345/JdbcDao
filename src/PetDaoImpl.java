import java.sql.*;
import java.util.ArrayList;

public class PetDaoImpl implements PetDao{
    private String url = "jdbc:mysql://localhost:3306/hausverwaltung";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public PetDaoImpl(){
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
    public void create( int input3, String name) {

        String query = "insert into pet(name, person) values(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, input3);

            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Pet read(int input3) {


        String query = "select * from pet where id = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(query);
            Class.forName("com.mysql.cj.jdbc.Driver");

            ps.setInt(1, input3);
            ResultSet rs = ps.executeQuery();

            //rs.next();
            if (rs.next()) {
                return new Pet(rs.getInt("id"), rs.getString("name"), rs.getInt("person"));

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
        String table = "pet";

        String query = "UPDATE " + table + " SET name='" + name + "' where id=" + input3;

        try (
                Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int input3) {
        String query = "DELETE FROM pet WHERE id=" + input3;

        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
