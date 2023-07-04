
File tree
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───asu
│   │   │           └───ResourceLab
│   │   │               ├───controller
│   │   │               ├───service
│   │   │               ├───repository
│   │   │               └───model
│   │   └───resources
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───org
│               └───asu
│                   └───ResourceLab
│                       ├───controller
│                       ├───service
│                       ├───repository
│                       └───model
```

- `model`: This is where  domain classes, which represent the application objects  (e.g., User, Resource, Booking).

- `repository`:  This package would contain classes responsible for performing the JDBC operations to the MySQL database.

- `service`: This package will contain classes that handle business logic. 

- `controller`: This is where Spring MVC controllers live. These classes handle incoming HTTP requests and return responses.

In the `resources` directory:

- `static`: This is where static resources like CSS, JavaScript, and image files.

- `templates`: This is where Thymeleaf templates go. Each template will correspond to a view in the web application.
