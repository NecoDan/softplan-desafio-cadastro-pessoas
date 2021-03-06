create schema if not exists softplan_services;
set schema 'softplan_services';

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

create table if not exists softplan_services.sp01_pessoa
(
    id            uuid         not null,
    nome          varchar(200) not null,
    cpf           varchar(15)  not null,
    dt_nascimento date         not null,
    email         varchar(100)      default null,
    naturalidade  varchar(200)      default null,
    nacionalidade varchar(200)      default null,
    tipo_sexo     char              default null,
    dt_cadastro   timestamp         default now() not null,
    ativo         bool         null default true,
    primary key (id)
);

create unique index uq_sp01_pessoa on softplan_services.sp01_pessoa (id);

alter table softplan_services.sp01_pessoa
    owner to postgres;

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
create sequence softplan_services.sp03_tipo_operacao_log_id_seq;

create table if not exists softplan_services.sp03_tipo_operacao_log
(
    id          integer      not null DEFAULT nextval('softplan_services.sp03_tipo_operacao_log_id_seq'),
    descricao   varchar(100) not null,
    dt_cadastro timestamp             default now() not null,
    primary key (id)
);

create unique index uq_sp03_tipo_operacao_log on softplan_services.sp03_tipo_operacao_log (id);

alter table softplan_services.sp03_tipo_operacao_log
    owner to postgres;

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

create table if not exists softplan_services.sp02_log_pessoa
(
    id                    uuid                    not null,
    id_pessoa             uuid                    null,
    id_tipo_operacao      integer                 not null,
    conteudo              varchar(800)            null,
    dt_ultima_atualizacao timestamp default now() not null,
    dt_cadastro           timestamp default now() not null,
    ativo                 bool                    null default true,
    primary key (id)
);

create unique index uq_sp02_log_pessoa on softplan_services.sp02_log_pessoa (id);

alter table softplan_services.sp02_log_pessoa
    add constraint sp02_log_pessoa_id_tipo_operacao_fkey foreign key (id_tipo_operacao) references softplan_services.sp03_tipo_operacao_log (id);

alter table softplan_services.sp02_log_pessoa
    add constraint sp02_log_pessoa_id_pessoa_fkey foreign key (id_pessoa) references softplan_services.sp01_pessoa;

alter table softplan_services.sp02_log_pessoa
    owner to postgres;

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

insert into softplan_services.sp03_tipo_operacao_log (id, descricao)
values (1, 'CREATE');
insert into softplan_services.sp03_tipo_operacao_log (id, descricao)
values (2, 'UPDATE');
insert into softplan_services.sp03_tipo_operacao_log (id, descricao)
values (3, 'DELETE');

