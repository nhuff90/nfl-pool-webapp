create table nfl_web_app.weekly_record
(
  week   int not null,
  wins   int not null,
  losses int not null,
  constraint weekly_record_week_uindex
    unique (week)
);

alter table nfl_web_app.weekly_record
  add primary key (week);

