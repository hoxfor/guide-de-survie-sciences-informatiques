def __str__(self):
    parse_list = []
    element = self.__head
    if element is not None:
        parse_list.append(element.value())
        while element.next() is not None:
            element = element.next()
            parse_list.append(element.value())
    string_list = "["
    for i in parse_list:
        string_list += " {}".format(i)
    string_list += " ]"
    return string_list