
create table usuarios(
    id bigint not null auto_increment,
    nombreUsuario varchar(100) not null,
    claveLogin varchar(100) not null,

    primary key(id)
)