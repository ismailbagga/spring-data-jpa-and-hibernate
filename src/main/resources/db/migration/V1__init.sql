create table if not exists student (
	id SERIAL ,
	name varchar(255) ,
	PRIMARY KEY(id)
) ;
create table if not exists passport (
	id SERIAL PRIMARY KEY  ,
	number varchar(20) ,
	student_id int references student(id) UNIQUE
);

insert into student(name)
values ('Jamie') , ('mark') , ('kim') ;

insert into passport(number,student_id)
values  ('9596',1) , ('6054',2) , ('2018',3) ;
