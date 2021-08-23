def get_max(filename):
    biggest = -1
    try:
        with open(filename) as file:
            data = file.readlines()
        for line in data:
            line = line.rstrip()
            try:
                line = float(line)
                if line >= biggest:
                    biggest = line
            except ValueError:
                pass
        return biggest
    except OSError:
        print ("OSError")
        return -1