public interface PetDao {
    void create( int input3, String name);
    Pet read( int input3);
    void update(int input2, int input3, String name);
    void delete(int input3);

}
