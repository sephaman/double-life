CREATE TABLE acct_user
(
  "acctId" integer NOT NULL,
  "userId" integer NOT NULL,
  CONSTRAINT acct_user_pkey PRIMARY KEY ("acctId" , "userId" )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bank_account
(
  id integer NOT NULL,
  comp_id integer NOT NULL,
  bank_acct_type integer NOT NULL,
  amount double precision NOT NULL DEFAULT 0.00,
  acct_start_date date,
  "update_dateTime" date,
  is_active boolean,
  created_by_userid integer,
  CONSTRAINT bank_account_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE banking_transaction
(
  id integer NOT NULL,
  trans_amnt double precision NOT NULL DEFAULT 0.00,
  rec_acct_no integer NOT NULL,
  trans_date date NOT NULL,
  description character varying(80),
  counter_party character varying(80),
  "post_Trans_Bal" double precision,
  is_credit boolean NOT NULL,
  counter_acct_no integer NOT NULL,
  CONSTRAINT banking_transaction_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet
(
  id integer NOT NULL,
  "userId" integer NOT NULL,
  odds double precision NOT NULL,
  "dateReceived" date NOT NULL,
  stake double precision NOT NULL,
  "selectionId" integer NOT NULL,
  "betResult" integer NOT NULL,
  "moneyPaid" double precision NOT NULL,
  bet_event_id integer NOT NULL,
  "compId" integer NOT NULL,
  CONSTRAINT bet_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet_competition
(
  id integer NOT NULL,
  name character varying(60),
  comp_start_date date NOT NULL,
  "update_dateTime" date,
  is_active integer NOT NULL,
  created_by_userid integer NOT NULL,
  acct_start_amnt double precision NOT NULL DEFAULT 1000.00,
  end_date date,
  CONSTRAINT bet_competition_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet_event
(
  id integer NOT NULL,
  "betEventTypeId" integer NOT NULL,
  "dateTime" date NOT NULL,
  "outcomePending" boolean NOT NULL DEFAULT true,
  "selectionWinnerId" integer NOT NULL DEFAULT (-1),
  bet_event_name character varying(100) NOT NULL,
  CONSTRAINT bet_event_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet_event_type
(
  id integer NOT NULL,
  name character varying(100),
  "updateDateTime" date,
  CONSTRAINT bet_event_type_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet_participant
(
  id integer NOT NULL,
  name character varying(80) NOT NULL,
  "updateDateTime" date NOT NULL,
  "primaryBetEventTypeId" integer NOT NULL,
  CONSTRAINT bet_participant_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE bet_participant_price
(
  id integer NOT NULL,
  "participantId" integer NOT NULL,
  odds double precision NOT NULL,
  update_datetime date NOT NULL,
  beteventid integer NOT NULL,
  is_current boolean NOT NULL,
  CONSTRAINT bet_participant_price_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE betcomp_user
(
  "betCompId" integer NOT NULL,
  "userId" integer NOT NULL,
  CONSTRAINT betcomp_user_pkey PRIMARY KEY ("betCompId" , "userId" )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE comp_user
(
  "compId" integer NOT NULL,
  "userId" integer NOT NULL,
  CONSTRAINT comp_user_pkey PRIMARY KEY ("compId" , "userId" )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE competition
(
  id integer NOT NULL,
  name character varying(60),
  CONSTRAINT competition_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

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

CREATE TABLE participant_betevent
(
  "betEventId" integer NOT NULL,
  "participantId" integer NOT NULL,
  CONSTRAINT participant_betevent_pkey PRIMARY KEY ("betEventId" , "participantId" )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE stock_order
(
  id integer NOT NULL,
  "userId" integer NOT NULL,
  "stockCode" character varying(15) NOT NULL,
  quantity integer NOT NULL DEFAULT 0,
  "atMarket" boolean NOT NULL DEFAULT true,
  "orderPrice" double precision,
  "order_dateTime" date NOT NULL,
  "update_DateTime" date,
  "processed_DateTime" date,
  completed integer NOT NULL DEFAULT 0,
  buy_order integer NOT NULL DEFAULT 1,
  CONSTRAINT stock_order_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE user_betting_account
(
  id integer NOT NULL,
  "userId" integer NOT NULL,
  amount double precision NOT NULL DEFAULT 0.00,
  "updateDateTime" date NOT NULL,
  comp_id integer NOT NULL,
  CONSTRAINT user_betting_account_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE user_group
(
  id integer NOT NULL,
  "competitionId" integer NOT NULL,
  "groupName" character varying(60),
  CONSTRAINT user_group_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE user_stock
(
  id integer NOT NULL,
  "userId" integer NOT NULL,
  "stockCode" character varying(15) NOT NULL,
  "costBasis" double precision NOT NULL DEFAULT 0.00,
  "quantityHeld" integer NOT NULL DEFAULT 0,
  "dateAcquired" date,
  compid integer NOT NULL,
  is_active integer NOT NULL DEFAULT 1,
  CONSTRAINT user_stock_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

CREATE TABLE usergroup_user
(
  "groupId" integer NOT NULL,
  "userId" integer NOT NULL,
  CONSTRAINT usergroup_user_pkey PRIMARY KEY ("groupId" , "userId" )
)
WITH (
  OIDS=FALSE
);

