import nflgame.live as nflgame

games = nflgame.current_games(2018, week=1)

for g in games:
    print g