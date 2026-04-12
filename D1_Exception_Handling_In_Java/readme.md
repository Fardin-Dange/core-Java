# 📘 D1 — Exception Handling in Java

> **Core Java Series** 
> 👨‍💻 Author: [Fardin-Dange](https://github.com/Fardin-Dange)

---

## 📌 What is an Exception?

An **Exception** is an unexpected situation that **stops the normal flow** of a program during execution.

```java
// Without Exception Handling — Program CRASHES 💥
int result = 10 / 0;
System.out.println("This line never runs!");

// With Exception Handling — Program runs SAFELY ✅
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
System.out.println("Program continues safely!");
```

---

## 🏗️ Exception Hierarchy

```
Throwable
├── Error                        ← JVM level problem (unrecoverable)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception                    ← Code level problem (recoverable)
    ├── Checked Exception        ← Compiler forces you to handle
    │   ├── IOException
    │   ├── SQLException
    │   └── FileNotFoundException
    │
    └── RuntimeException         ← Unchecked — occurs at runtime
        ├── ArithmeticException
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        └── NumberFormatException
```

---

## ⚡ Error vs Exception

| | Error | Exception |
|---|---|---|
| Who creates it | JVM itself | JVM or your code |
| Recoverable | ❌ No | ✅ Yes |
| Should you handle | ❌ No point | ✅ Yes |
| Example | `OutOfMemoryError` | `ArithmeticException` |

---

## ✅ Checked vs Unchecked Exception

| | Checked | Unchecked |
|---|---|---|
| When detected | Compile time | Runtime |
| Handling | Mandatory | Optional |
| Extends | `Exception` directly | `RuntimeException` |
| Example | `FileNotFoundException` | `NullPointerException` |

> 💡 **Simple Rule** — If a class extends `RuntimeException` → Unchecked. Everything else → Checked.

---

## 🔑 5 Keywords

| Keyword | Purpose |
|---|---|
| `try` | Wrap the risky code |
| `catch` | Handle the exception |
| `finally` | Always executes (exception or not) |
| `throw` | Manually throw an exception |
| `throws` | Declare exception in method signature |

---

## 💻 Code Examples

### 1. Basic try-catch

```java
public class TryCatchDemo {
    public static void main(String[] args) {

        System.out.println("Step 1");

        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("Step 2"); // This runs ✅
    }
}
```

**Output:**
```
Step 1
Caught: / by zero
Step 2
```

---

### 2. Multiple catch Blocks

```java
public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length()); // NullPointerException

        } catch (NullPointerException e) {
            System.out.println("Null value found!");

        } catch (ArithmeticException e) {
            System.out.println("Math error!");

        } catch (Exception e) {
            // Safety net — always last!
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
```

> ⚠️ **Rule** — Specific exceptions first, `Exception e` always last!  
> If `Exception e` is written first → **Compile Error!** (Unreachable code)

---

### 3. Exception Object Methods

```java
catch (ArithmeticException e) {
    e.getMessage();      // Only the message
    e.toString();        // Class name + message
    e.printStackTrace(); // Full detail with line number
}
```

---

## 🧠 Key Concepts to Remember

**1. How does JVM know which Exception to create?**  
JVM has built-in rules written by Java creators — every situation maps to a specific Exception class.

**2. Why can't compiler catch RuntimeException?**  
Compiler only reads CODE, not DATA. Runtime exceptions depend on data that only exists when the program runs (user input, etc.).

**3. Why write `Exception e` last?**  
It acts as a **safety net** — catches any unexpected exception that wasn't handled by specific catch blocks.

**4. Why use Multiple catch instead of single `Exception e`?**  
Different exceptions need different responses. Single catch gives a generic message — multiple catch gives the user the exact problem.

---

## ❓ Interview Questions

**Q1. What is the difference between Error and Exception?**  
Both stop the normal flow, but Exception is **recoverable** and can be handled. Error is a **JVM level problem** and cannot be recovered.

**Q2. What is Checked and Unchecked Exception?**  
Checked — compiler forces handling at compile time (e.g. `FileNotFoundException`).  
Unchecked — occurs at runtime, handling is optional (e.g. `NullPointerException`).

**Q3. Can we catch an Error?**  
Technically yes, but we should not. When an Error occurs, JVM itself is broken — catching it serves no purpose.

**Q4. Why does `Exception e` always go last in multiple catch?**  
Because `Exception` is the parent of all exceptions. If placed first, it catches everything — making specific catch blocks unreachable, causing a **Compile Error**.

**Q5. When does StackOverflowError occur?**  
When a method keeps calling itself infinitely — the call stack gets full.

```java
public static void hello() {
    hello(); // infinite recursion → StackOverflowError
}
```

---



