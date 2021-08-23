def marks_from_file(filename):
    student_list = []
    with open(filename) as file:
        results = file.readlines()
    for score in results:
        score = score.strip().split()
        student_list.append(Student(score[0], score[1], int(score[2])))
    return student_list