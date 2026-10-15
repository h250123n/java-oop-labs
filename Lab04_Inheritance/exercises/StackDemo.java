import java.util.ArrayList;

class BadStack extends ArrayList<Integer> {
    void push(int value) { add(value); }

    int pop() { return remove(size() - 1); }
}

class GoodStack {
    private final ArrayList<Integer> items = new ArrayList<>();

    void push(int value) { items.add(value); }

    int pop() { return items.remove(items.size() - 1); }

    int peek() { return items.get(items.size() - 1); }

    boolean isEmpty() { return items.isEmpty(); }

    int size() { return items.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        BadStack bad = new BadStack();
        bad.push(1);
        bad.push(2);
        bad.push(3);
        bad.add(0, 99);
        System.out.println("BadStack after add(0, 99): " + bad);
        System.out.println("BadStack get(1): " + bad.get(1));
        bad.remove(0);
        System.out.println("BadStack after remove(0): " + bad);

        GoodStack good = new GoodStack();
        good.push(1);
        good.push(2);
        good.push(3);
        System.out.println("GoodStack peek: " + good.peek());
        System.out.println("GoodStack pop: " + good.pop());
        System.out.println("GoodStack size: " + good.size());
    }
}
