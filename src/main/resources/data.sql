INSERT INTO cars (id, name, brand, type, category) VALUES (1001, 'Ferrari 488 GT3 Evo 2020', 'Ferrari', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1002, 'Audi R8 LMS', 'Audi', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1003, 'BMW M4 GT3', 'BMW', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1004, 'Ford GT GT3', 'Ford', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1005, 'McLaren MP4-12C GT3', 'McLaren', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1006, 'Porsche 911 GT3 R', 'Porsche', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1007, 'Lamborghini Huracan GT3 EVO', 'Lamborghini', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1008, 'Mercedes-AMG GT3 2020', 'Mercedes', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1009, 'NASCAR XFINITY Chevrolet Camaro', 'Chevrolet', 'oval', 'xfinity');
INSERT INTO cars (id, name, brand, type, category) VALUES (1010, 'Dallara P217', 'Dallara', 'road', 'lmp2');


INSERT INTO decals (id, name, car, creator, company, series) VALUES (1001, 'TREQ M4 branding', 'BMW M4 GT3', 'TREQ Simracing Equipment', 'TREQ', 'IMSA');
INSERT INTO decals (id, name, car, creator, company, series) VALUES (1002, 'Heusinkveld Audi R8 branding', 'Audi R8 LMS', 'Heusinkveld Engineering', 'Heusinkveld Engineering', 'VRS');
INSERT INTO decals (id, name, car, creator, company, series) VALUES (1003, 'IRNL Ferrari Fixed', 'Ferrari 488 GT3 Evo 2020', 'iRacing Nederland', 'Joepie', 'private series');

INSERT INTO events (id, name, available_cars, private_event, event_date) VALUES (1001, 'Daytona 24hr', 'Mercedes-AMG GT3 2020', false, '25-12-2022');

INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');