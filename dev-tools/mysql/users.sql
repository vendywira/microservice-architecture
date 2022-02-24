CREATE USER 'order_service' IDENTIFIED WITH mysql_native_password BY 'p@ssw0rd123';
GRANT ALL ON order_service.* TO 'order_service';