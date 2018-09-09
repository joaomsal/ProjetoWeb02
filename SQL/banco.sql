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
primary key (codigo));

alter table disciplina add foreign key(preq1) references disciplina(codigo);
alter table disciplina add foreign key(preq2) references disciplina(codigo);
              
 create table curriculo(
id int auto_increment,
curso char(3) not null,
periodo int not null,
disciplina varchar(8) not null,
tipo_disciplina char(1) not null,
primary key(id),
constraint fkd foreign key(curso)
references curso(codigo),
constraint fkdd foreign key(disciplina)
references disciplina (codigo)
);

insert into curso values ('170', 'Ciência da Computação');
insert into curso values ('171', 'Engenharia da Computação');
insert into curso values ('172', 'Sistemas de Informação');
insert into disciplina (codigo,nome,creditos) values ('COMP197', 'Programação Imperativa', 6);
insert into disciplina (codigo,nome,creditos) values ('MAT181', 'Cálculo I', 6);
insert into disciplina (codigo,nome,creditos) values ('MAT192', 'Vetores e Geometria Analitica', 4);
insert into disciplina (codigo,nome,creditos) values ('COMP222', 'Fundamentos da Computação', 2);
insert into disciplina (codigo,nome,creditos) values ('MAT166', 'Fundamentos da Matemática', 6);
insert into disciplina (codigo,nome,creditos) values ('COMP210', 'Métodos e Técnicas de Pesquisa', 4);
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP197','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP222','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'COMP210','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT181','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT192','O');
insert into curriculo (curso, periodo, disciplina, tipo_disciplina) values ('170',1,'MAT166','O');