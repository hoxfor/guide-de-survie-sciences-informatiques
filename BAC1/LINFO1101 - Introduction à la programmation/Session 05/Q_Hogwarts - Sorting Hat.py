def house_designation(student_qualities):
    student_houses = []
    sorted_houses = []
    for house, house_qualities in knowledge:
        score = 0
        for quality in student_qualities:
            if quality in house_qualities:
                score += 1
        if student_houses:
            for element in student_houses:
                index = 0
                try:
                    while score <= student_houses[index][1]:
                        index += 1
                except IndexError:
                    index = len(student_houses) + 1
            student_houses.insert(index, [house, score])
        else:
            student_houses.append([house, score])
    for house, score in student_houses:
        sorted_houses.append(house)
    return sorted_houses