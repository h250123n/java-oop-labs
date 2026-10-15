# Lab 6: Abstraction, Abstract Classes and Interfaces

Each subfolder is compiled on its own: `cd programs` (or `cd exercises`), then `javac *.java`.

## programs (from the manual)
| Program | Run with | Files |
| --- | --- | --- |
| 6.1 Abstract class | `java VehicleDemo` | Vehicle.java, VehicleDemo.java |
| 6.2 Interfaces and default methods | `java InterfaceDemo` | InterfaceDemo.java |
| 6.3 Comparable | `java ComparableDemo` | ComparableDemo.java |

The manual puts `VehicleDemo` inside `Vehicle.java`, but a public class must be in a file with its own name, so it is split into two files.

## exercises
| Level | Task | Run with |
| --- | --- | --- |
| Basic | abstract `Shape` with `Circle`, `Rectangle`, `Square` | `java ShapeDemo` |
| Basic | `Flyable` for `Bird` and `Aeroplane` (no shared superclass) | `java FlyDemo` |
| Intermediate | abstract `Account` with `SavingsAccount`, `CurrentAccount` | `java AccountDemo` |
| Intermediate | `Student` is `Comparable` by name, plus a `Comparator` by marks | `java StudentSortDemo` |
| Challenge | two interfaces with the same default method | `java DefaultConflictDemo` |

## For your lab record (your part)
- Abstract class versus interface: write the difference in your own words, and say which one you used for `Shape`, `Flyable` and `Account`, and why.
- Why `Square extends Rectangle` works here, and why `Bird` and `Aeroplane` could not share an abstract class.
- Challenge: what happens if you delete the `hello()` override in `Receptionist`? Try it and copy the compiler error. Then explain what `Greeter.super.hello()` means.
