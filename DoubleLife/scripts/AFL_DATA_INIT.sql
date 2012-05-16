-- inserts data into database for the AFL


-- run this to reset database data

truncate dl_user cascade;
truncate bank_account cascade;
truncate banking_transaction cascade;
truncate bet cascade;
truncate bet_competition cascade;
truncate bet_event cascade;
truncate bet_event_type cascade;
truncate bet_participant cascade;
truncate betcomp_user cascade;
truncate comp_user cascade;
truncate competition cascade;
truncate participant_betevent cascade;
truncate stock_order cascade;
truncate user_betting_account cascade;
truncate user_group cascade;
truncate user_stock cascade;
truncate usergroup_user cascade;
truncate role cascade;
truncate bet_participant_price cascade;
truncate season cascade;
truncate round cascade;

--static data
insert into role values(1, 'ROLE_ADMIN');
insert into role values(2, 'ROLE_USER');

-- test data

--insert users
insert into dl_user values(1,'sepha','joe','joe','joe@joe.com','joe',1);

--insert betting competition
insert into bet_competition values (1,'General', now(), now(), 1, 0, 1000.00, null);

--insert betting competition rules
insert into bet_comp_rules values (1,true, 100, true, true, 1);

--insert bet event type
insert into bet_event_type values(1, 'AFL', now());

--insert comp account
insert into user_betting_account values(1,1,1000,now(),1);

--insert user comp
insert into betcomp_user values(1,1);

--insert season
insert into season values(1, 1, '2012 Toyota AFL Premiership Season', now());

--insert bet participants
insert into bet_participant values(1, 'Melbourne', now(), 1,'/resources/img/aflteams/melbourne.jpg', 39987, 31);
insert into bet_participant values(2, 'Geelong', now(), 1,'/resources/img/aflteams/geelong.jpg', 244663, 30);
insert into bet_participant values(3, 'Hawthorn', now(), 1,'/resources/img/aflteams/hawthorn.jpg', 244664, 32);
insert into bet_participant values(4, 'Essendon', now(), 1,'/resources/img/aflteams/essendon.jpg', 210343, 37);
insert into bet_participant values(5, 'North Melbourne', now(), 1,'/resources/img/aflteams/north.jpg', 2013991, 45);
insert into bet_participant values(6, 'Sydney', now(), 1,'/resources/img/aflteams/sydney.jpg', 244665, 33) ;
insert into bet_participant values(7, 'Carlton', now(), 1,'/resources/img/aflteams/carlton.jpg', 244689, 43);
insert into bet_participant values(8, 'Collingwood', now(), 1,'/resources/img/aflteams/collingwood.jpg', 39983, 38);
insert into bet_participant values(9, 'Richmond', now(), 1,'/resources/img/aflteams/richmond.jpg', 244667, 42);
insert into bet_participant values(10, 'Adelaide', now(), 1,'/resources/img/aflteams/adelaide.jpg', 173363, 40);
insert into bet_participant values(11, 'Port Adelaide', now(), 1,'/resources/img/aflteams/portAdelaide.jpg', 4570081, 41);
insert into bet_participant values(12, 'Fremantle', now(), 1,'/resources/img/aflteams/fremantle.jpg', 244666, 34);
insert into bet_participant values(13, 'Brisbane', now(), 1,'/resources/img/aflteams/brisbane.jpg', 39984, 36);
insert into bet_participant values(14, 'West Coast', now(), 1,'/resources/img/aflteams/westcoast.jpg', 210344, 35);
insert into bet_participant values(15, 'Greater Western Sydney', now(), 1,'/resources/img/aflteams/gws.jpg', 5149403, 72);
insert into bet_participant values(16, 'Gold Coast', now(), 1,'/resources/img/aflteams/goldcoast.jpg', 4997061, 71);
insert into bet_participant values(17, 'Western Bulldogs', now(), 1,'/resources/img/aflteams/bulldogs.jpg', 39986, 44);
insert into bet_participant values(18, 'St Kilda', now(), 1,'/resources/img/aflteams/saints.jpg', 244688, 39);

