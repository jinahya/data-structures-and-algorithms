CREATE USER 'sakila'@'%' IDENTIFIED BY 'sakila';
GRANT SELECT, SHOW VIEW ON sakila.* TO 'sakila'@'%';
FLUSH PRIVILEGES;