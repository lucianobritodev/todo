insert into usuario
    (id, nome, login, senha, status, criado_em, modificado_em)
values
    ((select nextval('seq_usuario')),
     'Luciano',
     'luciano@email.com',
     '12345',
     true,
     now(),
     now());


insert into agenda
    (id, descricao, usuario_id, status, criado_em, modificado_em)
values
    ((select nextval('seq_agenda')),
     'Segunda-feira',
     (select id from usuario where login = 'luciano@email.com'),
     true,
     now(),
     now());


insert into atividade
(id, descricao, data, horario, local, agenda_id, status, criado_em, modificado_em)
values
    ((select nextval('seq_atividade')),
     'Levar o carro para lavar',
     now(),
     now(),
     'Lava-jato do zezinho',
     (select id from agenda where descricao = 'Segunda-feira'),
     true,
     now(),
     now());