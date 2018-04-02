DROP TABLE Doctor;
DROP TABLE Paciente;
DROP TABLE AnalisisC;
DROP TABLE Atiende;

CREATE TABLE Doctor(
clave VARCHAR(10) NOT NULL,
nombre VARCHAR(15) NOT NULL,
especialidad VARCHAR(15) NOT NULL,
direccion VARCHAR(15) NOT NULL,
telefono VARCHAR(15) NOT NULL,
PRIMARY KEY(clave));

CREATE TABLE Paciente(
clave VARCHAR(10) NOT NULL,
nombre VARCHAR(15) NOT NULL,
direccion VARCHAR(15) NOT NULL,
telefono VARCHAR(15) NOT NULL,
PRIMARY KEY(clave));

CREATE TABLE AnalisisC(
tipo VARCHAR(10) NOT NULL,
descripcion VARCHAR(15) NOT NULL,
fechaAplicacion DATE NOT NULL,
fechaEntrega DATE NOT NULL,
noPaciente VARCHAR(10) NOT NULL,
FOREIGN KEY(noPaciente) REFERENCES Paciente(clave));

CREATE TABLE Atiende(
fecha DATE NOT NULL,
diagnostico VARCHAR(15) NOT NULL,
tratamiento VARCHAR(15) NOT NULL,
claveDoc VARCHAR(10) NOT NULL,
clavePac VARCHAR(10) NOT NULL,
FOREIGN KEY(claveDoc) REFERENCES Doctor(clave),
FOREIGN KEY(clavePac) REFERENCES Paciente(clave));

/*jOIN*/

/*SELECT clave,nombre,tipo,descripcion,fechaAplicacion,fechaEntrega from paciente JOIN analisisc ON clave = noPaciente;*/


