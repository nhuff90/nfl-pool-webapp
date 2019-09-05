import nflgame.live as nflgame
import nflgame.game as game
import sys

print(sys.argv[1])
num = sys.argv[1]
print(type(int(num)))

games = nflgame.current_games(2018, week=int(num))

for g in games:
    print g
	
	
