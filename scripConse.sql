CREATE TABLE carro (
  numeromatricula VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  marca VARCHAR(255) NOT NULL,
  descripcion TEXT NOT NULL,
  precio DECIMAL(12, 2) NOT NULL,
  img VARCHAR(255) NOT NULL
);

CREATE TABLE cliente (
  idcliente INTEGER PRIMARY KEY,
  nombres VARCHAR(255) NOT NULL,
  telefono INTEGER NOT NULL,
  direccion VARCHAR(255) NOT NULL
);

CREATE TABLE venta (
  idventa INTEGER PRIMARY KEY AUTO_INCREMENT,
  cliente INTEGER NOT NULL,
  carro VARCHAR(9) NOT NULL,
  fecha DATE NOT NULL,
  FOREIGN KEY (carro) REFERENCES carro (numeromatricula),
FOREIGN KEY (cliente) REFERENCES cliente (idcliente)
);


INSERT INTO cliente VALUES(1010,"Manuel Guillermo Ochoa",2818090,"Calle 1 no. 123");
INSERT INTO cliente VALUES(2020,"Luis David Ospina",3104578,"Calle 2 no. 456");
INSERT INTO cliente VALUES(3030,"Camilo Sampedro",2314598,"Calle 3 no. 789");
INSERT INTO cliente VALUES(4040,"Sergio Loaiza",2818090,"Calle 4 no. 101112");

INSERT INTO carro VALUES("DER927","Spark Life","Chevrolet","Chevrolet presenta el nuevo Spark LIFE, un vehículo que llega a complementar el portafolio de productos Chevrolet, con el precio más accesible del segmento de los más pequeños y con el que busca democratizar el carro nuevo en Colombia.",20390000,"../imagenes/chevrolet.jpg");
INSERT INTO carro VALUES("LAS123","Mégane III Hatchback","Renault","Mégane III tiene un diseño enamorador,verdadera promesa de diseño y robustez. Faros delanteros perfilados, líneas fluidas y propulsoras, equilibrio de las proporciones… No esconde nada de sus excelentes cualidades de ruta. Sorprende tanto por la precisión de sus líneas como por la calidad de sus acabados. Con Mégane III, el diseño es una forma más de evidencia.",55990000,","../imagenes/mazda.jpg");
INSERT INTO carro VALUES("PER789","Nuevo Mazda 6","Mazda","En su deseo por retar lo convencional, Mazda renueva el Nuevo Mazda 6 para ofrecer una experiencia de conducción única, más dinámica y placentera.",81900000,","../imagenes/renault.jpg");
INSERT INTO carro VALUES("GTA820","Mustang GT Premium","Ford","El auto deportivo más emblemático de todos los tiempos, llegó por fin a Colombia para continuar escribiendo su leyenda que ya cumple 50 años, y demostrar por qué su estilo, potencia y tecnología continúan conquistando fanáticos en todos los mercados donde hace presencia. Ahora, tú también podrás comprobarlo.",127490000,","../imagenes/ford.jpg");


INSERT INTO venta VALUES(1209,4040,"DER927","2015-03-12");
INSERT INTO venta VALUES(1345,2020,"PER789","2015-01-10");
INSERT INTO venta VALUES(3546,1010,"GTA820","2014-07-28");