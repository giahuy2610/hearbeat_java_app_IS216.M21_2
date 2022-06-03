
--procedure cập nhật thông tin cá nhân
CREATE OR REPLACE PROCEDURE p_update_account (
    userid_in tb_user.userid%type,
    firstname_in    tb_user.firstname%TYPE,
    lastname_in     tb_user.lastname%TYPE,
    gender_in      tb_user.gender%TYPE,
    dateofbirth_in  tb_user.dateofbirth%TYPE,
    cityid_in tb_address.cityid%type,
    districtid_in tb_address.districtid%TYPE,
    address_in tb_address.address%type
) AS
BEGIN
    update tb_user set 
        firstname = firstname_in,
        lastname = lastname_in,
        gender = gender_in,
        dateofbirth = dateofbirth_in
    where userid = userid_in;
    
    update tb_address set
        cityid = cityid_in,
        districtid = districtid_in,
        address = address_in
    where userid = userid_in;
    
    INSERT INTO tb_notification (
        userid,
        content
    ) VALUES (
        userid_in,
        'Cập nhật thông tin tài khoản thành công'
    );
    
    COMMIT;
END;