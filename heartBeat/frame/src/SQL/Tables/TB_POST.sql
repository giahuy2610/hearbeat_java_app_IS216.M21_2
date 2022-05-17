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

-- Insert dữ liệu mẫu cho bảng
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
commit;
--Trigger thiết lập các giá trị mặc định cho dữ liệu bảng TB_Post
CREATE OR REPLACE TRIGGER trigger_default_value_post BEFORE
    INSERT ON tb_post
    REFERENCING
        NEW AS new
    FOR EACH ROW
BEGIN
    SELECT
        current_date
    INTO :new.createdon
    FROM
        dual;

    :new.partnerid := NULL;
    :new.updatedon := NULL;
    :new.imagepath := NULL;
    :new.statusid := 1;
    :new.isdeleted := 0;
END;

-- trigger điểm nhân ái được tự động tăng khi bài viết chuyển sang trạng thái thành công
CREATE OR REPLACE TRIGGER TRIGGER_ADD_SCORE AFTER
    UPDATE ON tb_post
    REFERENCING
        OLD AS old
        NEW AS new
    FOR EACH ROW
BEGIN
    IF (:NEW.STATUSID = 3 AND :NEW.PURPOSEID = 1) THEN
        --nếu trạng thái thành công (status = 3) và mục đích của
        --bài đăng là để trao/tặng thì cộng điểm cho chủ bài viết(người cho đi)
        UPDATE TB_USER
        SET TB_USER.SCORE = TB_USER.SCORE + 10
        WHERE TB_USER.USERID = :NEW.OWNERID;
        execute p_insert_notification( tb_user,
            'Bạn đã được cộng 10 điểm cho việc giúp đỡ thành công một người, hãy tiếp tục nhé');
    ELSIF (:NEW.STATUSID = 3 AND :NEW.PURPOSEID = 2) THEN
        --nếu trạng thái thành công (status = 3) và mục đích của
        --bài đăng là để xin/nhận thì cộng điểm cho người đặt hẹn(người tặng)
        UPDATE TB_USER
        SET TB_USER.SCORE = TB_USER.SCORE + 10
        WHERE TB_USER.USERID = :NEW.PARTNERID;
    END IF;
END;

--trigger kiểm tra partnerid khác ownerid
CREATE OR REPLACE TRIGGER TRIGGER_POST_OWNER_PARTNER BEFORE
    UPDATE ON tb_post--mới thêm bài viết thì không thể có partnerid nên không xét before insert
    REFERENCING
        OLD AS old
        NEW AS new
    FOR EACH ROW
BEGIN
    IF ( :NEW.PARTNERID = :NEW.OWNERID ) THEN
    raise_application_error (-20000, 'Chủ bài viết và người đặt hẹn phải khác nhau');
    END IF;
END;

--trigger điều kiện: khi một bài viết ở trạng thái đang chờ thì không thể có partnerid
CREATE OR REPLACE TRIGGER TRIGGER_POST_STATUS_PARTNER BEFORE
    INSERT OR UPDATE ON tb_post
    REFERENCING
        OLD AS old
        NEW AS new
    FOR EACH ROW
BEGIN
    IF ( :NEW.statusid = 1 AND :NEW.PARTNERID <> NULL ) THEN
        raise_application_error (-20000, 'Bài viết có người đặt hẹn thì không thể là trạng thái "đang chờ"');
    END IF;
END;