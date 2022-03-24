create table Family_DB (
    id bigint not null auto_increment,
    family_name varchar(255),
    nr_of_adults integer,
    nr_of_children integer,
    nr_of_infants integer,
    primary key (id)
);

create table Family_MemberDB (
    family_id bigint not null,
    family_name varchar(255),
    given_name varchar(255),
    age integer not null,
    id bigint not null auto_increment,
    primary key (id)
);

alter table Family_MemberDB add constraint FK_family foreign key (family_id) references Family_DB (id);