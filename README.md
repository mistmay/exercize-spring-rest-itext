# exercize-spring-rest-itext

based on database

use itext;
CREATE TABLE employees ( id int(20) unsigned NOT NULL AUTO_INCREMENT, name varchar(50) DEFAULT NULL, surname varchar(50) DEFAULT NULL, age int(20) DEFAULT NULL, PRIMARY KEY (id)) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
INSERT INTO employees (name, surname, age) VALUES ("Giuseppe", "Marchesiello", 32);
