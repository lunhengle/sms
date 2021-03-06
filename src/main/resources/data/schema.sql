/**创建个人表**/
CREATE TABLE USER (
  ID        BIGINT PRIMARY KEY,
  NAME      VARCHAR(50),
  PASSWORD  VARCHAR(50),
  ID_CARDS  VARCHAR(50),
  TELEPHONE VARCHAR(50),
  EMAIL     VARCHAR(50),
  ADDRESS   VARCHAR(200),
  STATUS    INT,
  ROLE_CODE INT,
  CREATED   DATE
);
/**档案表**/
CREATE TABLE ARCHIVES (
  ID             BIGINT PRIMARY KEY,
  USER_ID        BIGINT,
  SCHOOL_NAME    VARCHAR(200),
  SCHOOL_ADDRESS VARCHAR(200),
  TEACHER        VARCHAR(50),
  GRADE          VARCHAR(50),
  COMMENTS       VARCHAR(200),
  LEVELS         INT,
  CREATED        DATE
);
/**成绩表**/
CREATE TABLE ACHIEVEMENT (
  ID          BIGINT PRIMARY KEY,
  USER_ID     BIGINT,
  SUBJECT     VARCHAR(50),
  SCHOOL_YEAR VARCHAR(50),
  ACHIEVEMENT NUMERIC(10, 2),
  LEVELS      INT,
  CREATED     DATE
);
