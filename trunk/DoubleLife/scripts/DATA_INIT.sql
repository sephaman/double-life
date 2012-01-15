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

--static data
insert into role values(0, 'ROLE_ADMIN');
insert into role values(1, 'ROLE_USER');

-- test data

--insert users
insert into dl_user values(0,'sepha','joe','joe','joe@joe.com','joe',0);
insert into dl_user values(1,'sepha2','joe','joe','joe@joe.com','joe',1);

--insert competition
insert into competition values (1,'General', now(), now(), 1, 0, 1000.00,null);

-- join competition
insert into comp_user values (1,0);
insert into comp_user values (1,1);

--insert user stock holdings
insert into user_stock values(0,0,'WBC.AX',22.00,500, now(),1,1);
insert into user_stock values(1,0,'CSS.AX',0.08,700, now(),1,1);

--insert static bet event types
insert into bet_event_type values(0, 'AFL', now());
insert into bet_event_type values(1, 'NRL', now());
insert into bet_event_type values(2, 'Cricket', now());

--insert bet participants
insert into bet_participant values(0, 'Melbourne', now(), 0);
insert into bet_participant values(1, 'Geelong', now(), 0);
insert into bet_participant values(2, 'Australia', now(), 2);
insert into bet_participant values(3, 'England', now(), 2);

--insert bet_event
insert into bet_event values(0, 0, now(), true, -1, 'Geelong vs Melbourne');
insert into bet_event values(1, 2, now(), true, -1, 'Australia vs England');

--insert bet_event - participants
insert into participant_betevent values(0, 0); --AFL geel vs melb
insert into participant_betevent values(0, 1);
insert into participant_betevent values(1, 2); --cricket eng vs aus
insert into participant_betevent values(1, 3);

--insert bet participant price
insert into bet_participant_price values(0, 0, 1.70, now(), 0, 'TRUE'); --afl participants
insert into bet_participant_price values(1, 1, 1.90, now(), 0, 'TRUE');
insert into bet_participant_price values(2, 2, 2.70, now(), 1, 'TRUE'); --cricket
insert into bet_participant_price values(3, 3, 1.40, now(), 1, 'TRUE');

--insert betting competition
insert into bet_competition values (1,'General', now(), now(), 1, 0, 1000.00,null);

--insert betting accounts
insert into user_betting_account values (0, 0, 1000.00, now(),1);
insert into user_betting_account values (1, 1, 1000.00, now(),1);

insert into bet values(0,)
