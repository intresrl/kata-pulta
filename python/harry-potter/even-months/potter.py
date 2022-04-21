discounts = {0: 0, 1: 0, 2: 0.05, 3: 0.1, 4: 0.2, 5: 0.25}

def buy(items):
    total = 0

    while len(items) > 0:
        unique_items = set(items)

        quantity = len(unique_items)
        base_price = 8*quantity
        discount = discounts[quantity]
        total += base_price * (1 - discount)

        for u in unique_items:
            items.remove(u)

    return total
