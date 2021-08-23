def winning_house(scroll):
    biggest_score = 0
    winner = []
    houses_score = {}
    data = []
    for house in students.keys():
        houses_score[house] = 0
    with open(scroll) as file:
        for line in file.readlines():
            data.append(line.strip().split())
    for score in data:
        for house in students.keys():
            for student in students[house]:
                if score[0] == student:
                    houses_score[house] += int(score[1])
    results = list(houses_score.items())
    results = sorted(results, key = lambda x: x[1], reverse = True)
    for item in results:
        if item[1] > biggest_score:
            winner = [item[0]]
            biggest_score = item[1]
        elif item[1] == biggest_score:
            winner.append(item[0])
    if len(winner) > 1:
        return winner
    else:
        return winner[0]