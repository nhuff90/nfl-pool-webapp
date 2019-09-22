create table nfl_web_app.pick_result
(
  id         int        not null,
  week       int        not null,
  covered    tinyint(1) not null,
  net_profit double     not null,
  constraint wager_result_id_uindex
    unique (id)
);

alter table nfl_web_app.pick_result
  add primary key (id);

