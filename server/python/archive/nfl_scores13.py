import nflgame

gameScores = nflgame.gameScores(2018, week=13)
#players = nflgame.combine_game_stats(gameScores)

for g in gameScores:
    print g