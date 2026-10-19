# Movie Database Management System

A **Java console-based movie database application** for exploring movie records, searching by different criteria, viewing production-company statistics, and adding new movies. The project uses object-oriented programming and text-file storage to manage a collection of movies.

## Features

### Movie search
- Search for a movie by **title**.
- Find movies by **release year**, **genre**, or **production company**.
- Filter movies by a **running-time range**.
- View movies selected by the application's **top-10 profit** calculation (revenue minus budget).

### Production-company information
- View the **most recent movies** from a production company.
- Find the company's **highest-revenue movies**.
- Calculate a company's **total movie profit** (revenue minus budget).
- List production companies along with the **number of movies** in the database for each.

### Movie management
- Add movie records from an interactive command-line menu.
- Load existing movie records from `movies.txt` at startup.
- Write the updated movie collection back to `movies.txt` when exiting through the menu.

## Technologies

- **Language:** Java
- **Core concepts:** Object-oriented programming, collections, file I/O, searching, and basic data processing
- **Storage:** Comma-separated plain-text file (`movies.txt`)
- **Interface:** Command-line menu

## Project Structure

```text
movie-database-project-main/
├── src/
│   ├── Movie.java           # Movie data model
│   ├── FileOperation.java   # File I/O, searches, and calculations; entry point
│   └── Menu.java            # Interactive console menu
├── movies.txt              # Sample movie records and persistent data
├── .idea/                  # IntelliJ IDEA project settings
└── Java project 108.iml    # IntelliJ IDEA module file
```

The repository also contains an `out/` directory with compiled Java class files.

## Getting Started

### Prerequisites

Install a **Java Development Kit (JDK)** and ensure that `java` and `javac` are available in your terminal. Alternatively, open the project in a Java IDE such as IntelliJ IDEA.

### Run from the terminal

1. Clone the repository and change into its directory:

   ```bash
   git clone <your-repository-url>
   cd movie-database-project-main
   ```

2. Compile the source files:

   ```bash
   javac -d out src/*.java
   ```

3. Run the application **from the project root**, where `movies.txt` is located:

   ```bash
   java -cp out FileOperation
   ```

> **Note:** The program uses the relative path `movies.txt` for loading and saving data. Keep that file in the current working directory when running the application.

### Run in IntelliJ IDEA

1. Open the project folder in IntelliJ IDEA.
2. Configure a JDK if prompted.
3. Open `src/FileOperation.java` and run its `main` method.
4. Set the working directory to the project root so the application can access `movies.txt`.

## Using the Application

The main menu provides four options:

```text
Main Menu:
1. Search Movies
2. Search Production Companies
3. Add Movie
4. Exit System
```

Select an option and follow the prompts in the terminal. For example, choose **Search Movies** to look up films by title, year, genre, company, or running time. Choose **Add Movie** to enter a new record. Use **Exit System** to save the current movie list to the text file.

## Data Format

Each line in `movies.txt` represents one movie in the following order:

```text
Title,ReleaseYear,Genre1,Genre2,Genre3,RunningTime,ProductionCompany,Budget,Revenue
```

Example from the included data:

```text
Toy Story,1995,Animation,Comedy,Family,81,Pixar Animation Studios,30000000,373554033
```

The application stores up to three genre fields for each movie. Some records leave genre fields blank. Running time, budget, and revenue are stored as integers.

## Source Code Overview

| File | Responsibility |
| --- | --- |
| `Movie.java` | Defines the movie attributes, getters, and display method. |
| `FileOperation.java` | Loads and writes movie records, implements search and statistical operations, and starts the application. |
| `Menu.java` | Handles user input and navigation through the movie and company menus. |

## Project Focus

This project demonstrates Java fundamentals through a practical, menu-driven application, including **classes and objects**, **lists and priority queues**, **text-file persistence**, and **searching and aggregating records**.
