INSERT INTO user (name, email, phonenum) VALUES ('Alice', 'alice@example.com','110');
INSERT INTO user (name, email, phonenum) VALUES ('Bob', 'bob@example.com','120');
INSERT INTO user (name, email, phonenum) VALUES ('Coco', 'coco@example.com','12345');
INSERT INTO user (name, email, phonenum) VALUES ('Sunny', 'sunny@example.com',NULL);


INSERT INTO saveaccount (name, balance) VALUES ('Sunny', 88888888);
INSERT INTO saveaccount (name, balance) VALUES ('Coco', 99999999);
INSERT INTO saveaccount (name, balance) VALUES ('Bob', 666666);
INSERT INTO saveaccount (name, balance) VALUES ('Alice', 678999);
INSERT INTO saveaccount (name, balance) VALUES ('starnge', 0);


INSERT INTO student (name, age) VALUES ('leo', 10);
INSERT INTO student (name, age) VALUES ('max', 11);
INSERT INTO student (name, age) VALUES ('lisa', 41);
INSERT INTO student (name, age) VALUES ('lily', 12);

INSERT INTO customer (name) VALUES ('John');
INSERT INTO customer (name) VALUES ('Alex');
INSERT INTO customer (name) VALUES ('Leonid');
INSERT INTO customer (name) VALUES ('Kobi');

INSERT INTO orders (order_name, customer_id) VALUES ('book chicken', 1);
INSERT INTO orders (order_name, customer_id) VALUES ('book vegitable', 1);
INSERT INTO orders (order_name, customer_id) VALUES ('book water', 3);
INSERT INTO orders (order_name, customer_id) VALUES ('book beer', 4);
