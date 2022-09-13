DELIMITER $$
CREATE TRIGGER TRG_UPDATE_PO
AFTER
UPDATE ON pos010
FOR EACH ROW
BEGIN
	DECLARE T_COST FLOAT;
    DECLARE C_FEE FLOAT;
    SET C_FEE = 10.00;
    IF NEW.status010 = 'Confirmed' AND OLD.status010 = 'Pending Confirmation' THEN
		SET T_COST = (SELECT SUM(line_price010) FROM po_lines010 WHERE po_lines010.po_no010 = NEW.po_no010);
        UPDATE client_user010 SET client_user010.money_owed010 = T_COST WHERE client_user010.client_comp_id010 = NEW.client_comp_id010;
        UPDATE parts010 SET parts010.qty010 = (parts010.qty010 - (SELECT COUNT(part_no010) AS part_no010 FROM po_lines010 WHERE po_lines010.po_no010 = NEW.po_no010)) WHERE parts010.part_no010 IN (SELECT part_no010 FROM po_lines010 WHERE po_lines010.po_no010 = NEW.po_no010);
	ELSEIF NEW.status010 = 'Cancelled' AND OLD.status010 = 'Pending Cancellation' THEN
			SET T_COST = (SELECT SUM(line_price010) FROM po_lines010 WHERE po_lines010.po_no010 = NEW.po_no010);
			UPDATE client_user010 SET client_user010.money_owed010 = (client_user010.money_owed010 - T_COST + C_FEE) WHERE client_user010.client_comp_id010 = NEW.client_comp_id010;
			UPDATE parts010 SET parts010.qty010 = (parts010.qty010 + 1) WHERE parts010.part_no010 IN (SELECT part_no010 FROM po_lines010 WHERE po_lines010.po_no010 = NEW.po_no010);
    END IF;
END