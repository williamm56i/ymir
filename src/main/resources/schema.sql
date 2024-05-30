DROP TABLE IF EXISTS SYS_CODE;
DROP TABLE IF EXISTS SYS_USER;

CREATE TABLE SYS_CODE (
  SYS_GROUP VARCHAR(10) ,
  SYS_NAME VARCHAR(20) ,
  SYS_VALUE VARCHAR(250) ,
  MEMO VARCHAR(250) ,
  CREATE_ID VARCHAR(10) ,
  CREATE_DATE DATE ,
  UPDATE_ID VARCHAR(10) ,
  UPDATE_DATE DATE,
  PRIMARY KEY(SYS_GROUP,SYS_NAME)
);

CREATE TABLE SYS_USER (
    ACCOUNT VARCHAR(30),
    USER_NAME VARCHAR(100),
    EMAIL VARCHAR(100),
    CREATE_ID VARCHAR(10) ,
    CREATE_DATE DATE ,
    UPDATE_ID VARCHAR(10) ,
    UPDATE_DATE DATE,
    PRIMARY KEY(ACCOUNT)
)