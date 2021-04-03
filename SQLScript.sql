

create schema PROJECT;

CREATE TABLE users
(
    userId          BIGINT AUTO_INCREMENT
    , role            VARCHAR(15) DEFAULT 'USER'
    , firstName       VARCHAR(30) NOT NULL
    , lastName        VARCHAR(30) NOT NULL
    , dateOfBirth     DATE
    , lastUpdatedTime TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    , entryTime       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    , CONSTRAINT USERS_PK PRIMARY KEY (userId)
);

CREATE TABLE userToGroup
(
    groupId         BIGINT NOT NULL
    , userId          BIGINT NOT NULL
    , role            VARCHAR(15) DEFAULT 'USER'
    , lastUpdatedTime TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    , entryTime       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    , CONSTRAINT UNIQUE_COMBINATION UNIQUE (groupId, userId)
);

-------------------------

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