// Intermediate 1 (part 1): a custom CHECKED exception
public class InvalidAgeException extends Exception {
    private final int age;

    public InvalidAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    public int getAge() { return age; }
}
