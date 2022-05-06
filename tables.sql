create table Recursos(
  id_recurso int NOT NULL,
  nombre varchar(50) NOT NULL,
  habilitado varchar(10) NOT NULL,
  ubicacion varchar(50) NOT NULL,
  ejemplares int,
  capacidad int,
  id_tiporecurso int Not null
 );
  
create table Horarios(
  id_horario int NOT NULL,
  id_recurso int NOT NULL,
  estado varchar(15) NOT NULL,
  hora_ini time,
  hora_fin time
 );
  
create table TiposRecursos(
  id_recurso int NOT NULL,
  tipo varchar(50) NOT NULL
 );
   
create table Reservas(
  id_reserva int NOT NULL,
  id_usuario int NOT NULL,
  id_recurso int NOT NULL,
  recurrente bool Not null,
  estado varchar(10) NOT NULL,
  solicitud varchar(50) NOT NULL,
  inicio timestamp not null,
  fin timestamp not null
 );
 
 create table ReservasRecurrentes(
   id_reservasr int NOT NULL,
   periodo varchar(20) NOT NULL,
   fin varchar(50) NOT NULL
  );
  
  create table Usuarios(
    id_usuarios int NOT NULL,
    tipo varchar(20) NOT NULL,
    nombre varchar(50) NOT NULL,
    programa varchar(50),
    correo varchar(50),
    contraseña varchar(20)
   );
  
create sequence recursos_id
start with 8
increment by 1
maxvalue 9999999
owned by recursos.id_recurso;

create sequence reservas_id
start with 6
increment by 1
maxvalue 9999999
owned by recursos.id_reservas;
  
 -- PKs
 
 alter table Horarios ADD PRIMARY KEY(id_horario);
 alter table Recursos ADD PRIMARY KEY(id_recurso);
 alter table reservas ADD PRIMARY KEY(id_reserva);
 alter table reservasrecurrentes ADD PRIMARY KEY(id_reservasr);
 alter table tiposrecursos ADD PRIMARY KEY(id_recurso); 
 alter table usuarios ADD PRIMARY KEY(id_usuarios);
 
 -- UKs
 
 ALTER TABLE recursos ADD CONSTRAINT UK_recursos_nombre 
	UNIQUE (nombre);
 
 --FKs
 
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
 
 -- checks
 
alter table recursos add constraint habilitado_dañado 
check (habilitado IN ('dañado', 'habilitado', 'habilitada'));

alter table recursos add constraint ejemplares_mayor
check (ejemplares > 0);

alter table recursos add constraint capacidad_mayor
check (capacidad >= 0 and capacidad <= 15);
 
 -- recursos
 Insert into recursos values (1, 'Precalculo Stewart 7', 'habilitado', '10 - 5', null, null, 1);
 Insert into recursos values (2, 'sala 1', 'habilitada', 'biblioteca', null, 4, 2);
 Insert into recursos values (3, 'PC - 01', 'dañado', 'biblioteca', null, null, 3);
 Insert into recursos values (4, 'Mankiw principios', 'habilitado', '6 - 4', null, null, 1);
 Insert into recursos values (5, 'Modelos matematicos', 'dañado', 'Bloque A', 3, 1, 1);
 Insert into recursos values (6, 'El principito', 'habilitado', 'Bloque A', 1, 1, 1);
 Insert into recursos values (7, 'Teoria de la programacion', 'habilitado', 'Bloque A', 2, 0, 1);
 
 
 -- tipos r
 insert into tiposrecursos values (1, 'libro');
 insert into tiposrecursos values (2, 'sala de estudio');
 insert into tiposrecursos values (3, 'Equipo de computo');
 
 -- horarios
 insert into horarios values (1, 3, 'disponible', '10:00:00', '11:00:00');
 insert into horarios values (2, 3, 'ocupado', '11:00:00', '12:00:00');
 insert into horarios values (3, 2, 'disponible', '14:00:00', '15:00:00');
 insert into horarios values (4, 3, 'disponible', '9:00:00', '10:00:00');
 insert into horarios values (5, 2, 'disponible', '12:00:00', '13:00:00');
 
 
  -- usuarios
  insert into usuarios values (1, 'estudiante', 'Juan Casas', 'Ingenieria de sistemas', 'juan.casas@mail.escuelaing.edu.co', '12345j'); 
  insert into usuarios values (2, 'administrador', 'Esteban Torres', NULL, 'esteban.torres@escuelaing.edu.co', '12345e');
  insert into usuarios values (3, 'estudiante', 'Camila Fuentes', 'Ingenieria civil', 'camila.fuentes@mail.escuelaing.edu.co', '12345c');
  
 -- reservas
 insert into reservas values (1, 2, 3, false, 'activa', '04/ABR/2022 9:00', '2022-04-30 10:00:00', '2022-04-30' 11:00:00);
 insert into reservas values (2, 3, 1, true, 'cancelada', '16/FEB/2021 16:00', '2022-04-30 7:00:00', '2022-04-30' 8:00:00);
  insert into reservas values (3, 1, 2, true, 'activa', '20/ENE/2020 10:00', '2022-04-30 14:00:00', '2022-04-30' 15:00:00);
   insert into reservas values (4, 1, 1, true, 'finalizada', '20/ENE/2020 10:00', '2022-04-30 12:00:00', '2022-04-30' 13:00:00);
   insert into reservas values (3, 1, 2, true, 'activa', '20/ENE/2020 10:00', '2022-04-30 14:00:00', '2022-04-30' 15:00:00);
 
 
 -- reservas r
 insert into reservasrecurrentes values (2, 'semanal', '23/MAY/2021');
 insert into reservasrecurrentes values (3, 'diario', '27/MAY/2020');