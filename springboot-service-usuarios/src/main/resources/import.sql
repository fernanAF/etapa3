INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('AlanFdo', '$2a$10$t31UUDSAP/4tInr1kr1MPutghNARNsDhEyE7B7FTZFbK.zVfvoD6K', 1, 'Alan', 'Perez', 'alan.perezlp@uanl.edu.mx');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('juanuchiha99', '$2a$10$xG/N5NFjtW3uG0dP5cfqtumE6QtWOK9fkzVtwz8PeJoHnPCqw4ivG', 1, 'Juan', 'Lopez', 'juanuchiha99@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(1,1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2,2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2,1);
