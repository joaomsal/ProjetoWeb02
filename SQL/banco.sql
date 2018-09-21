create database projeto2;
use projeto2;

create table curso(
codigo char(3) not null,
nome varchar(40) not null,
primary key(codigo)
);

create table disciplina(
codigo varchar(8) not null,
nome varchar(40) not null,
creditos int not null,
preq1 varchar(8),
preq2 varchar(8),
primary key (codigo)
);

alter table disciplina add foreign key(preq1) references disciplina(codigo);
alter table disciplina add foreign key(preq2) references disciplina(codigo);
              
 create table curriculo(
id int auto_increment,
curso char(3) not null,
periodo int not null,
disciplina varchar(8) not null,
tipo_disciplina char(1) not null,
primary key(id),
unique(curso,periodo,disciplina,tipo_disciplina),
constraint fkd foreign key(curso)
references curso(codigo),
constraint fkdd foreign key(disciplina)
references disciplina (codigo) on delete cascade
);

insert into curso values ('170', 'Ciência da Computação');
insert into curso values ('171', 'Engenharia da Computação');
insert into curso values ('172', 'Sistemas de Informação');
-- GRADE de CC
insert into disciplina (codigo,nome,creditos) values ('COMP197', 'Programação Imperativa', 6);
insert into disciplina (codigo,nome,creditos) values ('MAT181', 'Cálculo I', 6);
insert into disciplina (codigo,nome,creditos) values ('MAT192', 'Vetores e Geometria Analitica', 4);
insert into disciplina (codigo,nome,creditos) values ('COMP222', 'Fundamentos da Computação', 2);
insert into disciplina (codigo,nome,creditos) values ('MAT166', 'Fundamentos da Matemática', 6);
insert into disciplina (codigo,nome,creditos) values ('COMP210', 'Métodos e Técnicas de Pesquisa', 4);
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP211', 'Programação Orientada a Objetos', 4,'COMP197');
insert into disciplina (codigo,nome,creditos,preq1) values ('MAT212', 'Álgerbra Linear', 4,'MAT192');
insert into disciplina (codigo,nome,creditos,preq1,preq2) values ('MAT213', 'Cálculo II', 6,'MAT181','MAT192');
insert into disciplina (codigo,nome,creditos,preq1) values ('FIS001', 'Física I', 4,'MAT181');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP215', 'Lógica para Computação', 4,'MAT166');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP216', 'Programação Declarativa', 4,'COMP215');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP217', 'Programação Web', 2,'COMP211');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP218', 'Estrutura de dados', 4,'COMP197');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP220', 'Circuitos Digitais', 4,'COMP222');
insert into disciplina (codigo,nome,creditos,preq1) values ('COMP219', 'Arquitetura de computadores', 6,'COMP220');

insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP197','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP222','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP210','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT181','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT192','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT166','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',2,'COMP211','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',2,'COMP220','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',2,'MAT213','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',2,'FIS001','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',2,'COMP215','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'MAT212','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'COMP216','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'COMP217','C');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'COMP218','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'COMP219','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',3,'COMP220','O');
-- fim da grade
-- grade de EC
insert into disciplina (codigo,nome,creditos,preq1) values ('MAT218', 'Cálculo III', 6,'MAT213');
insert into disciplina (codigo,nome,creditos,preq1) values ('FIS002', 'Física II', 4,'FIS001');
insert into disciplina (codigo,nome,creditos) values ('COMP228', 'Introdução a Engenharia da Computação', 6);
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'COMP197','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'COMP228','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'COMP210','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'MAT181','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'MAT192','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',1,'MAT166','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',2,'COMP211','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',2,'COMP220','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',2,'MAT213','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',2,'FIS001','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',2,'COMP215','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',3,'MAT212','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',3,'COMP216','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',3,'MAT218','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('171',3,'FIS002','O');
-- fim da grade

-- grade de SI

insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',1,'COMP197','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',1,'COMP222','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',1,'COMP210','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',1,'MAT181','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',1,'MAT192','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',2,'COMP211','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',2,'COMP220','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',2,'COMP215','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',3,'COMP216','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',3,'COMP217','C');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',3,'COMP218','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('172',3,'COMP220','O');

-- fim da grade