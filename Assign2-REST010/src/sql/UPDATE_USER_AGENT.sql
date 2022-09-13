CREATE DEFINER=`kothawala`@`129.173.0.0/255.255.0.0` PROCEDURE `UPDATE_USER_AGENT`(
	IN clientCompName010 VARCHAR(255),
    IN clientCity010 VARCHAR(255),
    IN moneyOwed010 FLOAT,
    IN clientCompPassword010 VARCHAR(255), 
    IN clientCompId010 INT)
BEGIN
    START TRANSACTION;
    IF moneyOwed010 IS NOT NULL THEN
        UPDATE client_user010 SET client_user010.money_owed010=moneyOwed010 WHERE (client_user010.client_comp_id010=clientCompId010);
    END IF;
    IF clientCompPassword010 IS NOT NULL THEN
        UPDATE client_user010 SET client_user010.client_comp_password010=clientCompPassword010 WHERE (client_user010.client_comp_id010=clientCompId010);
    END IF;
    IF clientCity010 IS NOT NULL THEN
        UPDATE client_user010 SET client_user010.client_city010=clientCity010 WHERE (client_user010.client_comp_id010=clientCompId010);
    END IF;
    IF clientCompName010 IS NOT NULL THEN
        UPDATE client_user010 SET client_user010.client_comp_name010=clientCompName010 WHERE (client_user010.client_comp_id010=clientCompId010);
    END IF;
    COMMIT;
END