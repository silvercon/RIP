--查询部门树结构
--  thf_department(code, parent_code)
--  @param：departmentCode：部门编号
--  @param：direction：1查询上级部门/2查询下级部门
--  @return：$,D201808081654417407377,D201808081655241815718

--  @usage：select getDepartmentByDirection('D201808081654237289953',1)
--  @usage：select * from thf_department where find_in_set(code, getDepartmentByDirection('D201808081654237289953',1))

--  注：不要使用关键字作为变量名

CREATE DEFINER=`root`@`%` FUNCTION `getDepartmentByDirection`(departmentCode VARCHAR(32), direction int) RETURNS varchar(1000) CHARSET utf8
BEGIN
	DECLARE sTemp VARCHAR(1000);
	DECLARE sTempChd VARCHAR(1000);
    
	SET sTemp = '$';
	SET sTempChd = departmentCode;
    
	IF direction=1 THEN
		WHILE sTempChd is not null DO
            SELECT group_concat(code) INTO sTempChd FROM thf_department where FIND_IN_SET(parent_code,sTempChd)>0;
            SET sTemp = concat_ws(',',sTemp,sTempChd);
		END WHILE;
	ELSEIF direction=2 THEN
		WHILE sTempChd is not null DO
			SELECT group_concat(parent_code) INTO sTempChd FROM thf_department where  FIND_IN_SET(code,sTempChd)>0;
            SET sTemp = concat_ws(',',sTemp,sTempChd);
		END WHILE;
	END IF;
 
	RETURN sTemp;
END