// Intermediate 1 (part 2): validateAge throws the checked exception for 0..120 violations
public class AgeValidator {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120, got " + age, age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, -5, 130, 0, 120};
        for (int age : tests) {
            try {
                validateAge(age);                 // checked: the compiler forces us to handle it
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}
