INSERT INTO s243140.users (user_id, email, name, image) VALUES (0, 'firstuser@gmail.com', 'First User', 'http://isu.ifmo.ru/pls/apex/f?p=2143:0::AVATAR:NO::T_UID:105395');
INSERT INTO s243140.users (user_id, email, name, image) VALUES (1, 'seconduser@gmail.com', 'Second User', 'http://isu.ifmo.ru/pls/apex/f?p=2143:0::AVATAR:NO::T_UID:105395');

INSERT INTO s243140.accounts (account_id, account_name, balance, card_number, user_id) VALUES (0, 'Счет 1 ', 100, '5432 0000 0000 0000', 0);
INSERT INTO s243140.accounts (account_id, account_name, balance, card_number, user_id) VALUES (1, 'Счет 2', 200, '5432 0000 0000 0001', 0);
INSERT INTO s243140.accounts (account_id, account_name, balance, card_number, user_id) VALUES (2, 'Счет 1', 0, '5432 0000 0000 0002', 1);
INSERT INTO s243140.accounts (account_id, account_name, balance, card_number, user_id) VALUES (3, 'Счет 2', 50, '5432 0000 0000 0003', 1);

INSERT INTO s243140.questions (question_id, text, type) VALUES (0, 'Сколько раз вам было радостно сегодня?', false);
INSERT INTO s243140.questions (question_id, text, type) VALUES (1, 'Сколько раз вам было грустно сегодня?', false);
INSERT INTO s243140.questions (question_id, text, type) VALUES (2, 'Сколько раз у вас была отдышка?', true);
INSERT INTO s243140.questions (question_id, text, type) VALUES (3, 'Сколько раз вы чувствовали усталость?', true);

INSERT INTO s243140.shop (shop_id, address, name) VALUES (0, 'Миргородская 3', 'ИКЕЯ');
INSERT INTO s243140.shop (shop_id, address, name) VALUES (1, 'Фрунзе 5', 'ОКЕЙ');

INSERT INTO s243140.products (product_id, cost, description, image_url, name, shop_id, bablos) VALUES (0, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at lorem vitae enim ultrices feugiat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'https://www.ikea.com/ru/ru/images/products/adde-stul-chernyy__0728277_pe736167_s5.jpg?f=s', 'Стул 1', 0,3);
INSERT INTO s243140.products (product_id, cost, description, image_url, name, shop_id, bablos) VALUES (1, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at lorem vitae enim ultrices feugiat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'https://www.ikea.com/ru/ru/images/products/adde-stul-chernyy__0728277_pe736167_s5.jpg?f=s', 'Стул 2', 0,2);
INSERT INTO s243140.products (product_id, cost, description, image_url, name, shop_id, bablos) VALUES (2, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at lorem vitae enim ultrices feugiat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'https://www.ikea.com/ru/ru/images/products/adde-stul-chernyy__0728277_pe736167_s5.jpg?f=s', 'Стул 3', 1, 4);
INSERT INTO s243140.products (product_id, cost, description, image_url, name, shop_id, bablos) VALUES (3, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at lorem vitae enim ultrices feugiat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'https://www.ikea.com/ru/ru/images/products/adde-stul-chernyy__0728277_pe736167_s5.jpg?f=s', 'Стул 4',1, 5);
INSERT INTO s243140.orders (order_id, order_date, summ, user_id) VALUES (1, '2023-01-23 00:08:51.000000', 4, 0);
INSERT INTO s243140.orders (order_id, order_date, summ, user_id) VALUES (0, '2023-01-23 00:07:33.000000', 4, 0);
INSERT INTO s243140.product_order (order_id, product_id) VALUES (0, 0);
INSERT INTO s243140.product_order (order_id, product_id) VALUES (0, 1);
INSERT INTO s243140.product_order (order_id, product_id) VALUES (1, 2);
INSERT INTO s243140.product_order (order_id, product_id) VALUES (1, 3);