USE proyectobd122022;
CREATE TABLE tbl_bodegas
(
	bodcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bodnombre VARCHAR(60),
    bodestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_lineas
(
	lincodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    linnombre VARCHAR(60),
    linestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_marcas
(
	marcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marnombre VARCHAR(60),
    marestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_productos
(
	prodcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prodnombre VARCHAR(60),
    lincodigo INT NOT NULL,
    marcodigo INT NOT NULL,
    prodexistencia FLOAT(10,2),
    prodestatus VARCHAR(1),
    FOREIGN KEY (lincodigo) REFERENCES tbl_lineas(lincodigo),
    FOREIGN KEY (marcodigo) REFERENCES tbl_marcas(marcodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbL_existencias
(
	bodcodigo INT NOT NULL,
    prodcodigo INT NOT NULL,
    exisaldo FLOAT(10,2),
    PRIMARY KEY (bodcodigo, prodcodigo),
	FOREIGN KEY (bodcodigo) REFERENCES tbl_bodegas(bodcodigo),
    FOREIGN KEY (prodcodigo) REFERENCES tbl_productos(prodcodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_vendedores
(
	vedcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    vednombre VARCHAR(60),
    veddireccion VARCHAR(60),
    vedtelefono VARCHAR(50),
    vednit VARCHAR(20),
    vedestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_clientes
(
	clicodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    clinombre VARCHAR(60),
    clidireccion VARCHAR(60),
    clinit VARCHAR(20),
    clitelefono VARCHAR(50),
    cliestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_vendedoresclientes
(
	vedcodigo INT NOT NULL,
    clicodigo INT NOT NULL,
    PRIMARY KEY (vedcodigo, clicodigo),
    FOREIGN KEY (vedcodigo) REFERENCES tbl_vendedores(vedcodigo),
	FOREIGN KEY (clicodigo) REFERENCES tbl_clientes(clicodigo)    
) ENGINE=INNODB DEFAULT CHARSET=latin1;    
CREATE TABLE tbl_proveedores
(
	procodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pronombre VARCHAR(60),
    prodireccion VARCHAR(60),
    protelefono VARCHAR(50),
    pronit VARCHAR(50),
    proestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_sucursales
(
	succodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sucnombre VARCHAR(60),
    sucestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_compras_encabezado
(
	coedocumento INT NOT NULL,
    procodigo INT NOT NULL,
    coefecha DATE,
	coetotal FLOAT(10,2),
    coeestatus VARCHAR(1),
    PRIMARY KEY (coedocumento),
    FOREIGN KEY (procodigo) REFERENCES tbl_proveedores(procodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_compras_detalle
(
    coedocumento INT NOT NULL,
    codorden INT NOT NULL,
    prodcodigo INT NOT NULL,
    codcantidad FLOAT(10,2),
    codcosto FLOAT(10,2),
	bodcodigo INT NOT NULL,
    PRIMARY KEY (coedocumento, codorden, prodcodigo),
    FOREIGN KEY (coedocumento) REFERENCES tbl_compras_encabezado(coedocumento),
	FOREIGN KEY (prodcodigo) REFERENCES tbl_productos(prodcodigo),    
    FOREIGN KEY (bodcodigo) REFERENCES tbl_bodegas(bodcodigo)    
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_ventas_encabezado
(
	veedocumento VARCHAR(10),
    clicodigo INT NOT NULL,
    veefecha DATE,
	veetotal FLOAT(10,2),
    veeestatus VARCHAR(1),
    PRIMARY KEY (veedocumento),
    FOREIGN KEY (clicodigo) REFERENCES tbl_clientes(clicodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_ventas_detalle
(
	veedocumento VARCHAR(10),
    vedorden INT NOT NULL,
    prodcodigo INT NOT NULL,
    vedcantidad FLOAT(10,2),
    vedcosto FLOAT(10,2),
    vedprecio FLOAT(10,2),
	bodcodigo INT NOT NULL,
    PRIMARY KEY (veedocumento, vedorden, prodcodigo),
    FOREIGN KEY (veedocumento) REFERENCES tbl_ventas_encabezado(veedocumento),
	FOREIGN KEY (bodcodigo) REFERENCES tbl_bodegas(bodcodigo)    
) ENGINE=INNODB DEFAULT CHARSET=latin1;
