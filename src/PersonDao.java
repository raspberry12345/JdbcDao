public interface PersonDao {
    void create(int input1, int input2, int input3, String name);
    Person read( int input3);
    void update(int input2, int input3, String name);
    void delete(int input3);

}
