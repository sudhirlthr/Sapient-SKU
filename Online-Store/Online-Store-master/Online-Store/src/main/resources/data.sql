DROP TABLE IF EXISTS customer CASCADE;
 
CREATE TABLE customer (
  custid INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  customer_type VARCHAR(25),
  confirmation_token VARCHAR(250) NOT NULL,
  password VARCHAR(250),
  enabled BOOLEAN DEFAULT FALSE
);

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS authorities CASCADE;

create table users(
	userid IDENTITY NOT NULL PRIMARY KEY, 
	username varchar_ignorecase(50),
	password varchar_ignorecase(200) not null,
	enabled boolean not null
);

create table authorities (
	roleid IDENTITY NOT NULL PRIMARY KEY,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
 
insert into customer (custid,first_name, last_name, email, customer_type, confirmation_token, password, enabled) values (22,'user','user', 'abc@gmail.com','regular', '123', '123', TRUE);


insert into users (username, password, enabled) values ('bob', '{noop}123', true);
insert into authorities (username, authority) values ('bob', 'ROLE_USER');
insert into users (username, password, enabled) values ('sara', '{noop}234', true);
insert into authorities (username, authority) values ('sara', 'ROLE_ADMIN');