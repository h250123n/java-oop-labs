public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Peek: " + numbers.peek());
        System.out.println("Pop: " + numbers.pop());
        System.out.println("Pop: " + numbers.pop());
        System.out.println("Size: " + numbers.size());

        Stack<String> words = new Stack<>();
        words.push("first");
        words.push("second");
        System.out.println("Pop: " + words.pop());
        System.out.println("Empty? " + words.isEmpty());
        words.pop();
        System.out.println("Empty? " + words.isEmpty());

        try {
            words.pop();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
