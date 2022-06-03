select * from tb_address

INSERT INTO TB_ADDRESS VALUES (29, 24, 2, 'Phường 4', 'Hẻm 444 Trần Hưng Đạo');
commit

select * from tb_post order by createdon desc

select * from tb_user left join tb_address on tb_user.userid = tb_address.userid where tb_user.userid = 29

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
    :new.statusid := 1;
    :new.isdeleted := 0;
END;

