CREATE TABLE acct_user
(
  acctid integer NOT NULL,
  userid integer NOT NULL,
  CONSTRAINT acct_user_pkey PRIMARY KEY (acctid , userid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE acct_user
  OWNER TO postgres;
  
 CREATE TABLE bank_account
(
  id integer NOT NULL,
  comp_id integer NOT NULL,
  bank_acct_type integer NOT NULL,
  amount double precision NOT NULL DEFAULT 0.00,
  acct_start_date date,
  update_datetime date,
  is_active boolean,
  created_by_userid integer,
  CONSTRAINT bank_account_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bank_account
  OWNER TO postgres;

  CREATE TABLE banking_transaction
(
  id integer NOT NULL,
  trans_amnt double precision NOT NULL DEFAULT 0.00,
  rec_acct_no integer NOT NULL,
  trans_date date NOT NULL,
  description character varying(80),
  counter_party character varying(80),
  post_trans_bal double precision,
  is_credit boolean NOT NULL,
  counter_acct_no integer NOT NULL,
  CONSTRAINT banking_transaction_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE banking_transaction
  OWNER TO postgres;
  
  CREATE TABLE bet
(
  id integer NOT NULL,
  userid integer NOT NULL,
  odds double precision NOT NULL,
  datereceived date NOT NULL,
  stake double precision NOT NULL,
  selectionid integer NOT NULL,
  betresult integer NOT NULL,
  moneypaid double precision NOT NULL,
  bet_event_id integer NOT NULL,
  compid integer NOT NULL,
  CONSTRAINT bet_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet
  OWNER TO postgres;
  
  CREATE TABLE bet_competition
(
  id integer NOT NULL,
  name character varying(60),
  comp_start_date date NOT NULL,
  update_datetime date,
  is_active integer NOT NULL,
  created_by_userid integer NOT NULL,
  acct_start_amnt double precision NOT NULL DEFAULT 1000.00,
  end_date date,
  CONSTRAINT bet_competition_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet_competition
  OWNER TO postgres;

 CREATE TABLE bet_event
(
  id integer NOT NULL,
  beteventtypeid integer NOT NULL,
  datetime date NOT NULL,
  outcomepending boolean NOT NULL DEFAULT true,
  selectionwinnerid integer NOT NULL DEFAULT (-1),
  bet_event_name character varying(100) NOT NULL,
  parent_round_id integer NOT NULL DEFAULT (-1),
  CONSTRAINT bet_event_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet_event
  OWNER TO postgres;

  CREATE TABLE bet_event_type
(
  id integer NOT NULL,
  name character varying(100),
  updatedatetime date,
  CONSTRAINT bet_event_type_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet_event_type
  OWNER TO postgres;

  CREATE TABLE bet_participant
(
  id integer NOT NULL,
  name character varying(80) NOT NULL,
  updatedatetime date NOT NULL,
  primarybeteventtypeid integer NOT NULL,
  CONSTRAINT bet_participant_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet_participant
  OWNER TO postgres;

CREATE TABLE bet_participant_price
(
  id integer NOT NULL,
  participantid integer NOT NULL,
  odds double precision NOT NULL,
  update_datetime date NOT NULL,
  beteventid integer NOT NULL,
  is_current boolean NOT NULL,
  CONSTRAINT bet_participant_price_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bet_participant_price
  OWNER TO postgres;
  
  CREATE TABLE betcomp_user
(
  betcompid integer NOT NULL,
  userid integer NOT NULL,
  CONSTRAINT betcomp_user_pkey PRIMARY KEY (betcompid , userid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE betcomp_user
  OWNER TO postgres;
  
  CREATE TABLE comp_user
(
  compid integer NOT NULL,
  userid integer NOT NULL,
  CONSTRAINT comp_user_pkey PRIMARY KEY (compid , userid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE comp_user
  OWNER TO postgres;

  CREATE TABLE competition
(
  id integer NOT NULL,
  name character varying(60),
  comp_start_date date,
  update_datetime date,
  is_active integer NOT NULL DEFAULT 1,
  created_by_userid integer,
  acct_start_amnt double precision NOT NULL DEFAULT 1000.00,
  end_date date,
  CONSTRAINT competition_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE competition
  OWNER TO postgres;
  
  CREATE TABLE dl_user
(
  id integer NOT NULL,
  username character varying(30) NOT NULL,
  firstname character varying(30) NOT NULL,
  lastname character varying(30) NOT NULL,
  email_address character varying NOT NULL,
  password character varying(50) NOT NULL,
  role_id integer,
  CONSTRAINT dl_user_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE dl_user
  OWNER TO postgres;

  CREATE TABLE participant_betevent
(
  beteventid integer NOT NULL,
  participantid integer NOT NULL,
  CONSTRAINT participant_betevent_pkey PRIMARY KEY (beteventid , participantid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE participant_betevent
  OWNER TO postgres;

  CREATE TABLE role
(
  id integer NOT NULL,
  role character varying(20) NOT NULL,
  CONSTRAINT role_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE role
  OWNER TO postgres;

  CREATE TABLE stock_order
(
  id integer NOT NULL,
  userid integer NOT NULL,
  stockcode character varying(15) NOT NULL,
  quantity integer NOT NULL DEFAULT 0,
  atmarket boolean NOT NULL DEFAULT true,
  orderprice double precision,
  order_datetime date NOT NULL,
  update_datetime date,
  processed_datetime date,
  completed integer NOT NULL DEFAULT 0,
  buy_order integer NOT NULL DEFAULT 1,
  CONSTRAINT stock_order_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE stock_order
  OWNER TO postgres;

CREATE TABLE user_betting_account
(
  id integer NOT NULL,
  userid integer NOT NULL,
  amount double precision NOT NULL DEFAULT 0.00,
  updatedatetime date NOT NULL,
  comp_id integer NOT NULL,
  CONSTRAINT user_betting_account_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_betting_account
  OWNER TO postgres;

  CREATE TABLE user_group
(
  id integer NOT NULL,
  competitionid integer NOT NULL,
  groupname character varying(60),
  CONSTRAINT user_group_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_group
  OWNER TO postgres;
  
  CREATE TABLE user_stock
(
  id integer NOT NULL,
  userid integer NOT NULL,
  stockcode character varying(15) NOT NULL,
  costbasis double precision NOT NULL DEFAULT 0.00,
  quantity_held integer NOT NULL DEFAULT 0,
  date_acquired date,
  compid integer NOT NULL,
  is_active integer NOT NULL DEFAULT 1,
  CONSTRAINT user_stock_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_stock
  OWNER TO postgres;

  CREATE TABLE usergroup_user
(
  groupid integer NOT NULL,
  userid integer NOT NULL,
  CONSTRAINT usergroup_user_pkey PRIMARY KEY (groupid , userid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usergroup_user
  OWNER TO postgres;

CREATE TABLE season
(
  id integer NOT NULL,
  beteventtypeid integer,
  seasonname character varying(80) NOT NULL,
  updatedatetime date NOT NULL,
  CONSTRAINT season_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE season
  OWNER TO postgres;

  CREATE TABLE round
(
  id integer NOT NULL,
  seasonid integer NOT NULL DEFAULT (-1),
  round_sequence_no integer NOT NULL DEFAULT (-1),
  roundname character varying(80),
  CONSTRAINT round_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE round
  OWNER TO postgres;
  
  CREATE TABLE comp_rules
(
  id integer NOT NULL,
  pay_on_tip boolean NOT NULL DEFAULT true,
  tip_win_amnt integer NOT NULL DEFAULT 100,
  can_tip boolean NOT NULL DEFAULT true,
  can_bet boolean NOT NULL DEFAULT true,
  comp_id integer NOT NULL DEFAULT (-1),
  CONSTRAINT comp_rules_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE comp_rules
  OWNER TO postgres;
