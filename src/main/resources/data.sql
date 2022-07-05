INSERT INTO cars (id, name, brand, type, category) VALUES (1001, 'Ferrari 488 GT3 Evo 2020', 'Ferrari', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1002, 'Audi R8 LMS', 'Audi', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1003, 'McLaren MP4-12C GT3', 'McLaren', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1004, 'Ford GT GT3', 'Ford', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1005, 'BMW M4 GT3', 'BMW', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1006, 'Porsche 911 GT3 R', 'Porsche', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1007, 'Lamborghini Huracan GT3 EVO', 'Lamborghini', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1008, 'Mercedes-AMG GT3 2020', 'Mercedes', 'road', 'gt3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1009, 'NASCAR XFINITY Chevrolet Camaro', 'Chevrolet', 'oval', 'xfinity');
INSERT INTO cars (id, name, brand, type, category) VALUES (1010, 'Dallara P217', 'Dallara', 'road', 'lmp2');


INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1001, 'TREQ 488 branding', 'top', 1001, 'TREQ Simracing Equipment', 'TREQ', 'IMSA');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1002, 'Heusinkveld Audi R8 branding', 'sides', 1002, 'Heusinkveld Engineering', 'Heusinkveld Engineering', 'VRS');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1003, 'iOverlay branding', 'front', 1003, 'Joepie', 'iOverlay inc.', 'World Series');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1004, 'Forzilla 2022', 'total', 1004, 'Pablo', 'Fordzilla', 'VRS');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1005, 'BS+ Competition', 'wing', 1005, 'Ryan', 'Buro Süd', 'Sim Cup');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1006, 'IRNL GT3 league', 'decal', 1006, 'Jan', 'iRacing Nederland', 'IRNL GT3 League');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1007, 'Squadra Corse', 'sides', 1007, 'Ferruccio', 'Lamborghini', 'Super Trofeo');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1008, 'Mercedes-AMG GT3', 'total', 1008, 'Günther', 'Mercedes', 'IMSA');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1009, 'Johnny Rabit Racing', 'sides', 1009, 'Brad Pitlimiter', 'NASCAR', 'XFINITY');

INSERT INTO events (id, name, private_event, event_date) VALUES (1001, 'Daytona 24hr', false, '25-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1002, 'Watkins 6hr', false, '24-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1003, 'Spa 24hr', false, '1-12-2022');

INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1001);
INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1002);
INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1003);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1005);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1006);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1008);

INSERT INTO users (username, apikey, password, email, enabled) VALUES ('max', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C','max@user.nl', true);
INSERT INTO users (username, apikey, password, email, enabled) VALUES ('jos', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C', 'jos@admin.nl', true);

INSERT INTO authorities (username, authority) VALUES ('max', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('jos', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('jos', 'ROLE_ADMIN');