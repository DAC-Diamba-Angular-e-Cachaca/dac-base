create database gerente;

create table gerente (
	id uuid primary key,
	idExternoUsuario uuid not null,
	nome varchar(60) not null,
	cpf varchar(11) unique not null,
	saga uuid
)