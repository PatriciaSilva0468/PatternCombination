# PatternCombination

README file - Justification for the chosen creational patterns
The creational designs patterns chosen here focus on the efficiency of the code increasing the elasticity and reuse of the existing application.

Data Access Object Pattern (DAO)
DAO Pattern - Country.java contains the model and IcountryDAO.java is an interface for countryDAOimplement to use and create the methods there.
The DAO Pattern is basically an interface that provides access to the database in Workbench. It abstracts the process of getting information from a data resource, in this case, the database. The idea is to isolate a data source's client interface from its data access mechanism. The issue with accessing the data straight away is that the basis of the data can change.
Singleton Pattern
The Singleton Pattern was used to create the only instance of the database. This creational pattern promises one instance of class and provides single universal access point to it. It is basically a single place that you can call from every piece of your code. However, this might break one of the essentials of programming language that it is the encapsulation principle. 
To solve that, when creating the Singleton Pattern, you must provide private fields that will store the reference to one single instance that it is created. No code should have access to a piece of code that it is not related to it.
The Singleton Pattern has a private constructor so it is not possible to create an instance from outside of the class and there is the static get instance method that basically does the initialization of this private field so it will create the object for the first and last time and will return the actual interface to the user.
MVC Implementation 
MVC was implemented to be able to list countries - countryController.java uses clientProgram.java to create and list. If it is in the list, use the view and the DAOimplement. If it is created, just DAOimplement. MVC architectural pattern divides a program into three main components: Model, View, and Controller.

Model is the information needed to show in the view. Model characterizes as a collection of classes that defines the business logic. It also shows how the data can be modified and handle overall.
The View in this case is the UI components such as XML, HTML. View shows the information that is received from the controller as the result. Model and View interact with each other using the Observer pattern.
Finally, the Controller process all incoming requests. It processes the user’s data through the Model and sending back the results to View. It is a mediator between the View and the Model.

References
Sinhal, A. (2017). MVC, MVP and MVVM Design Pattern. M, 3rd January. Available at: https://medium.com/@ankit.sinhal/mvc-mvp-and-mvvm-design-pattern-6e169567bbad [Accessed 26th March 2020].
Smok. (2019). Factory, Builder, Singleton... Creational Design Patterns!. Available at: https://www.youtube.com/watch?v=VCxNt2K7aVY [Accessed 5th April 2020].
Stackoverflow. (2010). Difference between singleton and factory pattern. Available at: https://stackoverflow.com/questions/2094211/difference-between-singleton-and-factory-pattern [Accessed 5th April 2020].
Tutorialspoint. (2020). Data Access Object Pattern. Available at: https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm [Accessed 5th April 2020].



