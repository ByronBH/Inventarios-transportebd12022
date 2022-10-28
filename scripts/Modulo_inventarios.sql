USE proyectobd122022;

CREATE TABLE tbl_conceptos
(
	concodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    connombre VARCHAR(60),
    conestatus VARCHAR(50)
    
) ENGINE=INNODB DEFAULT CHARSET=latin1;