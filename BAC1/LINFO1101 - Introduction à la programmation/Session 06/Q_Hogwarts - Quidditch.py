def referee(score_file):
    scores = []
    wining_team = None
    with open(score_file) as fscore:
        parse = fscore.readlines()
    for team_name in parse[:2]:
        scores.append([team_name.strip(), 0])
    for team_scoring in parse[2:]:
        team, score = (team_scoring.strip()).split()
        score = int(score)
        for i in range(0,2):
            if score != 150:
                if team == scores[i][0]:
                    scores[i][1] += score
            else:
                if team == scores[i][0]:
                    wining_team = team
    if wining_team is None:
        first_team_score = scores[0][1]
        second_team_score = scores[1][1]
        if first_team_score > second_team_score:
            wining_team = score[0][0]
        else:
            wining_team = scores[1][0]
    return wining_team