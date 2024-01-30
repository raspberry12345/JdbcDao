public class Person {
    private int id;
    private String name;
    private int householdId;

    public Person(int id, String name, int householdId) {
        this.id = id;
        this.name = name;
        this.householdId = householdId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHouseholdId() {
        return householdId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", householdId=" + householdId +
                '}';
    }
}
