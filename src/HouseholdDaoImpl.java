import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseholdDaoImpl implements HouseholdDao {

    private String url = "jdbc:mysql://localhost:3306/hausverwaltung";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public HouseholdDaoImpl(){
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
    public void create(  String name) {

        String query = "insert into household(name) values(?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);

            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Household read( int input3) {
        String query = "select * from household where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            Class.forName("com.mysql.cj.jdbc.Driver");

            ps.setInt(1, input3);
            ResultSet rs = ps.executeQuery();

            //rs.next();
            if (rs.next()) {
                return new Household(rs.getInt("id"), rs.getString("name"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update( int input3, String name) {
        String query = "UPDATE household SET name=? where id=?";
        try (
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, input3);
            ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete( int input3) {
        String query2 = "DELETE FROM person WHERE id=?";
        String query1 = "SELECT * FROM person WHERE household=?";
        String query3 = "DELETE FROM pet WHERE person=?";
        String query4 = "DELETE FROM household WHERE id=?";

        ArrayList<Integer> getPersonId = new ArrayList<Integer>();


        try(PreparedStatement ps = connection.prepareStatement(query1)){
            ps.setInt(1, input3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getPersonId.add(rs.getInt("id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //haustiere löschen
        try(PreparedStatement ps = connection.prepareStatement(query3)){
            int listPosition=0;
            while(listPosition != getPersonId.size()){
                ps.setInt(1, getPersonId.get(listPosition));
                ps.executeUpdate();
                listPosition++;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //personen löschen
        try(PreparedStatement ps = connection.prepareStatement(query2)){
            int listPosition=0;
            while(listPosition != getPersonId.size()){
                ps.setInt(1, getPersonId.get(listPosition));
                ps.executeUpdate();
                listPosition++;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //haushalt löschen
        try (PreparedStatement ps = connection.prepareStatement(query4)) {
            ps.setInt(1,input3);
            ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Household> showHouseholds(){
        String query = "select * from household";
        List<Household> households = new ArrayList<>();
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(query);
            //rs.next();
            while (rs.next()) {
                households.add(new Household(rs.getInt("id"), rs.getString("name")));

            }
            return households;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}
