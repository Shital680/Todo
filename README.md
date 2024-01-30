# Todo Web Application
Meet Todo, a dynamic full-stack web app powered by Java, Spring, and Spring Boot. Seamlessly connecting to a MySQL database through Spring Data JPA, it ensures efficient data management. For security, Spring Security is in place, providing robust authorization. The sleek interface is crafted using Bootstrap, offering a polished user experience. Maven is employed as the build tool, while Hibernate efficiently maps tables. To enhance scalability and deployment, Docker containers are leveraged, ensuring a smooth and responsive Todo application.

## Project Structure
```
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |   |  |-- learning/
|   |   |  |  |-- springboot/
|   |   |  |  |  |-- toDoWebApp/
|   |   |  |  |  |  |-- login/
|   |   |  |  |  |  |  |-- WelcomeController.java/
|   |   |  |  |  |  |-- security/
|   |   |  |  |  |  |  |-- SpringSecurityConfiguration.java/
|   |   |  |  |  |  |-- Todo/
|   |   |  |  |  |  |  |-- ToDo.java/
|   |   |  |  |  |  |  |-- ToDoControllerJpa.java/
|   |   |  |  |  |  |  |-- ToDoRepository.java/
|   |   |  |  |  |  |-- ToDoWebAppApplication.java/
pom.xml
```

## Features

🔐 **Login** : Sign in securely using your personalized username and password.

🚀 **Authorization** : Once validated, seamlessly unlock access to your personalized home page.

➕ **Adding Todo** : Effortlessly expand your task list by adding new to-dos with just a few clicks.

✏️ **Updating Todo** : Stay on top of your tasks by easily updating and modifying existing to-dos.

🗑️ **Delete** : Streamline your task management by swiftly deleting any unwanted to-dos.

👋 **Logout** : Wrap up your productivity session with a simple logout, ensuring your tasks are secure.

## Technologies Used

- **Java** : The backbone for fundamental operations, providing a solid foundation for development.
- **Spring Boot**:  Empowering the project with a robust and streamlined framework for application development.
- **Spring Framework** : Leveraging core components to enhance the efficiency and functionality of the application.
- **Spring Data Jpa** : Ensuring seamless database connections and operations, simplifying data management.
- **Spring Security** : Safeguarding the application with user authentication and authorization features.
- **Hibernate** : Facilitating data mapping, making it easier to interact with and manage databases.
- **Mysql** : Serving as the database backend, supporting efficient storage and retrieval of project data.

