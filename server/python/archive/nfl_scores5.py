import nflgame

gameScores = nflgame.gameScores(2018, week=5)
#players = nflgame.combine_game_stats(gameScores)

for g in gameScores:
    print g