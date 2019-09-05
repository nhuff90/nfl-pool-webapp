import nflgame
import nflgame.live as live
import nflgame.game as game
import sys


def printGames(week, gameResults):
    for resultgame in gameResults:
        awayScore = ''
        homeScore = ''
        gameWithScore = nflgame.one(year=2018, week=week, home=str(resultgame['home']), away=str(resultgame['away']))
        if gameWithScore is not None:
            awayScore = str(gameWithScore.score_away)
            homeScore = str(gameWithScore.score_home)
        print '{\"eid\": \"' + str(resultgame['eid']) + '\", \"week\": \"' + str(resultgame['week']) + '\", \"homeTeam\": \"' + str(resultgame['home']) + '\", \"homeScore\": \"' + homeScore + \
              '\", \"awayTeam\": \"' + str(resultgame['away']) + '\", \"awayScore\": \"' + awayScore + '\"}'
    exit()

num = int(sys.argv[1])

if sys.argv.__len__() is 2:
    results = live._games_in_week(2019, week=num)
    printGames(num, results)

active = bool(int(sys.argv[2]))
completed = bool(int(sys.argv[3]))

# Active games
if active is True and completed is False:
    results = live.current_games()
    printGames(num, results)

results = []
games = live._games_in_week(2018, week=num)

for g in games:

    #Not started games
    if active is False and completed is False:
        currentGames = live.current_games()
        if g is not currentGames and game.Game(g['eid']).game_over() == False:
            results.append(g)

    # Finished Games
    if active is False and completed is True:
        if game.Game(g['eid']) is not None:
            if game.Game(g['eid']).game_over() == bool(completed):
                results.append(g)

printGames(num, results)
