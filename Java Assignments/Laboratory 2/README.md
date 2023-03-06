# Laboratory 2 - Week 2

**Lab assignment**

A.	Write a Java class with at least three instance attributes of different types. For example, Car with the following attributes: a manufacturer, a model, maximum speed, a price and a manufacturing year. This is only an example, please choose your own type. Implement the constructors, setters and getters, and other required methods (e.g. toString(), equals()). Make sure that your entity class implements the Comparable interface.

B.	Create a generic repository and provide an iterator for it. In addition, create and a method that returns all its elements. Write a program that displays the list of all objects and then computes different kinds of information. For example, for a collection of cars, the program prints the following information:
-	all cars, sorted by price (use the *Collections.sort()* function and take advantage of the fact that your entity is a *Comparable*).
-	the fastest car;
-	the models manufactured by a given manufacturer.

For testing, you will create some objects in the main function and add them to the repository.


---

**Home assignment**

Choose one of the problems below and provide a layered architecture solution (in Java). Requirements necessary for the next lab:
-	The layers should be: domain, repository, service, UI. Use Java packages.
-	For the repository part use interfaces or abstract classes. The repository should be generic.
-	Add at least 5 entities of each type in your memory repository (from source code).
-	All entities should be identifiable (use a generic superclass/interface Identifiable) and unique.
-	Add basic data validation and use the exception mechanism in Java for exceptional situations. Show messages in case of such situations.
-	The UI must allow CRUD operations for at least one of the entities.

1. Design and implement a Java solution for managing the appointments to a dentist. The program should allow CRUD operations for patients, adding a new appointment, cancelling an appointment, creating different reports, etc.
2. Design and implement a Java solution for managing the orders for birthday-cakes from a cake-shop. The program should allow CRUD operations for birthday-cakes, adding a new order, cancelling an order, finishing an order, creating different reports, etc.
3. Design and implement a Java solution for managing the reservations for car rentals. The program should allow CRUD operations for cars, creating a reservation (rental), cancelling a reservation, creating different reports, etc.
