public class Pet {
    private int id;
    private String name;
    private int petID;

    public Pet(int id, String name, int petID) {
        this.id = id;
        this.name = name;
        this.petID = petID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPetID() {
        return petID;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petID=" + petID +
                '}';
    }
}
