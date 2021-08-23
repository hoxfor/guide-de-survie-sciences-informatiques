def table(filename_in, filename_out, width):
    with open(filename_in, "r") as file_in:
        file_lines = []
        for line in file_in.readlines ():
            file_lines.append(line.strip())
    with open(filename_out, "w") as file_out:
        file_out.write("+"+"-"*(width+2)+"+\n")
        for lines in file_lines:
            file_out.write("| {:{}} |\n".format(lines[:width+1], width))
        file_out.write("+"+"-"*(width+2)+"+")