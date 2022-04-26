--Trigger thiết lập các giá trị mặc định cho dữ liệu bảng TB_USER
CREATE OR REPLACE TRIGGER TRIGGER_DEFAULT_VALUE_USER BEFORE 
    INSERT ON tb_user
    REFERENCING
        NEW AS new
    FOR EACH ROW
BEGIN
    SELECT
        current_date
    INTO :new.createdon
    FROM
        dual;

    :new.score := 0;
    :new.avatar := NULL;
    :new.isdeleted := 0;
END;
/

--tôi tạo thêm trigger này để lấy ngày tạo POST tự động
CREATE OR REPLACE TRIGGER TRIGGER_AUTOINCRE_TB_POST_CREATEDON
BEFORE INSERT ON
TB_POST
REFERENCING NEW AS NEW
    FOR EACH ROW BEGIN SELECT
    CURRENT_DATE INTO :NEW.CREATEDON
    FROM DUAL;
END;
/
