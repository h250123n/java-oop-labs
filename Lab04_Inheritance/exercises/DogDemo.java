class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }
}

// This version does not compile: Animal has no no-argument constructor,
// so the implicit super() call fails.
//
// class Dog extends Animal {
//     Dog() {
//         System.out.println("Dog constructor");
//     }
// }
//
// error: constructor Animal in class Animal cannot be applied to given types

class Dog extends Animal {
    Dog(String name) {
        super(name);
        System.out.println("Dog constructor");
    }
}

public class DogDemo {
    public static void main(String[] args) {
        new Dog("Rex");
    }
}
