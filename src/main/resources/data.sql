INSERT INTO cars (id, car_name) VALUES (1, 'Ferrari 488 GT3 Evo 2020');
INSERT INTO cars (id, car_name) VALUES (2, 'Audi R8 LMS');
INSERT INTO cars (id, car_name) VALUES (3, 'BMW M4 GT3');
INSERT INTO cars (id, car_name) VALUES (4, 'Ford GT GT3');
INSERT INTO cars (id, car_name) VALUES (5, 'McLaren MP4-12C GT3');
INSERT INTO cars (id, car_name) VALUES (6, 'Porsche 911 GT3 R');
INSERT INTO cars (id, car_name) VALUES (7, 'Lamborghini Huracan GT3 EVO');
INSERT INTO cars (id, car_name) VALUES (8, 'Mercedes-AMG GT3 2020');

INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');