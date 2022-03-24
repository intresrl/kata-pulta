from itertools import combinations_with_replacement as cwr

sizes = [50, 75, 100, 120]

def get_comibinations(length: int):
    global sizes

    my_combinations = []
    my_sizes = sizes[::-1]

    for n in range(1, len(my_sizes)):
        for i in cwr(iterable=my_sizes, r=n):
            if sum(i) == length:
                my_combinations.append(i)

    return my_combinations

def get_cheapest(my_combinations: list):
    global sizes

    prices = []

    for c in my_combinations:
        cost = 0

        for n in c :
            if n == 50: cost += 59
            elif n == 75: cost += 62
            elif n == 100: cost += 90
            else: cost += 111

        prices.append(cost)


    return min(prices), my_combinations[prices.index(min(prices))]

if __name__ == "__main__":
    combinations = get_comibinations(250)
    print(combinations)

    cheapest_wardrobe = get_cheapest(combinations)
    print(cheapest_wardrobe)