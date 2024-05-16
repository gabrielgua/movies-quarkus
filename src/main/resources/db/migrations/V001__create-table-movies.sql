create table movies (
    id bigint not null auto_increment,
    name varchar(255) not null,
    release_date datetime not null,

    primary key (id)
) engine=InnoDB;