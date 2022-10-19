use db_social_network;

insert into user (id, first_name, last_name, username, password) values (1, 'Marko', 'Markovic', 'mare', 'mare123');
insert into user (id, first_name, last_name, username, password) values (2, 'Dusan', 'Babic', 'duka', 'duka123');

insert into post (id, content, time, user_id) values (1, 'Ovo je moj probni post! Hehehehe!', DATE('2014-09-01'), 1);
insert into post (id, content, time, user_id) values (2, 'Ovo je takodje moj probni post! Bas sam kreativan!', DATE('2015-07-02'), 2);
insert into post (id, content, time, user_id) values (3, 'Napravio sam cak jos jedan probni post!', DATE('2016-10-01'), 1);
insert into post (id, content, time, user_id) values (4, 'Ne biste verovali ali napravio sam jos jedan post!', DATE('2018-05-21'), 2);
insert into post (id, content, time, user_id) values (5, 'Mislili ste da necu, ali ipak sam napravio jos jedan post!', DATE('2019-08-04'), 1);

insert into comment (id, content, time, user_id, post_id) values (1, 'Ovo je moj prvi komentar.', DATE('2020-08-01'), 1, 1);
insert into comment (id, content, time, user_id, post_id) values (2, 'Ovo je moj drugi komentar.', DATE('2020-09-02'), 2, 2);
insert into comment (id, content, time, user_id, post_id) values (3, 'Treci komentar.', DATE('2020-10-01'), 1, 2);
insert into comment (id, content, time, user_id, post_id) values (4, 'Cetvrti komentar.', DATE('2021-10-01'), 2, 1);
insert into comment (id, content, time, user_id, post_id) values (5, 'Peti komentar.', DATE('2022-08-01'), 2, 2);

insert into label (id, name) values (1, 'discussion');
insert into label (id, name) values (2, 'question');