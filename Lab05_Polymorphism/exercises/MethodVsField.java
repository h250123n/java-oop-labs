class Parent {
    String label = "parent field";
    String who() { return "parent method"; }
}

class Child extends Parent {
    String label = "child field";
    @Override String who() { return "child method"; }
}

public class MethodVsField {
    public static void main(String[] args) {
        Parent p = new Child();

        System.out.println("p.who()   -> " + p.who());
        System.out.println("p.label   -> " + p.label);

        Child c = (Child) p;
        System.out.println("c.who()   -> " + c.who());
        System.out.println("c.label   -> " + c.label);
    }
}
