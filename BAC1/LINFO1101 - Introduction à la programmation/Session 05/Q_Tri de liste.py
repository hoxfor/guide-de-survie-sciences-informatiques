sorted_list = []
for element in a_list:
    index = 0
    if sorted_list:
        try:
            while element > sorted_list[index]:
                index += 1
        except IndexError:
            index = len(sorted_list) + 1
        sorted_list.insert(index, element)
    else:
        sorted_list.append(element)