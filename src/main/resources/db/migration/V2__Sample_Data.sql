INSERT INTO employee (id, name) VALUES 
    (101, 'Tom'), 
    (102, 'Jerry');

INSERT INTO project (id, name) VALUES 
    (1, 'Sample Project A'), 
    (2, 'Sample Project B');

/*
    Updated the date to October 2025 to adjust with the given query
*/
INSERT INTO time_record (id, employee_id, project_id, time_from, time_to) VALUES 
    (1, 101, 1, '2025-10-28 08:00:00', '2025-10-28 17:00:00'), 
    (2, 102, 2, '2025-10-28 09:00:00', '2025-10-28 18:30:00'), 
    (3, 101, 1, '2025-10-29 08:15:00', '2025-10-29 17:10:00');