# Spring Boot 3, Spring Security, and Spring JPA Integration

## Purpose
Integrating Spring Security with 2 different tables for 2 different roles, `T_User` table for a `User` role, and `T_Admin` table for `Admin` role. 

## SQL
```sql
create table db_test.t_admin
(
    id int auto_increment
        primary key,
    username varchar(100) null,
    passwd varchar(300) null
);

INSERT INTO db_test.t_admin (username, passwd) VALUES ('admin1', '$2a$12$xMzAOec3gvfksr45RVU4.eg1ZSvxplvRTAJt5C8ZEfGDCJwXiZKCy');

create table db_test.t_user
(
	id varchar(48) not null
		primary key,
	username varchar(100) not null,
	passwd varchar(300) not null,
	constraint t_user_username_uindex
		unique (username)
);

INSERT INTO db_test.t_user (id, username, passwd) VALUES ('29600983-2bc9-4630-860d-4b4a0ecdead4', 'user1', '$2a$12$/1UjYjP8xqWj1xGK7t8qfu.1i3zXuS.Jy1auazhHXeBCD6/ppkVrW');
```

## User and Roles
| Username | Password | Roles | Query | 
|---------|----------|-------|-------|
| admin1 | password | ADMIN | `select a1_0.id,a1_0.passwd,a1_0.username from t_admin a1_0 where a1_0.username=?`   | 
| user1 | password | USER  | `select u1_0.id,u1_0.passwd,u1_0.username from t_user u1_0 where u1_0.username=?`   | 

## Version
- Spring Boot 3.0.4
- MySQL 8.0.17

## Disclaimer
```
This code is provided "as is" without any guarantee whatsoever. 
Feel free to fork, add, remove, change, or do whatever you want with it. 
```