--insert rounds
insert into round values(1, 1, 1, '2012 AFL Round 1');
insert into round values(2, 1, 2, '2012 AFL Round 2');
insert into round values(3, 1, 3, '2012 AFL Round 3');
insert into round values(4, 1, 4, '2012 AFL Round 4');
insert into round values(5, 1, 5, '2012 AFL Round 5');
insert into round values(6, 1, 6, '2012 AFL Round 6');
insert into round values(7, 1, 7, '2012 AFL Round 7');
insert into round values(8, 1, 8, '2012 AFL Round 8');
insert into round values(9, 1, 9, '2012 AFL Round 9');
insert into round values(10, 1, 10, '2012 AFL Round 10');
insert into round values(11, 1, 11, '2012 AFL Round 11');
insert into round values(12, 1, 12, '2012 AFL Round 12');
insert into round values(13, 1, 13, '2012 AFL Round 13');
insert into round values(14, 1, 14, '2012 AFL Round 14');
insert into round values(15, 1, 15, '2012 AFL Round 15');
insert into round values(16, 1, 16, '2012 AFL Round 16');
insert into round values(17, 1, 17, '2012 AFL Round 17');
insert into round values(18, 1, 18, '2012 AFL Round 18');
insert into round values(19, 1, 19, '2012 AFL Round 19');
insert into round values(20, 1, 20, '2012 AFL Round 20');
insert into round values(21, 1, 21, '2012 AFL Round 21');
insert into round values(22, 1, 22, '2012 AFL Round 22');
insert into round values(23, 1, 23, '2012 AFL Round 23');

-- set up round one bet events
insert into bet_event values(1, 1, now(), true, -1, 'GWS vs Sydney', 1, 15, 6);
insert into bet_event values(2, 1, now(), true, -1, 'Richmond vs Carlton', 1, 9, 7);
insert into bet_event values(3, 1, now(), true, -1, 'Hawthorn vs Collingwood', 1, 3, 8);
insert into bet_event values(4, 1, now(), true, -1, 'Melbourne vs Brisbane', 1, 1, 13);
insert into bet_event values(5, 1, now(), true, -1, 'Gold Coast vs Adelaide', 1, 16, 10);
insert into bet_event values(6, 1, now(), true, -1, 'Fremantle vs Geelong', 1, 12, 2);
insert into bet_event values(7, 1, now(), true, -1, 'North Melbourne vs Essendon', 1, 5, 4);
insert into bet_event values(8, 1, now(), true, -1, 'Western Bulldogs vs West Coast', 1, 17, 14);
insert into bet_event values(9, 1, now(), true, -1, 'Port Adelaide vs St Kilda', 1, 11, 18);

insert into participant_betevent values(1, 15);
insert into participant_betevent values(1, 6);
insert into participant_betevent values(2, 9);
insert into participant_betevent values(2, 7);
insert into participant_betevent values(3, 3);
insert into participant_betevent values(3, 8);
insert into participant_betevent values(4, 1);
insert into participant_betevent values(4, 13);
insert into participant_betevent values(5, 16);
insert into participant_betevent values(5, 10);
insert into participant_betevent values(6, 12);
insert into participant_betevent values(6, 2);
insert into participant_betevent values(7, 5);
insert into participant_betevent values(7, 4);
insert into participant_betevent values(8, 17);
insert into participant_betevent values(8, 14);
insert into participant_betevent values(9, 11);
insert into participant_betevent values(9, 18);


insert into bet_participant_price values(1, 15, 1.20, now(), 1, 'TRUE');
insert into bet_participant_price values(2, 6, 1.30, now(), 1, 'TRUE');
insert into bet_participant_price values(3, 9, 1.40, now(), 2, 'TRUE');
insert into bet_participant_price values(4, 7, 1.50, now(), 2, 'TRUE');
insert into bet_participant_price values(5, 3, 1.60, now(), 3, 'TRUE');
insert into bet_participant_price values(6, 8, 1.70, now(), 3, 'TRUE');
insert into bet_participant_price values(7, 1, 1.80, now(), 4, 'TRUE');
insert into bet_participant_price values(8, 13, 1.90, now(), 4, 'TRUE');
insert into bet_participant_price values(9, 16, 1.80, now(), 5, 'TRUE');
insert into bet_participant_price values(10, 10, 1.70, now(), 5, 'TRUE');
insert into bet_participant_price values(11, 12, 1.60, now(), 6, 'TRUE');
insert into bet_participant_price values(12, 2, 1.50, now(), 6, 'TRUE');
insert into bet_participant_price values(13, 5, 1.40, now(), 7, 'TRUE');
insert into bet_participant_price values(14, 4, 1.30, now(), 7, 'TRUE');
insert into bet_participant_price values(15, 17, 1.20, now(), 8, 'TRUE');
insert into bet_participant_price values(16, 14, 1.10, now(), 8, 'TRUE');
insert into bet_participant_price values(17, 11, 1.20, now(), 9, 'TRUE');
insert into bet_participant_price values(18, 18, 1.30, now(), 9, 'TRUE');

