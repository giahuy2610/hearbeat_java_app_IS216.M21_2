----Create table Address
CREATE TABLE TB_ADDRESS
(
    USERID INTEGER PRIMARY KEY,
    CITYID INTEGER NOT NULL,
    DISTRICTID INTEGER NOT NULL,
    WARD NVARCHAR2(255),
    ADDRESS NVARCHAR2(255)
);

--FOREIGN KEY OF TABLE TB_ADDRESS
alter table TB_ADDRESS 
add constraint FK_ADDR_USER foreign key (UserId)
references TB_USER(UserId);

alter table TB_ADDRESS 
add constraint FK_ADDR_CITYID foreign key (CITYId)
references TB_CITY(CITYId);

alter table TB_ADDRESS 
add constraint FK_ADDR_DISTRICTID foreign key (DISTRICTId)
references TB_DISTRICT(DISTRICTId);

--TRIGGER kiểm tra quận/huyện phải nằm trong thành phố/tỉnh đã chọn
CREATE OR REPLACE TRIGGER trigger_address BEFORE
    INSERT OR UPDATE ON tb_address
    REFERENCING
        NEW AS new
    FOR EACH ROW
DECLARE
    cityid_of_district tb_city.cityid%TYPE;
BEGIN
    SELECT
        tb_district.cityid
    INTO cityid_of_district
    FROM
        tb_district
    WHERE
        districtid = :new.districtid;

    IF ( :new.cityid != cityid_of_district ) THEN
        raise_application_error(-20000, 'Lỗi. Tỉnh/thành phố và quận/huyện không khớp nhau');
    END IF;

END;
