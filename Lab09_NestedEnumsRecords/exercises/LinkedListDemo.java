public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Tariro");
        names.add("Farai");
        names.add("Rudo");

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Size: " + names.size());

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("Sum: " + sum);
    }
}
