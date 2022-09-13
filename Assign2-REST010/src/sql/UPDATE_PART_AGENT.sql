CREATE DEFINER=`kothawala`@`129.173.0.0/255.255.0.0` PROCEDURE `UPDATE_PART_AGENT`(IN partName010 VARCHAR(255), 
	IN partDescription010 VARCHAR(255), 
	IN currentPrice010 FLOAT,
    IN currentQty010 INT,
    IN partNo010 INT)
BEGIN
	START TRANSACTION;
	IF partName010 IS NOT NULL THEN
		UPDATE parts010 SET parts010.part_name010=partName010 WHERE (parts010.part_no010=partNo010);
    END IF;
    IF partDescription010 IS NOT NULL THEN
		UPDATE parts010 SET parts010.part_description010=partDescription010 WHERE (parts010.part_no010=partNo010);
    END IF;
    IF currentPrice010 IS NOT NULL THEN
		UPDATE parts010 SET parts010.current_price010=currentPrice010 WHERE (parts010.part_no010=partNo010);
    END IF;
    IF currentQty010 IS NOT NULL THEN
		UPDATE parts010 SET parts010.qty010=currentQty010 WHERE (parts010.part_no010=partNo010);
    END IF;
    COMMIT;
END