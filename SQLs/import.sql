
INSERT INTO Customer (nombre, apellido, tipo_documento, numero_documento, rut) VALUES ('anderson', 'arrieta', 'C', 11111123, '2333333');
INSERT INTO Customer (nombre, apellido, tipo_documento, numero_documento, rut) VALUES ('ander', 'rodri', 'E', 222222, '120000');

INSERT INTO CUENTAS (nitcedula, numero_cuenta, moneda, saldo) VALUES (111234, 10101010101, 'EURO', 130000);
INSERT INTO CUENTAS (nitcedula, numero_cuenta, moneda, saldo) VALUES (1112355, 10101343434, 'peso', 150000);

INSERT INTO MOVIMIENTOS(numero_cuenta, valor) VALUES (10101010101, -12000);
INSERT INTO MOVIMIENTOS(numero_cuenta, valor) VALUES (10101010101, 20000);