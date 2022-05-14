CREATE TABLE TB_STATEMENT (
STATEMENTID INTEGER PRIMARY KEY,
POSTID INTEGER NOT NULL,
USERID INTEGER NOT NULL,
TOTAL INTEGER NOT NULL,
CREATEDON DATE NOT NULL
)

CREATE SEQUENCE AUTO_INCREMENT_SEQUENCE_STATEMENT
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER TRIGGER_AUTOINCRE_TB_STATEMENT_STATEMENTID
BEFORE INSERT ON
TB_STATEMENT
REFERENCING NEW AS NEW
    FOR EACH ROW BEGIN SELECT
    AUTO_INCREMENT_SEQUENCE_STATEMENT.NEXTVAL INTO :NEW.STATEMENTID
    FROM DUAL;
END;


alter table TB_STATEMENT
add constraint FK_STATEMENT_POSTID foreign key (POSTId)
references TB_POST(POSTId);

alter table TB_STATEMENT
add constraint FK_STATEMENT_USERID foreign key (USERId)
references TB_USER(USERId);

CREATE OR REPLACE TRIGGER trigger_default_value_statement BEFORE
    INSERT ON tb_statement
    REFERENCING
        NEW AS new
    FOR EACH ROW
BEGIN
    SELECT
        current_date
    INTO :new.createdon
    FROM
        dual;
END;