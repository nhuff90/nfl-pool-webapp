import nflgame

games = nflgame.games(2018, week=2)
#players = nflgame.combine_game_stats(games)

for g in games:
    print g