

INSERT INTO GROUPS (NAME, DIRECTION, STARTDATE)
VALUES
('Java Basic', 'Back-end', '2021-01-01')
     , ('Java Elementary', 'Back-end', '2021-01-04');


INSERT INTO lessons (groupId, topic, description, scheduled) VALUES
(1, 'Introduction', 'Course introduction', '2021-01-01 14:00:00')
                                                                  ,  (1, 'Java', 'Java introduction', '2021-04-01 14:00:00')
                                                                  ,  (1, 'Primitives', 'Primitive types in Java', '2021-07-01 14:00:00');

INSERT INTO lessons (groupId, topic, description, scheduled) VALUES
    (2, 'Introduction', 'Course introduction', '2021-01-04 14:00:00')
        ,  (2, 'Java', 'Basics Recall', '2021-04-04 14:00:00')
        ,  (2, 'Loops and conditions', NULL, '2021-07-04 14:00:00')
        ,  (2, 'String', 'String and String builder', '2021-07-04 14:00:00');


INSERT INTO USERS (role, firstName, lastName, dateOfBirth)
VALUES  ('STUDENT', 'Bill',      'Doe',      '2001-2-1')
     , ('STUDENT', 'Ross',      'Brawn',    '1999-11-23')
     , ('STUDENT', 'Zak',       'Brown',    '1982-4-30')
     , ('STUDENT', 'Andreas',   'Sidle',    '1998-12-3')
     , ('STUDENT', 'Frank',     'Williams', '1999-1-22')
     , ('STUDENT', 'Mark',      'Webber',   '1982-3-4')
     , ('STUDENT', 'Sebastien', 'Vettel',   '1998-11-12')
     , ('STUDENT', 'Lewis',     'Hamilton', '1999-9-1')
     , ('STUDENT', 'Felipe',    'Massa',    '2001-5-28')
     , ('STUDENT', 'Fernando',  'Alonso',   '1997-7-30')
     , ('STUDENT', 'Carlos',    'Sainz',    '2003-10-6')
     , ('STUDENT', 'Lando',     'Norris',   '2000-11-8')
     , ('STUDENT', 'Susie',     'Wolf',     '2001-1-3');

INSERT INTO USERS (role, firstName, lastName, dateOfBirth)
VALUES  ('TEACHER', 'Kostia', 'Los',     '1991-1-1')
     , ('TEACHER', 'Steven', 'Hawking', '1945-9-23')
     , ('TEACHER', 'Alex',   'Big',   '1982-5-22');



INSERT INTO userToGroup (groupId, userId, role)
VALUES
(1, 1, 'STUDENT')
     , (1, 2, 'STUDENT')
     , (1, 3, 'STUDENT')
     , (1, 4, 'STUDENT')
     , (1, 5, 'STUDENT')
     , (1, 6, 'STUDENT')
     , (1, 7, 'STUDENT')
     , (1, 8, 'STUDENT')
     , (1, 9, 'STUDENT')
     , (1, 10, 'STUDENT')
     , (1, 11, 'STUDENT')
     , (1, 12, 'STUDENT')
     , (1, 13, 'STUDENT')
     , (1, 14, 'TEACHER')
     , (2, 14, 'MENTOR')
     , (2, 16, 'TEACHER');



