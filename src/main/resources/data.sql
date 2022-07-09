INSERT INTO cars (id, name, brand, type, category) VALUES (1001, 'Ferrari 488 GT3 Evo 2020', 'Ferrari', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1002, 'Audi R8 LMS', 'Audi', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1003, 'McLaren MP4-12C GT3', 'McLaren', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1004, 'Porsche 992 Cup', 'Porsche', 'Road', 'Cup');
INSERT INTO cars (id, name, brand, type, category) VALUES (1005, 'Formula Vee', 'Vee', 'Open Wheel', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1006, 'Porsche 911 GT3 R', 'Porsche', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1007, 'Lamborghini Huracan GT3 EVO', 'Lamborghini', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1008, 'Mercedes-AMG GT3 2020', 'Mercedes', 'Road', 'GT3');
INSERT INTO cars (id, name, brand, type, category) VALUES (1009, 'NASCAR Chevrolet Camaro', 'Chevrolet', 'Oval', 'Next Gen');
INSERT INTO cars (id, name, brand, type, category) VALUES (1010, 'Dallara P217', 'Dallara', 'Prototype', 'LMP2');


INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1001, 'HotTub 488 branding', 'Top', 1001, 'Hottub Heroes', 'Hottub', 'Regular');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1002, 'iOverlay Audi R8 branding', 'Sides', 1002, 'Joepie', 'iOverlay inc.', 'VRS');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1003, 'iOverlay branding', 'Sides', 1005, 'Joepie', 'iOverlay inc.', 'Regular');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1004, 'Heuinkveld branding', 'Sides', 1010, 'Enzo', 'Heusinkveld', 'IMSA');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1005, 'Atari brand', 'Wing', 1003, 'Ryan', 'Atari EU', 'Sim Cup');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1006, 'Apex Missers', 'Decal', 1007, 'Tobias', 'The Apex Missers', 'private league');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1007, 'Dunder Mifflin', 'Sides', 1006, 'Dwight Schrute', 'Schrute Farms', 'VRS');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1008, 'Evil Racing 2022 VRS', 'Sides', 1008, 'Günther', 'Mercedes', 'VRS');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1009, 'Cream Filled Beaver', 'Total', 1009, 'Dave', 'Liquor What?', 'Next Gen');
INSERT INTO decals (id, name, decal_position, car_id, creator, company, series) VALUES (1010, '992 IRNL decals', 'Total', 1004, 'Lucas', 'iRacing Nederland', 'IRNL Cup');


INSERT INTO events (id, name, private_event, event_date) VALUES (1001, 'Daytona 24hr', false, '25-01-2023');
INSERT INTO events (id, name, private_event, event_date) VALUES (1002, 'Watkins 6hr', false, '15-06-2023');
INSERT INTO events (id, name, private_event, event_date) VALUES (1003, 'Bathurst 1000', false, '1-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1004, 'Petit Le Mans', false, '07-10-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1005, 'Suzuka 12hr', false, '11-11-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1006, 'Spa 24hr', false, '1-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1007, 'Nurburgring 24hr', false, '08-04-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1008, 'IVRA 24hr Barcelona', true, '08-09-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1009, 'Moradness 6hr Brands Hatch', false, '08-04-2022');

INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1001);
INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1002);
INSERT INTO event_decals (event_id, decal_id) VALUES (1001, 1003);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1005);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1006);
INSERT INTO event_decals (event_id, decal_id) VALUES (1002, 1008);

INSERT INTO users (username, apikey, password, email, enabled) VALUES ('max', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C','max@user.nl', true);
INSERT INTO users (username, apikey, password, email, enabled) VALUES ('jos', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C', 'jos@admin.nl', true);

INSERT INTO authorities (username, authority) VALUES ('max', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('jos', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('jos', 'ROLE_USER');


