# XPHR Technical Assignment

## Task 1 Database Query Optimization
For this task, I created a separate PDF file named "Database_Query_Optimization.pdf" in the docs folder. It contains the optimized SQL query along with explanations of the EXPLAIN ANALYZE result, the bottlenect and the optimize query.

## Task 2 JSP-based Reporting Page
For this task, I have implemented a JSP-based reporting page that allows users to filter time records based on the date. For further explaination about the implementation, please refer to the "docs/Explaination.md" file.

### Technologies Used
- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security
- JSP
- Bootstrap 5
- Maven
- PostgreSQL
- SLF4J
- Lombok
- Flyway

## How to Run the Application
### Start PostgreSQL with Docker
```bash
docker-compose up -d
```

This will start:
- PostgreSQL database on port `5432`
- pgAdmin on port `5050` (optional, to query via pgAdmin UI)

### Run the Application

**Option A: Using Maven**
```bash
mvn clean spring-boot:run
```

**Option B: Using WAR file**
```bash
mvn clean package
java -jar target/timetracker-0.0.1-SNAPSHOT.war
```

### Access the Application
Open your browser: http://localhost:8080

The database tables and sample data will be created automatically by Flyway once the application is up and running.

To access the reporting page, you can use the following credentials:

**Admin Access (view all records):**
- Username: `admin`
- Password: `admin123`

**Employee Access (view own records only):**
- Username: `EMP0001`, Password: `emp0001`
- Username: `EMP0002`, Password: `emp0002`
- Username: `EMP0003`, Password: `emp0003`
- Username: `EMP0004`, Password: `emp0004`

After login, you can play around with the date filter on the reporting page to see the time records.