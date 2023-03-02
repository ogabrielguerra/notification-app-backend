-- CHANNELS
insert into channel (channel_id, name) values (1, 'Finance');
insert into channel (channel_id, name) values (2, 'Sports');
insert into channel (channel_id, name) values (3, 'Movies');

-- MESAGE TYPES
insert into message_type (message_type_id, name) values (1, 'Email');
insert into message_type (message_type_id, name) values (2, 'SMS');
insert into message_type (message_type_id, name) values (3, 'Push');

-- USERS
insert into notifier_user (id, name, email, phone_number) values (1, 'Dilbert', 'dil@comics.com', '+5521999998765');
insert into notifier_user (id, name, email, phone_number) values (2, 'Ryu', 'ryu@streetfighter.com', '+5521999998765');
insert into notifier_user (id, name, email, phone_number) values (3, 'Bram Stoker', 'bramstocker@dracula.com', '+5521999998765');

-- SUBSCRIBED CHANNELS
insert into notifier_user_channel (channel_id, notifier_user_id) values (1, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (2, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (3, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (1, 2);
insert into notifier_user_channel (channel_id, notifier_user_id) values (2, 3);
insert into notifier_user_channel (channel_id, notifier_user_id) values (3, 3);

-- MESSAGES
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 1, 1, 'Finance message body 1');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 1, 2, 'Finance message body 2');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 2, 1, 'Sports message body 1');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 2, 2, 'Sports message body 2');
--alter sequence message_seq restart with 5;