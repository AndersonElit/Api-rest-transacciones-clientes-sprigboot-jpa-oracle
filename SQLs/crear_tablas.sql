
CREATE TABLE CUSTOMER (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(250),
    apellido VARCHAR2(250),
    tipo_documento VARCHAR2(2),
    numero_documento NUMBER,
    rut VARCHAR2(100)
);

CREATE SEQUENCE customer_seq
  MINVALUE 1
  START WITH 50
  INCREMENT BY 50;
  
CREATE TRIGGER CUSTOMER_TG
    BEFORE INSERT ON CUSTOMER
    FOR EACH ROW
        WHEN (new.id IS NULL)
    BEGIN
        :new.id := customer_seq.nextval;
END;

-----------------------------------------------------------------------------

CREATE TABLE CUENTAS(
    id NUMBER PRIMARY KEY,
    nitcedula NUMBER,
    numero_cuenta NUMBER,
    moneda VARCHAR2(100),
    saldo NUMBER
	FOREIGN KEY(nitcedula) REFERENCES CUSTOMER(numero_documento)
);

CREATE SEQUENCE cuentas_seq
  MINVALUE 1
  START WITH 50
  INCREMENT BY 50;
 
CREATE TRIGGER CUENTAS_TG
    BEFORE INSERT ON CUENTAS
    FOR EACH ROW
        WHEN (new.id IS NULL)
    BEGIN
        :new.id := cuentas_seq.nextval;
END;

-----------------------------------------------------------------------------

CREATE TABLE MOVIMIENTOS(
    id NUMBER PRIMARY KEY,
    numero_cuenta NUMBER,
    valor NUMBER,
	estado VARCHAR2(100)
);

CREATE SEQUENCE movimientos_seq
  MINVALUE 1
  START WITH 50
  INCREMENT BY 50; 
  
CREATE TRIGGER MOVIMIENTOS_TG
    BEFORE INSERT ON MOVIMIENTOS
    FOR EACH ROW
        WHEN (new.id IS NULL)
    BEGIN
        :new.id := movimientos_seq.nextval;
END;
