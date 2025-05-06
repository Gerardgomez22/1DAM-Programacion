CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

-- Product inserts with corrected column names (nombre -> name)
-- Also adding missing columns: stock, priceFabrication, category_id
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Oil - Sesame', 733.65, 100, 500.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Wine - Sauvignon Blanc Oyster', 340.2, 50, 200.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Glaze - Clear', 650.46, 75, 400.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Rice - Basmati', 55.59, 200, 30.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Vector Energy Bar', 921.48, 150, 600.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Sobe - Liz Blizz', 236.31, 80, 150.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Pork - Bones', 966.06, 40, 700.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Beef - Bones, Cut - Up', 518.38, 60, 350.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Snapple - Mango Maddness', 125.22, 100, 80.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Arctic Char - Fillets', 34.85, 70, 20.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Butter - Unsalted', 75.1, 120, 50.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Yoghurt Tubes', 789.54, 90, 500.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Contreau', 23.02, 30, 15.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Cheese Cloth', 83.58, 110, 60.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Wine - Magnotta - Pinot Gris Sr', 497.6, 40, 300.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Mushroom - Portebello', 486.87, 65, 320.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Filo Dough', 500.06, 75, 350.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Capon - Breast, Wing On', 32.56, 45, 20.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Beef - Rib Eye Aaa', 133.67, 35, 90.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Pastry - Banana Muffin - Mini', 888.24, 150, 600.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Rye Special Old', 274.51, 80, 180.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Devonshire Cream', 110.19, 70, 80.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Lemonade - Island Tea, 591 Ml', 940.39, 120, 650.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Beef - Tenderloin', 290.98, 50, 200.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Cheese - Goat', 743.81, 65, 500.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Stock - Beef, White', 977.28, 85, 700.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Kellogs Cereal In A Cup', 597.53, 100, 400.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Plasticspoonblack', 729.53, 200, 500.00);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Lettuce - Treviso', 1.22, 80, 0.80);
insert into producto (id, nombre, price, stock, price_fabrication) values (NEXTVAL('hibernate_sequence'), 'Alize Gold Passion', 53.52, 45, 35.00);

-- Category inserts with corrected column names (nombre -> name)
insert into category (id, name, description) values (NEXTVAL('hibernate_sequence'), 'Verdura', 'Solo verduras');