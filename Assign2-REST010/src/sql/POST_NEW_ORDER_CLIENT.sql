CREATE DEFINER=`kothawala`@`129.173.0.0/255.255.0.0` PROCEDURE `POST_NEW_ORDER_CLIENT`(IN clientCompId010 INT, 
	IN partNo010 INT, 
    IN poNo010 INT)
BEGIN
    DECLARE new_po_no INT;
    IF poNo010 IS NULL THEN
		START TRANSACTION;
			INSERT INTO pos010(datepo010, status010, client_comp_id010) VALUES (sysdate(), 'Pending Confirmation', clientCompId010);
		COMMIT;
		START TRANSACTION;
			SET new_po_no = (SELECT max(pos010.po_no010) FROM pos010 WHERE pos010.client_comp_id010 = clientCompId010);
			INSERT INTO po_lines010(line_price010, part_no010, po_no010)
			SELECT parts010.current_price010, parts010.part_no010, new_po_no
			FROM parts010
			WHERE (parts010.part_no010 = partNo010);
		COMMIT;
	ELSE
		START TRANSACTION;
			INSERT INTO po_lines010(line_price010, part_no010, po_no010)
			SELECT parts010.current_price010, parts010.part_no010, poNo010
			FROM parts010
			WHERE (parts010.part_no010 = partNo010);
		COMMIT;
	END IF;
END