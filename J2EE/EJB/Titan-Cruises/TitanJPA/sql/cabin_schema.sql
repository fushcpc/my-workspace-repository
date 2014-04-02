create table cabin(
	id int primary key not null,
	ship_id int,
	bed_count int,
	name char(30),
	deck_level int
);



create table credit_card(
  id int primary key not null,
  exp_date date,
  no char(20),
  name char(40),
  organization char(20)
);

create table customer(
  id int primary key not null,
  first_name char(20),
  last_name char(20),
  address_id int,
  credit_card_id int
);

create table phone(
  id int primary key not null,
  no char(20),
  type int,
  customer_id int
);

create table customer_phone(
  customer_id int not null,
  phone_id int not null unique
);

create table ship(
  id int primary key not null,
  name char(30),
  tonnage decimal(8,2)
);

create table cruise(
  id int primary key not null,
  name char(30),
  ship_id int
);

create table reservation(
  id int primary key not null,
  amount_paid decimal(8,2),
  date_reserved date,
  cruise_id int
);

create table reservation_customer(
  reservation_id int,
  customer_id int
);

create table cabin_reservation(
  reservation_id int,
  cabin_id int
);

create table payment(
	customer_id integer,
	amount decimal(8,2),
	type char(10),
	check_bar_code char(50),
	check_number integer,
	credit_number char(20),
	credit_exp_date date
);

create table address(
	id int primary key,
	street char(40),
	city char(20),
	state char(2),
	zip char(10)
);
