CREATE TABLE Usuario (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome varchar(50) NOT NULL,
  cpf varchar(11) NOT NULL,
  email varchar(50) NOT NULL,
  cep varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  logradouro varchar(50) DEFAULT NULL,
  complemento varchar(100) DEFAULT NULL,
  bairro varchar(50) DEFAULT NULL,
  localidade varchar(50) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL
)