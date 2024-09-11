create table if not exists bussgeld(
  inner_ausser   varchar(10),
  geschw_von     integer,
  geschw_bis     integer,
  punkte         integer,
  bussgeld       integer,
  fahrverbot_mon integer
);

insert into bussgeld values
  ("innerorts",   1,  10, 0,  15, 0),
  ("innerorts",  11,  15, 0,  25, 0),
  ("innerorts",  16,  20, 0,  35, 0),
  ("innerorts",  21,  25, 1,  80, 0),
  ("innerorts",  26,  30, 1, 100, 0),
  ("innerorts",  31,  40, 2, 160, 1),
  ("innerorts",  41,  50, 2, 200, 1),
  ("innerorts",  51,  60, 2, 280, 2),
  ("innerorts",  61,  70, 2, 480, 3),
  ("innerorts",  71, 999, 2, 680, 3),
  ("ausserorts",  1,  10, 0,  10, 0),
  ("ausserorts", 11,  15, 0,  20, 0),
  ("ausserorts", 16,  20, 0,  30, 0),
  ("ausserorts", 21,  25, 1,  70, 0),
  ("ausserorts", 26,  30, 1,  80, 0),
  ("ausserorts", 31,  40, 1, 120, 0),
  ("ausserorts", 41,  50, 2, 160, 1),
  ("ausserorts", 51,  60, 2, 240, 1),
  ("ausserorts", 61,  70, 2, 440, 2),
  ("ausserorts", 71, 999, 2, 600, 3);