import java.util.ArrayList;
import java.util.List;

public interface HouseholdDao {



    void create( String name);
    Household read(int input3);
    void update( int input3, String name);
    void delete( int input3);
    List<Household> showHouseholds();


}
