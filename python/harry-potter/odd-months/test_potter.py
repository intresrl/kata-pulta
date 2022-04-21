from potter import buy

def test_given_an_empty_basket_price_0():
    assert buy([]) == 0


def test_given_a_one_item_basket():
    assert buy(["book_A"]) == 8


def test_given_a_two_item_basket():
    discount = 16 * 0.05
    assert buy(["book_A", "cicciopappo"]) == 16 - discount


def test_given_a_three_item_basket():
    discount = 24 * 0.1
    assert buy(["book_A", "cicciopappo","triFaBunaFi"]) == 24 - discount


def test_given_a_four_item_basket():
    discount = 4 * 8 * 0.2
    assert buy(["book_A", "cicciopappo","triFaBunaFi", "libroaggiuntivo"]) == 4*8 - discount


def test_given_a_five_item_basket():
    discount = 5 * 8 * 0.25
    assert buy(["book_A", "cicciopappo", "triFaBunaFi", "libroaggiuntivo", "aggiungiunlibro"]) == 5*8 - discount


def test_given_a_two_identical_books_basket():
    assert buy(["book_A", "book_A"]) == 16


def test_given_2_and_1_books_basket():
    assert buy(["book_A", "book_A", "cicciopappo"]) == 8 + ((8 * 2) * 0.95)


def test_given_3_and_1_books_basket():
    assert buy(["book_A", "book_C", "book_C", "book_C"]) == ((8 * 2) * 0.95) + (8 * 2)

#def test_given_2_2_2_1_1_books_basket():
#    assert buy(["A", "A", "B", "B", "C", "C", "D", "E"]) == 51.20



