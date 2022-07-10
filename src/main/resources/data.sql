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
INSERT INTO cars (id, name, brand, type, category) VALUES (1011, 'Formula F4', 'Dallara', 'Open Wheel', 'F4');

INSERT INTO events (id, name, private_event, event_date) VALUES (1001, 'Daytona 24hr', false, '25-01-2023');
INSERT INTO events (id, name, private_event, event_date) VALUES (1002, 'Watkins 6hr', false, '15-06-2023');
INSERT INTO events (id, name, private_event, event_date) VALUES (1003, 'Bathurst 1000', false, '1-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1004, 'Petit Le Mans', false, '07-10-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1005, 'Suzuka 12hr', false, '11-11-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1006, 'Spa 24hr', false, '1-12-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1007, 'Nurburgring 24hr', false, '08-04-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1008, 'IVRA 24hr Barcelona', true, '08-09-2022');
INSERT INTO events (id, name, private_event, event_date) VALUES (1009, 'Moradness 6hr Brands Hatch', false, '08-04-2022');

INSERT INTO users (username, apikey, password, email, enabled) VALUES ('max', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C','max@user.nl', true);
INSERT INTO users (username, apikey, password, email, enabled) VALUES ('jos', null, '$2a$12$p.51Ae98h.c7L3WtyjycOOZkzS5uEibkKxOeGsaUepNw8Rn7pCN5C', 'jos@admin.nl', true);

INSERT INTO authorities (username, authority) VALUES ('max', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('jos', 'ROLE_ADMIN');