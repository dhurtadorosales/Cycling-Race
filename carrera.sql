create database carrera encoding 'utf8';
\c carrera;

        create table equipo(
            nombre_equipo varchar(30) primary key,
            nacionalidad varchar(30)
	);
    
        create table etapa(
            numero_etapa serial primary key,
            poblacion_salida varchar(50) unique,
            poblacion_llegada varchar(50) unique,
            fecha date unique,
            tipo_etapa varchar(20),
	    distancia integer
	);
		
        create table ciclista(
            dorsal integer primary key check (dorsal >0) not null,
            nombre varchar(20) not null,
            apellidos varchar(50) not null,
            edad varchar(2) not null,
            nacionalidad varchar(30) not null,
            nombre_equipo varchar(30) not null,
            foreign key(nombre_equipo) references equipo (nombre_equipo)
	);
		create index ciclista_nombre_equipo on ciclista(nombre_equipo);		

        create table puerto(
            nombre_puerto varchar(50) not null,
 	    numero_etapa integer not null,
            distancia integer check (distancia >0),
            altitud integer check (altitud >0),
            pendiente_media float check (pendiente_media >0),
            foreign key (numero_etapa) references etapa on update cascade on delete cascade,
            primary key (nombre_puerto, numero_etapa)
	);
		create index puerto_numero_etapa on puerto(numero_etapa);	
        
        create table participacion(
            numero_etapa integer,
	    dorsal integer,
	    tiempo time,
            foreign key (numero_etapa) references etapa (numero_etapa),
	    foreign key (dorsal) references ciclista (dorsal),
            primary key (numero_etapa, dorsal)
	);	
		create index participacion_numero_etapa on participacion(numero_etapa);
		create index participacion_dorsal on participacion(dorsal);
        
        create table abandono(
            dorsal integer not null,
    	    numero_etapa integer not null,
            foreign key (dorsal) references ciclista (dorsal),
	    foreign key (numero_etapa) references etapa (numero_etapa),
            primary key (dorsal, numero_etapa)
	);
		create index abandono_dorsal on abandono(dorsal);
		create index abandono_numero_etapa on abandono(numero_etapa);
        
        create table subida(
            nombre_puerto varchar(50),
            numero_etapa integer,
	    dorsal integer,
	    tiempo_subida time,
            foreign key (nombre_puerto, numero_etapa) references puerto (nombre_puerto, numero_etapa),
	    foreign key (dorsal) references ciclista (dorsal),
            primary key (nombre_puerto, numero_etapa, dorsal)
	);
		create index subida_nombre_puerto_numero_etapa on subida(nombre_puerto, numero_etapa);
		create index subida_dorsal on subida(dorsal);

	insert into etapa
	values 	(default, 'Málaga', 'Málaga', '2016-09-01', 'crono individual', 56),
		(default, 'Córdoba', 'Cazorla', '2016-09-02', 'en línea', 215),
		(default, 'Burgos', 'Segovia', '2016-09-03', 'crono por equipos', 180),
		(default, 'Segovia', 'Navacerrada', '2016-09-04', 'en línea', 175),
		(default, 'Navacerrada', 'Madrid', '2016-09-05', 'en línea', 193);

	insert into equipo
	values 	('Sky', 'Reino Unido'),
		('Movistar', 'España'),
		('Astaná', 'Kazajstan');

	insert into puerto
	values	('Puerto de Tiscar', 2, 15, 1200, 12),
		('Bola del Mundo', 4, 25, 2000, 15),
		('Navacerrada', 4, 20, 1500, 17);

	insert into ciclista
	values 	(1, 'Chris', 'Froome', 26, 'Reino Unido', 'Sky'),
		(2, 'Nicholas', 'Roche', 20, 'Reino Unido', 'Sky'),
		(3, 'Mikel', 'Nieve', 19, 'España', 'Sky'),
		(11, 'Alejandro', 'Valverde', 31, 'España', 'Movistar'),
		(12, 'Nairo', 'Quintana', 19, 'Colombia', 'Movistar'),
		(13, 'Joaquín', 'Rojas', 25, 'España', 'Movistar'),
		(21, 'Vinzenzo', 'Nibali', 20, 'Italia', 'Astaná');
