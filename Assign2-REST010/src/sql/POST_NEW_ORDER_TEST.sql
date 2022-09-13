CREATE DEFINER=`kothawala`@`129.173.0.0/255.255.0.0` PROCEDURE `POST_NEW_ORDER_TEST`(IN newOrderInput JSON)
BEGIN
	DECLARE clientCompId010 INT;
    DECLARE partsList010 JSON;
	DECLARE new_po_no INT;
	DECLARE i INT UNSIGNED DEFAULT 0;
	DECLARE v_count INT UNSIGNED DEFAULT 0;
	DECLARE v_current_item JSON DEFAULT NULL;
    SET clientCompId010 = JSON_UNQUOTE(JSON_EXTRACT(newOrderInput, "$.clientCompId010"));
    SET partsList010 = JSON_UNQUOTE(JSON_EXTRACT(newOrderInput,"$.partsList010"));
    SET v_count = JSON_LENGTH(partsList010);
	START TRANSACTION;
		INSERT INTO pos010(datepo010, status010, client_comp_id010) VALUES (sysdate(), 'Pending Confirmation', clientCompId010);
	COMMIT;
	START TRANSACTION;
		SET new_po_no = (SELECT max(pos010.po_no010) FROM pos010 WHERE pos010.client_comp_id010 = clientCompId010);
		-- loop from 0 to the last item
		WHILE i < v_count DO
			SET v_current_item := JSON_EXTRACT(partsList010, CONCAT('$[', i, ']'));
            INSERT INTO po_lines010(line_price010, part_no010, po_no010)
			SELECT parts010.current_price010, parts010.part_no010, new_po_no
			FROM parts010
			WHERE (parts010.part_no010 = v_current_item);
			SET i := i + 1;
		END WHILE;
	COMMIT;
END