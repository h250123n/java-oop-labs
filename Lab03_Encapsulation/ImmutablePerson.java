import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {

    private final String name;
    private final int age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public List<String> getHobbies() { return List.copyOf(hobbies); }

    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge, hobbies);
    }

    @Override
    public String toString() {
        return name + ", " + age + ", hobbies: " + hobbies;
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>(List.of("football", "chess"));
        ImmutablePerson p = new ImmutablePerson("Rudo", 20, hobbies);

        hobbies.add("swimming");
        System.out.println(p);

        try {
            p.getHobbies().add("gaming");
        } catch (UnsupportedOperationException e) {
            System.out.println("Hobbies cannot be changed through the getter");
        }

        ImmutablePerson older = p.withAge(21);
        System.out.println(p);
        System.out.println(older);
    }
}
