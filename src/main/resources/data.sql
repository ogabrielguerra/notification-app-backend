-- CHANNELS
insert into category (category_id, name) values (1, 'Finance');
insert into category (category_id, name) values (2, 'Sports');
insert into category (category_id, name) values (3, 'Movies');

-- MESAGE TYPES
insert into message_type (message_type_id, name) values (1, 'Email');
insert into message_type (message_type_id, name) values (2, 'SMS');
insert into message_type (message_type_id, name) values (3, 'Push');

-- USERS
insert into notifier_user (id, name, email, phone_number) values (1, 'Dilbert', 'dil@comics.com', '+5521999998765');
insert into notifier_user (id, name, email, phone_number) values (2, 'Ryu', 'ryu@streetfighter.com', '+5521999998765');
insert into notifier_user (id, name, email, phone_number) values (3, 'Bram Stoker', 'bramstocker@dracula.com', '+5521999998765');

-- SUBSCRIBED CHANNELS
insert into user_category (category_id, notifier_user_id) values (1, 1);
insert into user_category (category_id, notifier_user_id) values (2, 1);
insert into user_category (category_id, notifier_user_id) values (3, 1);
insert into user_category (category_id, notifier_user_id) values (1, 2);
insert into user_category (category_id, notifier_user_id) values (2, 3);
insert into user_category (category_id, notifier_user_id) values (3, 3);
