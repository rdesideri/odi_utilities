CREATE TABLE LIST_FILE_CTRL
(FILE_NAME VARCHAR2(200) CONSTRAINT PK_LIST_FILE_CTRL PRIMARY KEY USING INDEX(create unique index PK_LIST_FILE_CTRL on LIST_FILE_CTRL(FILE_NAME))
,SOURCE VARCHAR2(200)
,TARGET VARCHAR2(200)
,STATUS VARCHAR2(50)
,DT_LOAD DATE
,DT_LAST_UPDT DATE
 );