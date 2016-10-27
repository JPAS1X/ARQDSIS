-- ---- Banco de Dados---- --



-- 
---- Banco de Dados---- --





create schema sistemas_cursos;






CREATE  TABLE `sistemas_cursos`.`alunos` (
 
 
`id` INT NOT NULL AUTO_INCREMENT ,
  
`nome` VARCHAR(100) NOT NULL ,
  
`rg` VARCHAR(50) NOT NULL ,
  
`cpf` INT (50) NOT NULL,
  
`logradouro` VARCHAR (50) NOT NULL,
  
`email` VARCHAR (50) NOT NULL,
  
`telefone` INT (50) NOT NULL,
  
  


PRIMARY KEY (`id`) );




CREATE TABLE `sistemas_cursos`.`curso`(



`id` INT NOT NULL AUTO_INCREMENT ,

`codigo` VARCHAR (30) NOT NULL,

`nome` VARCHAR (30) NOT NULL,

`data_inicio` VARCHAR (30) NOT NULL,

`data_termino` VARCHAR (30) NOT NULL,

`horario` VARCHAR (30) NOT NULL,

`vagas` INT(30) NOT NULL,

`valor` DOUBLE(10,2) NOT NULL,

`numero_laboratorio` VARCHAR (30) NOT NULL,

`registro_software` VARCHAR (30) null,

`material` VARCHAR (30) null,

`livros` VARCHAR (30) null,




PRIMARY KEY(`id`)

);
