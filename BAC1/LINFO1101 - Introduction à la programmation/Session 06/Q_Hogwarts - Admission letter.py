def write(letter_template, name):
    with open(letter_template, "r") as form_read:
        case = form_read.readlines()
    for index, string in enumerate(case):
        new_string = string.replace("#", name)
        case[index] = new_string
    with open(letter_template, "w") as form_write:
        form_write.writelines(case)