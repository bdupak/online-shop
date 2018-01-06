CREATE DATABASE IF NOT EXISTS online_shop;
USE online_shop;
CREATE TABLE IF NOT EXISTS user(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  login varchar(64) NOT NULL,
  password varchar(256) NOT NULL,
  salt varchar(256) NOT NULL,
  name varchar(64),
  surname varchar(64),
  age int,
  phone_number varchar(64),
  discount int,
  address_fk int,
  role_fk int,
  img_url varchar(256),
  uuid varchar(256),
  reg_date datetime,
  lang enum ('en', 'uk-UA') DEFAULT 'en',
  is_deleted bit(1) DEFAULT b'0'
);

CREATE TABLE IF NOT EXISTS address(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  country varchar(64),
  city varchar(64),
  street varchar(64),
  zipcode varchar(64)
);

ALTER TABLE user
  ADD FOREIGN KEY(address_fk) REFERENCES address(id);

CREATE TABLE IF NOT EXISTS role(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  role varchar(64)
);

ALTER TABLE user
  ADD FOREIGN KEY(role_fk) REFERENCES role(id);

CREATE TABLE IF NOT EXISTS product(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name varchar(64),
  overview varchar(64),
  price double,
  weight int,
  size varchar(64),
  img_url varchar(256),
  is_deleted bit(1) DEFAULT b'0',
  category_fk int
);

CREATE TABLE IF NOT EXISTS category(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  category varchar(64)
);

ALTER TABLE product
  ADD FOREIGN KEY (category_fk) REFERENCES category(id);

CREATE TABLE IF NOT EXISTS product_feedback(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  product_fk int,
  user_fk int,
  date datetime,
  mark int,
  advantages varchar(1024),
  disadvantages varchar(1024),
  feedback varchar(2048),
  FOREIGN KEY (product_fk) REFERENCES product(id),
  FOREIGN KEY (user_fk) REFERENCES USER(id)
);

CREATE TABLE IF NOT EXISTS orders(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  user_fk int,
  product_fk int,
  date datetime,
  quantity int,
  is_delivered bit(1) DEFAULT b'0',
  FOREIGN KEY (user_fk) REFERENCES user(id),
  FOREIGN KEY (product_fk) REFERENCES product(id)
);