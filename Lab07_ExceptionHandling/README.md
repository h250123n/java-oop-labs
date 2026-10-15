# Lab 7: Exception Handling

Each subfolder is compiled on its own: `cd programs` (or `cd exercises`), then `javac *.java`.

## programs (from the manual)
| Program | Run with | Files |
| --- | --- | --- |
| 7.1 try, catch, finally | `java ExceptionBasics` | ExceptionBasics.java |
| 7.2 Custom checked exception | `java Wallet` | InsufficientFundsException.java, Wallet.java |
| 7.3 try-with-resources and chaining | `java ResourceDemo` | ResourceDemo.java |

## exercises
| Level | Task | Run with |
| --- | --- | --- |
| Basic | read two integers, handle bad input and divide by zero | `java SafeDivide` (type the numbers when asked) |
| Basic | array access with `ArrayIndexOutOfBoundsException` | `java ArrayAccess` |
| Intermediate | checked `InvalidAgeException` and `validateAge` | `java AgeValidator` |
| Intermediate | Lab 3 `BankAccount` whose `withdraw` throws | `java BankDemo` |
| Challenge | `return` in `try` and a print in `finally` | `java FinallyDemo` |

## For your lab record (your part)
- Intermediate 2: discuss the trade-offs of `withdraw` throwing instead of returning `false`. Think about what the caller is forced to do, what happens if the caller ignores the result, and how much code the caller must write.
- Challenge: write your prediction for all three cases first, then run it. Explain why `finally` still runs after `return`, why case 2 returns 10 and not 99, and why case 3 is bad practice.
- Try `SafeDivide` with `10` and `0`, with `ten`, and with `10` and `2`. Note which catch block handled each.
