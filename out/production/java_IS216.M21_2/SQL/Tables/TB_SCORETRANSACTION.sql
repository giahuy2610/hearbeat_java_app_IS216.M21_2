----Create table ScoreTransaction
CREATE TABLE TB_SCORETRANSACTION
(
    SCORETRANSACTIONID INTEGER PRIMARY KEY,
    USERID INTEGER NOT NULL,
    CURRENTSCORE INTEGER NOT NULL,
    POSTID INTEGER NOT NULL
);
--Trigger tăng SCORETRANSACTIONID tự động
CREATE SEQUENCE AUTO_INCREMENT_SEQUENCE_SCORETRANSACTION
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIGGER_AUTOINCRE_TB_SCORETRANSACTION_SCORETRANSACTIONID
BEFORE INSERT ON
TB_SCORETRANSACTION
REFERENCING NEW AS NEW
    FOR EACH ROW BEGIN SELECT
    AUTO_INCREMENT_SEQUENCE_SCORETRANSACTION.NEXTVAL INTO :NEW.SCORETRANSACTIONID
    FROM DUAL;
END;

--FOREIGN KEY OF TABLE TB_ScoreTransaction
alter table TB_ScoreTransaction 
add constraint FK_STRAN_USER foreign key (UserId)
references TB_USER(UserId);

alter table TB_ScoreTransaction 
add constraint FK_STRAN_POST foreign key (PostId)
references TB_POST(PostId);