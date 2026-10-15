# Library Management System (Lab 11 Mini-Project)

**Name:** Roland Machingambi | **Reg Number:** H250123N | **Department:** Software Engineering

A console application for lending books and DVDs.

## How to run

Requires JDK 17 or later. Run from this folder, because the saved data is read from and written to the `data` folder next to where you start the program.

```
javac *.java
java LibraryApp
```

`java LibraryDemo` runs a fixed scenario without any typing and prints every edge case (see `sample_output.txt`).
The `data` folder holds a small starting data set, which the program loads at start and saves back on exit (menu option 0).

## Menu

1. Add item
2. Register member
3. Borrow item
4. Return item
5. List overdue items
6. Search by title
7. List all items
8. List all members
0. Save and exit

## Requirements and where they are met

| Requirement | Where |
| --- | --- |
| Book, Member, Loan with private fields, validation and `toString` | `Book.java`, `Member.java`, `Loan.java` |
| Abstract `LibraryItem` with `Book` and `Dvd`, each with its own `loanPeriodDays()` | `LibraryItem.java`, `Book.java` (14 days), `Dvd.java` (7 days) |
| `Borrowable` interface with `borrow(Member)` and `giveBack()` | `Borrowable.java`, implemented by `LibraryItem` |
| Custom exceptions, maximum 3 loans per member | `ItemNotAvailableException.java`, `MemberLimitExceededException.java`, `Library.borrow` |
| Items and members stored in `Map<String, ...>` keyed by id | `Library.java` |
| CSV persistence, saved on exit and reloaded on start | `LibraryStorage.java`, `data/items.csv`, `data/members.csv`, `data/loans.csv` |
| Menu with add, register, borrow, return, overdue and search (streams) | `LibraryApp.java`; streams in `Library.findOverdue` and `Library.searchByTitle` |
| Polymorphism | `Loan.getDueDate()` and the listings call `loanPeriodDays()` through the `LibraryItem` reference |

Other files: `Library.java` (the core service), `Validate.java` (shared input checks), `LibraryDemo.java` (scripted demo).
Text fields cannot contain commas, because the data is stored as CSV.
