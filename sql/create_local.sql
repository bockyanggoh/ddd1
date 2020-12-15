drop database if exists one_db;
drop user if exists one_owner;
drop user if exists one_app;

create database one_db;
# App Account
create user one_app identified by 'passwordapp';
grant select, insert, delete, index, trigger on one_db.* to one_app;

create user one_designer identified by '';

flush privileges;