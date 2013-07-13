# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table option (
  id                        varchar(255) not null,
  name                      varchar(255),
  description               varchar(255),
  up_count                  integer,
  constraint pk_option primary key (id))
;

create table poll (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_poll primary key (id))
;

create sequence option_seq;

create sequence poll_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists option;

drop table if exists poll;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists option_seq;

drop sequence if exists poll_seq;

