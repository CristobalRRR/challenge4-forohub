
create table usuarios(
    id bigint not null auto_increment,
    nombre_usuario varchar(100) not null,
    clave_login varchar(100) not null,

    primary key(id)
)