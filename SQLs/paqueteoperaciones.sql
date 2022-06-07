
create or replace package pk_customer is
    
    PROCEDURE obtener_clientes(lista_clientes out SYS_REFCURSOR);
    
    PROCEDURE insertar_cliente(
        nombre_in IN VARCHAR2,
        apellido_in IN VARCHAR2,
        tipo_documento_in IN VARCHAR2,
        numero_documento_in IN NUMBER,
        rut_in IN VARCHAR2
    );
    
    PROCEDURE insertar_cuenta(
        nitcedula_in NUMBER,
        numero_cuenta_in NUMBER,
        moneda_in VARCHAR2,
        saldo_in NUMBER
    );
    
    PROCEDURE eliminar_cuenta(
        id_cuenta IN NUMBER
    );
    
    PROCEDURE insertar_movimiento(
        numero_cuenta_in IN NUMBER,
        valor_in IN NUMBER
    );
    
end pk_customer;
/

create or replace PACKAGE BODY pk_customer is

    PROCEDURE obtener_clientes(lista_clientes out SYS_REFCURSOR)
    is
    begin
        open lista_clientes FOR select * from customer;
    end obtener_clientes;
    
    PROCEDURE insertar_cliente(
        nombre_in IN VARCHAR2,
        apellido_in IN VARCHAR2,
        tipo_documento_in IN VARCHAR2,
        numero_documento_in IN NUMBER,
        rut_in IN VARCHAR2
    )
    is
        num_rut NUMBER;
    begin
    
        SELECT COUNT(*) INTO num_rut FROM customer WHERE rut = rut_in;
        
        --verificar que el rut no este ya insertado para algun cliente
        IF num_rut = 0 THEN
            INSERT INTO Customer (nombre, apellido, tipo_documento, numero_documento, rut) VALUES (nombre_in, apellido_in, tipo_documento_in, numero_documento_in, rut_in);
        END IF;
    
    end insertar_cliente;
    
    PROCEDURE insertar_cuenta(
        nitcedula_in NUMBER,
        numero_cuenta_in NUMBER,
        moneda_in VARCHAR2,
        saldo_in NUMBER
    )
    IS
        cuenta_existe NUMBER;
    BEGIN
        SELECT COUNT(*) INTO cuenta_existe FROM cuentas WHERE numero_cuenta = numero_cuenta_in;
        
        --insertar cuenta si esta no existe
        IF cuenta_existe = 0 THEN
            INSERT INTO CUENTAS (nitcedula, numero_cuenta, moneda, saldo) VALUES (nitcedula_in, numero_cuenta_in, moneda_in, saldo_in);
        END IF;
        
    END insertar_cuenta;
    
    PROCEDURE eliminar_cuenta(
        id_cuenta IN NUMBER
    )
    IS
        num_cuenta NUMBER;
        cuenta_movimientos NUMBER;
    BEGIN
    
        SELECT numero_cuenta INTO num_cuenta FROM CUENTAS WHERE id = id_cuenta;
        SELECT COUNT(*) INTO cuenta_movimientos FROM MOVIMIENTOS WHERE numero_cuenta = num_cuenta;
        
        IF cuenta_movimientos = 0 THEN
            DELETE FROM CUENTAS WHERE id = id_cuenta;
        END IF;
        
    END eliminar_cuenta;

----------------------------------------------------------------------------
    
    PROCEDURE insertar_movimiento(
        numero_cuenta_in IN NUMBER,
        valor_in IN NUMBER
    )
    IS
        id_cuenta NUMBER;
        saldo_c NUMBER;
        nuevo_saldo number;
        t_moneda varchar2(100);
    BEGIN
        SELECT id INTO id_cuenta FROM CUENTAS WHERE numero_cuenta = numero_cuenta_in;
        SELECT saldo INTO saldo_c FROM CUENTAS WHERE numero_cuenta = numero_cuenta_in;
        SELECT moneda INTO t_moneda FROM CUENTAS WHERE numero_cuenta = numero_cuenta_in;
        nuevo_saldo := saldo_c + valor_in;
        
        IF nuevo_saldo >= 0 THEN
            UPDATE CUENTAS SET saldo = nuevo_saldo WHERE id = id_cuenta;
        END IF;
        
        IF (valor_in <= 1000000 AND t_moneda = 'PESO') OR (valor_in <= 300 AND t_moneda = 'DOLAR') OR (valor_in <= 150 AND t_moneda = 'EURO') OR  nuevo_saldo < 0 THEN
            INSERT INTO MOVIMIENTOS(numero_cuenta, valor, estado) VALUES (numero_cuenta_in, valor_in, 'APROBADO');
        ELSE
            INSERT INTO MOVIMIENTOS(numero_cuenta, valor, estado) VALUES (numero_cuenta_in, valor_in, 'RECHAZADO');
        END IF;
        
    END insertar_movimiento;

end pk_customer;
/