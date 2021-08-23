def write_coordinates(filename, l):
    file = open(filename, "w")
    count = 0
    for x,y in l:
        if count < len(l) - 1:
            file.write(str(x) + "," + str(y) + "\n")
        else:
            file.write(str(x) + "," + str(y))
        count += 1
    file.close

def read_coordinates(filename):
    file = open(filename, "r")
    coord = []
    for line in file:
        line = line.strip("\n")
        listed = line.split(",")
        x = float(listed[0])
        y = float(listed[1])
        coord.append((x,y))
    file.close
    return coord