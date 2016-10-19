# CaixaService
Caixa com os services

Não é mais preciso colocar o caminho para o arquivo acesso.txt na mão, pois agora ele esta dentro da pasta WebContent e vai ser carregado automaticamente.

Dados para logar:
{
	"agency": "1234",
	"account": "12345",
	"password": "123"
}

Script para criar o BD, tabelas e inserir um dado para teste.
INICIO DO SCRIPT ***********************************************************************************************
create database if not exists `Caixa` default character set utf8 default collate utf8_general_ci;

use `Caixa`;

create table if not exists Cliente
(
	idCliente int not null,
	nome varchar(45) not null,
	telefone varchar(20) not null,
    
    primary key (idCliente)
) default charset = utf8 engine = InnoDB;

create table if not exists Conta
(
	idConta varchar(5) not null,
    saldo decimal not null,
    Cliente_idCliente int not null,
    
    primary key (idConta, Cliente_idCliente),
    foreign key (Cliente_idCliente) references Cliente (idCliente)
) default charset = utf8 engine = InnoDB;

create table if not exists DebitoAutomatico
(
	idDebitoAutomatico int not null,
    codOperadora int not null,
    codConsumidor int not null,
    Conta_idConta varchar(5) not null,
    Conta_Cliente_idCliente int not null,
    
    primary key (idDebitoAutomatico, Conta_idConta, Conta_Cliente_idCliente),
    foreign key (Conta_idConta, Conta_Cliente_idCliente) references Conta (idConta, Cliente_idCliente)
) default charset = utf8 engine = InnoDB;

create table if not exists Log
(
	idLog int not null auto_increment,
    `data` datetime not null,
    agencia varchar(4) not null,
    operacao varchar(20) not null,
    valor decimal not null,
    Conta_idConta varchar(5) not null,
    Conta_Cliente_idCliente int not null,
    
    primary key (idLog, Conta_idConta, Conta_Cliente_idCliente),
    foreign key (Conta_idConta, Conta_Cliente_idCliente) references Conta (idConta, Cliente_idCliente)
) default charset = utf8 engine = InnoDB;

insert into Cliente values (1, 'ThiGusto', '012345678');
insert into Conta values (12345, 100, 1);

select * from Cliente;
select * from Conta;
FIM DO SCRIPT **************************************************************************************************
