def line_count(filename):
    with open (filename) as file:
        lines = file.readlines()
    return len(lines)

def char_count(filename):
    with open(filename) as file:
        n = file.readlines()
    return (len("".join(n)))

def space(filename, n):
    file = open(filename, "w")
    h = 0
    while n != h:
        lines = [" "]
        file.writelines(lines)
        h += 1
    file.close()
    
def capitalize(filename_in, filename_out):
    file_in = open(filename_in, "r")
    file_out = open(filename_out, "w")
    for line in file_in:
        file_out.write(line.upper())
    file_in.close()
    file_out.close()