create table Recursos(
  id_recurso int NOT NULL,
  nombre varchar(50) NOT NULL,
  habilitado varchar(10) NOT NULL,
  ubicacion varchar(50) NOT NULL
 );

create table Horarios(
  id_horario int NOT NULL,
  id_recurso int NOT NULL,
  horas varchar(20) NOT NULL,
  estado varchar(15) NOT NULL
 );

create table TiposRecursos(
  id_recurso int NOT NULL,
  tipo varchar(50) NOT NULL,
  capacidad int,
  ejemplares int
 );

create table Reservas(
  id_reserva int NOT NULL,
  id_usuario int NOT NULL,
  id_recurso int NOT NULL,
  inicio varchar(50) NOT NULL,
  fin varchar(50) NOT NULL,
  recurrente bool NOT NULL,
  estado varchar(10) NOT NULL,
  solicitud varchar(50) NOT NULL
 );

 create table ReservasRecurrentes(
   id_reservasR int NOT NULL,
   periodo varchar(20) NOT NULL,
   fin varchar(50) NOT NULL
  );

  create table Usuarios(
    id_usuarios int NOT NULL,
    tipo varchar(20) NOT NULL,
    nombre varchar(50) NOT NULL,
    programa varchar(50)
   );

 alter table Horarios ADD PRIMARY KEY(id_horario);
 alter table Recursos ADD PRIMARY KEY(id_recurso);
 alter table reservas ADD PRIMARY KEY(id_reserva);
 alter table reservasrecurrentes ADD PRIMARY KEY(id_reservasr);
 alter table tiposrecursos ADD PRIMARY KEY(id_recurso);
 alter table usuarios ADD PRIMARY KEY(id_usuarios);

 alter table horarios
 add constraint FK_horarios_recursos
 FOREIGN KEY (id_recurso)
 references recursos(id_recurso);

 alter table tiposrecursos
 add constraint FK_tiposrecursos_recursos
 FOREIGN KEY (id_recurso)
 references recursos(id_recurso);

 alter table reservas
 add constraint FK_reservas_recursos
 FOREIGN KEY (id_recurso)
 references recursos(id_recurso);

 alter table reservas
 add constraint FK_reservas_usuarios
 FOREIGN KEY (id_usuario)
 references usuarios(id_usuarios);


 alter table reservasrecurrentes
 add constraint FK_reservasr_reservas
 FOREIGN KEY (id_reservasr)
 references reservas(id_reserva);

 -- recursos
 Insert into recursos values (1, 'Precalculo Stewart 7', 'habilitado', '10 - 5');
 Insert into recursos values (2, 'sala 1', 'habilitada', 'biblioteca');
 Insert into recursos values (3, 'PC - 01', 'dañado', 'biblioteca');

 -- tipos r
 insert into tiposrecursos values (1, 'libro', NULL, 1);
 insert into tiposrecursos values (2, 'sala de estudio', 5, NULL);
 insert into tiposrecursos values (3, 'Equipo de computo', NULL, 1);

 -- horarios
 insert into horarios values (1, 3, '10:00 - 11:00', 'disponible');
 insert into horarios values (2, 3, '11:00 - 12:00', 'ocupado');
 insert into horarios values (3, 2, '13:00 - 14:00', 'disponible');
 insert into horarios values (4, 1, '9:00 - 8:00', 'ocupado');

  -- usuarios
  insert into usuarios values (1, 'estudiante', 'Juan Casas', 'Ingenieria de sistemas');
  insert into usuarios values (2, 'administrador', 'Esteban Torres', NULL);
  insert into usuarios values (3, 'estudiante', 'Camila Fuentes', 'Ingenieria civil');

 -- reservas
 insert into reservas values (1, 2, 3, '04/ABR/2022 11:00', '04/ABR/2022 12:00', false, 'activa', '04/ABR/2022 9:00');
 insert into reservas values (2, 3, 1, '17/FEB/2021 8:00', '17/FEB/2021 9:00', true, 'cancelada', '16/FEB/2021 16:00');
  insert into reservas values (3, 1, 2, '26/MAR/2020 13:00', '26/MAR/2020 14:00', true, 'activa', '20/ENE/2020 10:00');

 -- reservas r
 insert into reservasrecurrentes values (2, 'semanal', '23/MAY/2021');
 insert into reservasrecurrentes values (3, 'diario', '27/MAY/2020');

 select nombre, habilitado, ubicacion, tipo, capacidad, ejemplares, horas, estado from recursos
 join tiposrecursos
 ON recursos.id_recurso = tiposrecursos.id_recurso
 join horarios
 ON recursos.id_recurso = horarios.id_recurso;

 create sequence id_Recusos
 maxvalue 999999
 increment by 1
 nocycle;