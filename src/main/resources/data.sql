INSERT INTO cars (id, name, brand, type, category) VALUES (1, 'Ferrari 488 GT3 Evo 2020', 'Ferrari', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (2, 'Audi R8 LMS', 'Audi', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (3, 'BMW M4 GT3', 'BMW', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (4, 'Ford GT GT3', 'Ford', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (5, 'McLaren MP4-12C GT3', 'McLaren', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (6, 'Porsche 911 GT3 R', 'Porsche', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (7, 'Lamborghini Huracan GT3 EVO', 'Lamborghini', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (8, 'Mercedes-AMG GT3 2020', 'Mercedes', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (9, 'NASCAR XFINITY Chevrolet Camaro', 'Chevrolet', 'oval', 'xfinity');
INSERT INTO cars (id, name, brand, type, category) VALUES (10, 'Dallara P217', 'Dallara', 'road', 'lmp2');


INSERT INTO decals (id, name, car, owner, brand, event) VALUES (1, 'TREQ M4 branding', 'BMW M4 GT3', 'TREQ Simracing Equipment', 'TREQ', 'IMSA');
INSERT INTO decals (id, name, car, owner, brand, event) VALUES (2, 'Heusinkveld Audi R8 branding', 'Audi R8 LMS', 'Heusinkveld Engineering', 'Heusinkveld Engineering', 'VRS');
INSERT INTO decals (id, name, car, owner, brand, event) VALUES (3, 'IRNL Ferrari Fixed', 'Ferrari 488 GT3 Evo 2020', 'iRacing Nederland', 'Joepie', 'private series');


INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');