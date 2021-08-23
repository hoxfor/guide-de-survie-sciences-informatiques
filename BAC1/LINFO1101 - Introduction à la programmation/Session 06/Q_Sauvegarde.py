def save_data(filename, life, mana, position_x, position_y):
    with open(filename, "w") as save:
        for data in life, mana, position_x, position_y:
            save.writelines(str(data)+"\n")

def load_data(filename):
    data = []
    with open(filename) as load:
        for line in load.readlines():
            data.append(int(line.strip()))
    return tuple(data)