# XPHR Techincal Assignment

### Architecture Decision
For this project, I chose to use Layered Architecture. Because the application scope is relatively small, simple and more maintainable for this scope. Also, it easier to understand and to implement in a short period of time.

### Improvements
1. Had to add employee_code field to the employee model to uniquely identify employees since names can be duplicated.
2. Added foreign key constraints to the time_record table to ensure referential integrity with employee and project tables.
3. Implemented cascading deletes on foreign key relationships to maintain data integrity when related records are deleted
4. Changed the date validation in the controller when date is null.
5. Updated the sample data dates to 2025 to align with the query requirements.
6. Added service layer to separate business logic from controller and repository layers.

### Challenges
1. This is the first time I'm using in memory authentication with Spring Security, so I had to do some research and trial and error to get it working as expected.
2. The provided repository example in the PDF uses EXTRACT function which will cause error. Hence, I decided to use native query instead JPQL to avoid that issue.

### In memory authentication
For In Memory authentication, I'm using Spring Security UserDetailsService and InMemoryUserDetailsManager to setup user password and roles. I decided to created username column in the DB so this can be used for login and to filter the time records as well. The system will do checking based on the roles assigned to the user. If the user has ADMIN role, they can access all time records, otherwise they can only access their own time records.