public class Person {

    String name;
    Address address;

    public static void main(String[] args) {
        Address home = new Address();
        home.street = "12 Samora Machel Avenue";
        home.city = "Harare";

        Person p1 = new Person();
        p1.name = "Tendai";
        p1.address = home;
        System.out.println(p1.name + " lives in " + p1.address.city);

        Person p2 = new Person();
        p2.name = "Nyasha";

        try {
            System.out.println(p2.name + " lives in " + p2.address.city);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + p2.name + " has no address");
        }

        if (p2.address != null) {
            System.out.println(p2.address.city);
        } else {
            System.out.println("Safe check: " + p2.name + " has no address");
        }
    }
}
