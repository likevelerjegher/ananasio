# Ananasio: Calorie Tracker

Ananasio is a calorie tracker application built with Java Spring Boot. It allows users to manage dishes and ingredients, track their nutritional values, and monitor calorie intake.

## Features

- **Ingredient Management**: Add, update, delete, and retrieve ingredients.
- **Dish Management**: Add, update, delete, and retrieve dishes.
- **Nutritional Information**: Track calories, fats, carbs, proteins, and weight of ingredients.
- **Cross-Origin Resource Sharing (CORS)**: Configured to allow requests from `http://localhost:3000`.

## API Endpoints

### Ingredient Controller

- **GET** `/api/ingredient/{id}`: Get an ingredient by ID.
- **GET** `/api/ingredients/{name}`: Find ingredients by name.
- **GET** `/api/dishes/{dishId}/ingredients`: Get ingredients by dish ID.
- **GET** `/api/ingredients/{ingredientId}/dishes`: Get dishes by ingredient ID.
- **GET** `/api/ingredients`: Get all ingredients.
- **POST** `/api/ingredient`: Create a new ingredient.
- **POST** `/api/dishes/{dishId}/ingredient`: Add a new ingredient to a dish.
- **POST** `/api/dishes/{dishId}/ingredients/{ingredientId}`: Add an existing ingredient to a dish.
- **PUT** `/api/ingredients/{id}`: Update an ingredient.
- **PUT** `/api/ingredient/{id}`: Edit an ingredient.
- **DELETE** `/api/ingredients/{id}`: Delete an ingredient.
- **DELETE** `/api/dishes/{dishId}/ingredients/{ingredientId}`: Delete an ingredient from a dish.

### Dish Controller

- **GET** `/api/{id}`: Get a dish by ID.
- **GET** `/api/dishes`: Get all dishes.
- **GET** `/api/limit`: Get dishes with calories less than or equal to a specified limit.
- **POST** `/api`: Create a new dish.
- **POST** `/api/addDishes`: Save multiple dishes.
- **PUT** `/api/update/{id}`: Update a dish.
- **PUT** `/api/{id}`: Edit a dish.
- **DELETE** `/api/{id}`: Delete a dish.
- **DELETE** `/api/dishes`: Delete all dishes.

## Getting Started

### Prerequisites

- Java 11 or later
- Maven
- Spring Boot

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/ananasio.git
   cd ananasio
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`.

## Configuration

- The application is configured to allow CORS from `http://localhost:3000`.
- Swagger is used for API documentation. Access it at `http://localhost:8080/swagger-ui.html`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.
