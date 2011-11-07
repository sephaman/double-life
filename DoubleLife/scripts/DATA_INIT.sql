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

--static data
insert into role values(0, 'ROLE_ADMIN');
insert into role values(1, 'ROLE_USER');

-- test data

--insert users

--insert competition
insert into competition values (1,'General', sysdate)
--insert betting competition

