INSERT INTO USERS(NAME, EMAIL, PASSWORD, ROLE) VALUES
("Admin", "Admin", "pass", "admin"),
("Zaher", "a@b.com", "pass1", "user"),
("Salah", "c@d.com", "pass2", "user"),
("Fawzi", "e@f.com", "pass3", "user");


INSERT INTO ADDRESSES(COUNTRY, CITY, STREET_ADDRESS, USER_ID) VALUES
("EGY", "Cairo", "1st", 1),
("EGY", "Alex", "10th", 1),
("EGY", "Cairo", "2nd", 2),
("EGY", "Cairo", "3rd", 3);

INSERT INTO FEEDBACK(USER_ID, USER_COMMENT) VALUES
(1, "WOW, really liked it xD"),
(2, "Interesting..."),
(3, "Test1"),
(3, "Test2"),
(3, "Test3");

INSERT INTO ITEMS(NAME, S_PRICE, M_PRICE, L_PRICE, URL) VALUES
("Cheese Burger"	, 30, 40, 50, "img/meals/Burger1.jpg"),
("BBQ Pizza"		, 50, 60, 70, "img/meals/Pizza1.jpg"),
("Blizzard"			, 30, 40, 50, "img/meals/DQ1.jpg"),
("Apple Pie"		, 12, 20, 35, "img/meals/Pie1.jpg"),
("Pepsi"			, 10, 15, 20, "img/meals/Pepsi1.jpg");


-- Inserting some orders for testing 

INSERT INTO ORDERS(USER_ID, TOTAL_PRICE) VALUES
(1, 60);

INSERT INTO ORDERS_ITEMS(ORDER_ID, ITEM_ID, ITEM_SIZE, QUANTITY) VALUES
(1, 2, "S", 1),
(1, 5, "S", 1);

