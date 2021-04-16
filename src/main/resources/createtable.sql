

CREATE TABLE groups
(
    groupId         BIGINT AUTO_INCREMENT
    , name            VARCHAR(25) NOT NULL
    , direction       VARCHAR(25)
    , startDate       DATE
    , lastUpdatedTime TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    , entryTime       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    , CONSTRAINT GROUP_PK PRIMARY KEY (groupId)
);


CREATE TABLE lessons
(
    lessonId    BIGINT AUTO_INCREMENT
    , groupId     BIGINT
    , topic       VARCHAR(30)
    , description VARCHAR(5000)
    , materials   VARCHAR(5000)
    , scheduled   DATETIME
    , lastUpdated TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    , entryTime   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    , CONSTRAINT LESSONS_P PRIMARY KEY (lessonId)
    , CONSTRAINT LESSONS_GROUPS_GROUPID_FK FOREIGN KEY (groupId) REFERENCES GROUPS(groupId)
);

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
