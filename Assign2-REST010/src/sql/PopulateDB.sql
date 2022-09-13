INSERT INTO client_user010 VALUES ('001', 'Halifax', 'TheLC', '0p3n5e54m3', '11.11');
INSERT INTO client_user010 VALUES ('002', 'Test City', 'MrClient', 'testpass', '12.00');

INSERT INTO parts010 VALUES ('003', '11.00', 'This part is wild', 'Crazy Part',  '1');
INSERT INTO parts010 VALUES ('004', '00.11', 'This part is more wild but cheaper', 'Crazier Part', '1');
INSERT INTO parts010 VALUES ('005', '1.00', 'This part is sensible', 'Sensible Part',  '1');
INSERT INTO pos010 VALUES ('123', '2021-05-06', 'Pending', '001');
INSERT INTO pos010 VALUES ('124', '2021-05-07', 'Pending', '002');

INSERT INTO po_lines010 VALUES ('01', '11.00', '003', '123');
INSERT INTO po_lines010 VALUES ('02', '00.11', '004', '123');
INSERT INTO po_lines010 VALUES ('03', '11.00', '003', '124');
INSERT INTO po_lines010 VALUES ('04', '1.00', '005', '124');

INSERT INTO agent010 VALUES ('testUsername', 'testPassword');
INSERT INTO agent010 VALUES ('testUsername2', 'testPassword2');
INSERT INTO agent010 VALUES ('testUsername3', 'testPassword3');
INSERT INTO agent010 VALUES ('testUsername4', 'testPassword4');