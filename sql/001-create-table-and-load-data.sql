DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  age int NOT NULL,
  site VARCHAR(50) NOT NULL,
  staff VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO customers (id, name, age, site, staff) VALUES (1, "tanaka", 35, "shoulder", "yamada");
INSERT INTO customers (id, name, age, site, staff) VALUES (2, "suzuki", 28, "neck", "yamamoto");
