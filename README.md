# AdvancedJavaDIO
Advanced Java content from Digital Innovation One course.

In this course, we can study topics such as:

## Part 1:
- Basic Function
- Function Composition
- Anonymous Class Function
- Lambda Function
- Pure Functions
- Immutability
- Factorials (Factorial Memorization and Recursive Factorial)

## Part 2:
- Consumer
- Function
- Higher Order Function
- Iterations
- Predicate
- Supplier

## Part 3:
- Future
- Parallel Stream
- Threads

## Part 4:
- Java Inference

## Part 5:
- Collections
- HttpClient
- Inferential Lambda
- String Operations

## Modular calculator
A module is more like an independent partition of software that is communicated through an interface. Modularity explores the creation of a program by using different modules than a single legacy architecture.

We can exemplify that with the modular calculator in this repository. There are 7 files in its package:
- Main (for testing);
- Operation: which is an interface that shows the operation method in a more generic manner;
- Calculator: a class that represents a calculator;
- DivImpl, MultImpl, SubImpl, SumImpl: they are all classes that implement the Operation interface. As I mentioned above, the interface represents an opertation in a more general way, and with these classes, this operation can be implemented more specifically in many different ways.
