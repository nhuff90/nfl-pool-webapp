create table nfl_web_app.pick
(
  id     int          not null
    primary key,
  line   double       not null,
  risked double       not null,
  team   varchar(255) null,
  to_win double       not null,
  week   int          not null
)
  engine = MyISAM;
