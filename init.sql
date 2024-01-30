create database ubots;

use ubots;

create table filmes(
	
	id int not null primary key auto_increment,
	titulo varchar(250) not null,
	descricao text

);

create table avaliacoes(
	
	id int not null primary key auto_increment,
	descricao text not null,
	filme_id int not null,
	FOREIGN KEY (filme_id) REFERENCES filmes(id)

);


insert into filmes(titulo, descricao) values ('Missao impossivel', 'Filme de ação');
insert into filmes(titulo, descricao) values ('Shrek', 'Animação de comédia');
insert into filmes(titulo, descricao) values ('Hora do rush', 'Filme de comédia');

insert into avaliacoes(filme_id, descricao) values(1, 'Muito bom');
insert into avaliacoes(filme_id, descricao) values(1, 'Muito ruim');
insert into avaliacoes(filme_id, descricao) values(2, 'Ótimo filme');
