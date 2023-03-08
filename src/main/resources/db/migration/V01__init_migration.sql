create schema if not exists test;

create sequence if not exists test.test_id_sequence;

create table if not exists test.human
(
    id              integer not null default nextval('test.test_id_sequence'),
    name            text not null,
    first_name      text not null,
    birth_date      date not null,
    primary key(id)
    );
