DROP TABLE menu_item;
DROP TABLE menu;
CREATE TABLE menu
(
	name VARCHAR(10) PRIMARY KEY,
	description VARCHAR(30),
	link_url varchar(50)
);


CREATE TABLE menu_item
(
	menu_name VARCHAR(10),
	menu_seq INT,
	name VARCHAR(10),
	link_url varchar(50),
	PRIMARY KEY(menu_name,menu_seq),
	FOREIGN KEY (menu_name)
		REFERENCES menu(name)
		ON DELETE CASCADE
);