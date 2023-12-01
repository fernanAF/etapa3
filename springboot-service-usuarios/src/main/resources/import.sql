INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('AlanFdo', '12345', 1, 'Alan', 'Perez', 'alan.perezlp@uanl.edu.mx');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('juanuchiha99', '12345', 1, 'Juan', 'Lopez', 'juanuchiha99@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(1,1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2,2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2,1);
