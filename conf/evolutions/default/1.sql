# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table option (
  id                        bigint not null,
  name                      varchar(255),
  poll_id                   bigint,
  up_count                  integer,
  constraint pk_option primary key (id))
;

create table poll (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_poll primary key (id))
;

create sequence option_seq;

create sequence poll_seq;

alter table option add constraint fk_option_poll_1 foreign key (poll_id) references poll (id) on delete restrict on update restrict;
create index ix_option_poll_1 on option (poll_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists option;

drop table if exists poll;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists option_seq;

drop sequence if exists poll_seq;

