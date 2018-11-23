create database dbMarketingMail;

use dbMarketingMail;

create table contato(
    idcontato int AUTO_INCREMENT NOT NULL,
    nome varchar(50),
    telefone varchar(13),
    celular varchar(14),
    estado char(2),
    email varchar(30),
    idgrupo int,
    PRIMARY KEY(idcontato),
    FOREIGN KEY (idgrupo) REFERENCES grupo(idgrupo)
);

create table grupo(
    idgrupo int AUTO_INCREMENT not null,
    nome varchar(20),
    PRIMARY KEY(idgrupo)
);

create table email(
    idemail int AUTO_INCREMENT not null,
    email varchar(30),
    data date,
    PRIMARY KEY(idemail)
);

