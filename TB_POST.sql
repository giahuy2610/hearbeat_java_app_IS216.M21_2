----Create table Post
CREATE TABLE TB_POST
(
    POSTID INTEGER PRIMARY KEY,
    OWNERID INTEGER NOT NULL,
    PARTNERID INTEGER,
    STATUSID INTEGER NOT NULL,
    TITLE NVARCHAR2(255) NOT NULL,
    CONTENT NVARCHAR2(255) NOT NULL,
    CATEGORYID INTEGER NOT NULL,
    IMAGEPATH VARCHAR2(255),
    CREATEDON DATE NOT NULL,
    UPDATEDON DATE,
    PURPOSEID INTEGER NOT NULL,
    ISDELETED INTEGER NOT NULL
);

--create sequence 
CREATE SEQUENCE AUTO_INCREMENT_SEQUENCE_POST
START WITH 1
INCREMENT BY 1;

--table post
CREATE OR REPLACE TRIGGER TRIGGER_AUTOINCRE_TB_POST_POSTID
BEFORE INSERT ON
TB_POST
REFERENCING NEW AS NEW
    FOR EACH ROW BEGIN SELECT
    AUTO_INCREMENT_SEQUENCE_POST.NEXTVAL INTO :NEW.POSTID
    FROM DUAL;
END;

--FOREIGN KEY OF TABLE TB_POST
alter table TB_POST 
add constraint FK_POST_USER1 foreign key (OwnerId)
references TB_USER(UserId);

alter table TB_POST 
add constraint FK_POST_USER2 foreign key (PartnerID)
references TB_USER(UserId);

alter table TB_POST 
add constraint FK_POST_STATUS foreign key (StatusId)
references TB_PostStatus(StatusId);

alter table TB_POST 
add constraint FK_POST_CATEGORY foreign key (CategoryId)
references TB_CATEGORY(CategoryId);

alter table TB_POST 
add constraint FK_POST_PURPOSE foreign key (PurposeId)
references TB_PURPOSE(PurposeId);

INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (2, null, 1, 'Dư một bao 50kg gạo', 'Về quê mà còn bao gạo ngon 50kg, ai cần liên hệ mình tặng', 1, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (3, null, 1, 'Cần cho trứng', 'Gà nhà nuôi đẻ trứng nhiều ăn không hết, ai ăn trứng mình cho', 1, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (4, null, 1, 'Gây quỹ hỗ trợ trẻ em mồ côi do covid', 'Qũy từ thiện ABC gây quỹ hỗ trợ trẻ em mồ côi do covid. Dự kiến hỗ trợ 100 trẻ, giá trị 200 triệu. Ngày kết thúc: 5/5/2022', 6, NULL, sysdate, NULL, 3, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (2, null, 1, 'Xin sgk lớp 9', 'Em cần xin sách giáo khoa lớp 9 cho em của em. Ai có cho em xin ạ. Em cảm ơn.', 4, NULL, sysdate, NULL, 2, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (5, null, 1, 'Cho rau sạch', 'Rau vườn ai cần qua cắt ăn thoải mái', 1, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (6, null, 1, 'Tặng vitamin C', 'Mình dc tặng 1 lọ vitaminC không xài ', 3, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (6, null, 1, 'Xin sữa cho bé 5 tháng tuổi', 'Vợ chồng công nhân đang bị nợ lương nên rất khó khăn, mong được cô chú anh chị hỗ trợ ít sữa cho cháu.', 1, NULL, sysdate, NULL, 2, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (7, null, 1, 'Tặng sách giải tích, vật lí', 'Mình có dư sách giải tích 1 2, vật lí 1 2, em nào cần mình tặng', 4, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (4, null, 1, 'Tặng cà ri', 'Nay học nấu ăn, cà ri mình nấu ngon lắm, bạn nào qua ăn phụ mình mình cảm ơn', 5, NULL, sysdate, NULL, 1, 0);
INSERT INTO TB_POST (OWNERID,PARTNERID,STATUSID,TITLE,CONTENT,CATEGORYID,IMAGEPATH,CREATEDON,UPDATEDON,PURPOSEID,ISDELETED) VALUES (3, null, 1, 'Xin sách toeic', 'Có anh chị nào học xong toeic thì cho em xin hoặc mua lại ạ', 4, NULL, sysdate, NULL, 2, 0);