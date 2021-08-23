def solveur(input_list):
    sol_list = []
    for eq in input_list:
        if not eq:
            sol_list.append(eq)
        else:
            sol_list.append(solution(eq[0],eq[1],eq[2]))
    return sol_list