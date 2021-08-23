def give_money(borrowed_money, from_person, to_person, amount):
    if type(borrowed_money) != dict or type(from_person) != str or type(to_person) != str or not isinstance(amount, (int, float)) or from_person == to_person:
        raise ValueError
    try:
        borrowed_money[to_person][from_person] = borrowed_money[to_person].get(from_person, 0) + amount
    except KeyError:
        borrowed_money[to_person] = {}
        borrowed_money[to_person][from_person] = borrowed_money[to_person].get(from_person, 0) + amount
    try:
        borrowed_money[from_person][to_person] = borrowed_money[from_person].get(to_person, 0) - amount
    except KeyError:
        borrowed_money[from_person] = {}
        borrowed_money[from_person][to_person] = borrowed_money[from_person].get(to_person, 0) - amount
    return borrowed_money

def total_money_borrowed(borrowed_money):
    if type(borrowed_money) != dict:
        raise ValueError
    total = 0
    for person in borrowed_money.keys():
        for name, money in borrowed_money[person].items():
            if money > 0:
                total += money
    return total

borrowed_money = {}

give_money(borrowed_money, 'Mark', 'Bill', 2000000)
give_money(borrowed_money, 'Mark', 'Steve', 2000000)
give_money(borrowed_money, 'Serguei', 'Bill', 5000000)
give_money(borrowed_money, 'Bill', 'Larry', 6000000)
give_money(borrowed_money, 'Larry', 'Linus', 5.5)
give_money(borrowed_money, 'Steve', 'Mark', 2000000)