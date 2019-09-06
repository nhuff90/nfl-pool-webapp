import nflgame.live as nflgame
import nflgame.game as game
import sys

print(sys.argv[1])
num = sys.argv[1]
print(type(int(num)))

games = nflgame._games_in_week(2018, week=int(num))
#players = nflgame.combine_game_stats(games)

for g in games:
    #print game.Game(g['eid']).game_over()
    print g