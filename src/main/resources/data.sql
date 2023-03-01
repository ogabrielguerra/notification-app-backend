-- CHANNELS
insert into channel (channel_id, name) values (1, 'Finance');
insert into channel (channel_id, name) values (2, 'Sports');
insert into channel (channel_id, name) values (3, 'Movies');

-- MESAGE TYPES
insert into message_type (message_type_id, name) values (1, 'Email');
insert into message_type (message_type_id, name) values (2, 'SMS');
insert into message_type (message_type_id, name) values (3, 'Push');

-- USERS
insert into notifier_user (id, name, email) values (1, 'Dilbert', 'dil@foo.com');
insert into notifier_user (id, name, email) values (2, 'Ryu', 'ryu@foo.com');

--
insert into notifier_user_channel (channel_id, notifier_user_id) values (1, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (2, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (3, 1);
insert into notifier_user_channel (channel_id, notifier_user_id) values (1, 2);


-- MESSAGES
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 1, 1, 'Finance message body 1');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 1, 2, 'Finance message body 2');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 2, 1, 'Sports message body 1');
--insert into message (id, message_type_id, channel_id, notifier_user_id, body) values ((next value for message_seq), 1, 2, 2, 'Sports message body 2');
--alter sequence message_seq restart with 5;