-- set up round two
insert into bet_event values(11, 1, now(), true, -1, 'Brisbane vs Carlton', 2, 13, 7);
insert into bet_event values(12, 1, now(), true, -1, 'Essendon vs Port Adelaide', 2, 4, 11);
insert into bet_event values(13, 1, now(), true, -1, 'Sydney vs Fremantle', 2, 6, 12);
insert into bet_event values(14, 1, now(), true, -1, 'West Coast vs Melbourne', 2, 14, 1);
insert into bet_event values(15, 1, now(), true, -1, 'Adelaide vs Western Bulldogs', 2, 10, 17);
insert into bet_event values(16, 1, now(), true, -1, 'Collingwood vs Richmond', 2, 8, 9);
insert into bet_event values(17, 1, now(), true, -1, 'North Melbourne vs GWS', 2, 5, 15);
insert into bet_event values(18, 1, now(), true, -1, 'St Kilda vs Gold Coast', 2, 18, 16);
insert into bet_event values(19, 1, now(), true, -1, 'Geelong vs Hawthorn', 2, 2, 3);

insert into participant_betevent values(11, 13);
insert into participant_betevent values(11, 7);
insert into participant_betevent values(12, 4);
insert into participant_betevent values(12, 11);
insert into participant_betevent values(13, 6);
insert into participant_betevent values(13, 12);
insert into participant_betevent values(14, 14);
insert into participant_betevent values(14, 1);
insert into participant_betevent values(15, 10);
insert into participant_betevent values(15, 17);
insert into participant_betevent values(16, 8);
insert into participant_betevent values(16, 9);
insert into participant_betevent values(17, 5);
insert into participant_betevent values(17, 15);
insert into participant_betevent values(18, 18);
insert into participant_betevent values(18, 16);
insert into participant_betevent values(19, 2);
insert into participant_betevent values(19, 3);


insert into bet_participant_price values(21, 13, 1.20, now(), 11, 'TRUE');
insert into bet_participant_price values(22, 7, 1.30, now(), 11, 'TRUE');
insert into bet_participant_price values(23, 4, 1.40, now(), 12, 'TRUE');
insert into bet_participant_price values(24, 11, 1.50, now(), 12, 'TRUE');
insert into bet_participant_price values(25, 6, 1.60, now(), 13, 'TRUE');
insert into bet_participant_price values(26, 12, 1.70, now(), 13, 'TRUE');
insert into bet_participant_price values(27, 14, 1.80, now(), 14, 'TRUE');
insert into bet_participant_price values(28, 1, 1.90, now(), 14, 'TRUE');
insert into bet_participant_price values(29, 10, 1.80, now(), 15, 'TRUE');
insert into bet_participant_price values(30, 17, 1.70, now(), 15, 'TRUE');
insert into bet_participant_price values(31, 8, 1.60, now(), 16, 'TRUE');
insert into bet_participant_price values(32, 9, 1.50, now(), 16, 'TRUE');
insert into bet_participant_price values(33, 5, 1.40, now(), 17, 'TRUE');
insert into bet_participant_price values(34, 15, 1.30, now(), 17, 'TRUE');
insert into bet_participant_price values(35, 18, 1.20, now(), 18, 'TRUE');
insert into bet_participant_price values(36, 16, 1.10, now(), 18, 'TRUE');
insert into bet_participant_price values(37, 2, 1.20, now(), 19, 'TRUE');
insert into bet_participant_price values(88, 3, 1.30, now(), 19, 'TRUE');

