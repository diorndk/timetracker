# XPHR Techincal Assignment

### Architecture Decision
For this project, I chose to use Layered Architecture. Because the application scope is relatively small, simple and more maintainable for this scope. Also, it easier to understand and to implement in a short period of time.

### Improvements
1. Had to add employee_code field to the employee model to uniquely identify employees since names can be duplicated.
2. Added foreign key constraints to the time_record table to ensure referential integrity with employee and project tables.
3. Implemented cascading deletes on foreign key relationships to maintain data integrity when related records are deleted