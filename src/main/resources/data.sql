INSERT INTO user (name, email, phonenum) VALUES ('Alice', 'alice@example.com','110');
INSERT INTO user (name, email, phonenum) VALUES ('Bob', 'bob@example.com','120');
INSERT INTO user (name, email, phonenum) VALUES ('Coco', 'coco@example.com','12345');
INSERT INTO user (name, email, phonenum) VALUES ('Sunny', 'sunny@example.com',NULL);


INSERT INTO saveaccount (name, balance) VALUES ('Sunny', 88888888);
INSERT INTO saveaccount (name, balance) VALUES ('Coco', 99999999);
INSERT INTO saveaccount (name, balance) VALUES ('Bob', 666666);
INSERT INTO saveaccount (name, balance) VALUES ('Alice', 678999);
INSERT INTO saveaccount (name, balance) VALUES ('starnge', 0);


INSERT INTO student (name, age) VALUES ('leo', 13);
INSERT INTO student (name, age) VALUES ('max', 11);
INSERT INTO student (name, age) VALUES ('lisa', 15);
INSERT INTO student (name, age) VALUES ('lily', 12);

INSERT INTO customer (name) VALUES ('John');
INSERT INTO customer (name) VALUES ('Alex');
INSERT INTO customer (name) VALUES ('Leonid');
INSERT INTO customer (name) VALUES ('Kobi');

INSERT INTO orders (order_name, customer_id) VALUES ('book chicken', 1);
INSERT INTO orders (order_name, customer_id) VALUES ('book vegitable', 1);
INSERT INTO orders (order_name, customer_id) VALUES ('book water', 3);
INSERT INTO orders (order_name, customer_id) VALUES ('book beer', 4);

-- yourPassword1
INSERT INTO usersregistry (username, password, role)
VALUES ('testuser1', '$2a$10$y91elD6sWxIiyCvDuuZiAe/8zcyGNeWwrQoBQ4mmIVCVxo84y9mYO', 'USER');

-- yourPassword2
INSERT INTO usersregistry (username, password, role)
VALUES ('testuser2', '$2a$10$mzv9/b5I5zG4SJu0.A9tqegfAI3sK6L.KXKmCdnKdCRYcf9G.JWXS', 'USER');

-- sunny
INSERT INTO usersregistry (username, password, role)
VALUES ('sunny', '$2a$10$rHwf40SfuxXavqHig1MxV.H37pf.hl7u4/4DdPtli.NZbedse7qzq', 'USER');

-- sunny8
INSERT INTO usersregistry (username, password, role)
VALUES ('sunny8', '$2a$10$pVgHY5.s4p8aKJJfu4MGhOTDRHWHlXJRLFuV8U6Xvlvmkiw7OHdVG', 'USER');

