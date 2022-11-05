USE proyectobd122022;

CREATE TABLE tbl_transporte
(
	tranmatricula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tranmodelo VARCHAR(30)  NOT NULL,
    trantipo VARCHAR(30) NOT NULL,
    tranmarca VARCHAR(30) NOT NULL
    ) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_conductor
(
	condid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    condnombre VARCHAR(30)  NOT NULL,
	condestatus VARCHAR(30) NOT NULL
        ) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_conceptos
(
	conid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    connombre VARCHAR(30)  NOT NULL,
	conestatus VARCHAR(30) NOT NULL
        ) ENGINE=INNODB DEFAULT CHARSET=latin1;
        
CREATE TABLE tbl_movimientoen
(
	movid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    movfecha VARCHAR(30) NOT NULL,
    movestado VARCHAR(30) NOT NULL
    
) ENGINE=INNODB DEFAULT CHARSET=latin1;        
	
CREATE TABLE tbl_movimientode
(
	movid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prodcodigo INT NOT NULL,
    conid INT NOT NULL,
    clicodigo INT NOT NULL,
    procodigo INT NOT NULL,
    lincodigo INT NOT NULL,
    marcodigo INT NOT NULL, 
    movcantidad INT NOT NULL,
    prodexistencia INT NOT NULL,
    FOREIGN KEY (movid) REFERENCES tbl_movimientoen(movid), 
    FOREIGN KEY (prodcodigo) REFERENCES tbl_productos(prodcodigo), 
    FOREIGN KEY (conid) REFERENCES tbl_conceptos(conid),
    FOREIGN KEY (clicodigo) REFERENCES tbl_clientes(clicodigo),  
    FOREIGN KEY (marcodigo) REFERENCES tbl_marcas(marcodigo),  
    FOREIGN KEY (lincodigo) REFERENCES tbl_lineas(lincodigo),  
    FOREIGN KEY (procodigo) REFERENCES tbl_proveedores(procodigo)  
) ENGINE=INNODB DEFAULT CHARSET=latin1;