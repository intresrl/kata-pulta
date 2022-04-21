discounts = {0: 0, 1: 0, 2: 0.05, 3: 0.1, 4: 0.2, 5: 0.25}

def calculate_price(quantity):
    base_price = 8*quantity
    discount = discounts[quantity]
    discounted_price = base_price * (1 - discount)
    return discounted_price

def subtract_lists(initial, to_subtract):
    difference = []
    for item in initial:
        if item in to_subtract:
            to_subtract.remove(item)
        else:
            difference.append(item)
    return difference;

def buy(items):
    quantity = len(items)
    if quantity == 0:
           return 0
    distinct_books = set(items)
    distinct_quantity = len(distinct_books)
    diff = subtract_lists(items, distinct_books)
    return calculate_price(distinct_quantity) + buy(diff)


def calc_groups(items):
    return [[items]]
