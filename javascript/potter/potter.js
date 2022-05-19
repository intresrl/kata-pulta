const BOOKS = ["A", "B", "C", "D", "E"];

/**
 To try and encourage more sales of the 5 different Harry Potter books they sell,
 a bookshop has decided to offer discounts of multiple-book purchases.

 For sake of simplicity, the books will be represented by the simple strings "A", "B", "C", "D", "E".

 Your code must calculate the price of a shopping basket in this bookshop.

 *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

 One copy of any one of the five books costs 8 EUR.

 ----------------
 To pass the first test, just focus on pricing a single book
 ----------------

 If you try to buy a book not stated in the previous list you get 'ERROR'

 ----------------
 To pass the second test, check if the book is different from [A,B,C,D,E]. If it is, return 'ERROR'
 ----------------

 If you buy two copies of a book each copy costs 8 EUR.

 ----------------
 To pass the third test, consider that you may receive multiple books as input.
 You should split the input string on whitespaces.
 ----------------

 If, however, you buy two different books, you get a 5% discount on those two books.

 ----------------
 To pass the fourth test, check if given books have the same title. If they don't, apply the discount.
 You can safely assume that you have at most two books for this test
 ----------------

 If you buy 3 different books, you get a 10% discount.

 ----------------
 Start by counting how many different books there are
 ----------------

 If you buy 4 different books, you get a 20% discount.

 If you go the whole hog, and buy all 5, you get a huge 25% discount.

 Note that if you buy, say, four books, of which 3 are different titles,
 you get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR.

 ----------------
 For the next test, start by taking the largest group of distinct books and compute its price.
 Then do the same for the remaining books and sum the prices.
 ----------------

 Your mission is to write a piece of code to calculate the price of any conceivable shopping basket
 (containing only Harry Potter books), giving as big a discount as possible.

 For example, how much does this basket of books cost?

 2 copies of the first book
 2 copies of the second book
 2 copies of the third book
 1 copy of the fourth book
 1 copy of the fifth book

 One way of group these 8 books is:
 1 group of 5 --> 25% discount (1st,2nd,3rd,4th,5th)
 +1 group of 3 --> 10% discount (1st,2nd,3rd)
 This would give a total of
 5 books at a 25% discount
 +3 books at a 10% discount
 Giving
 5 x (8 - 2.00) == 5 x 6.00 == 30.00
 +3 x (8 - 0.80) == 3 x 7.20 == 21.60
 For a total of 51.60

 However, a different way to group these 8 books is:
 1 group of 4 books --> 20% discount  (1st,2nd,3rd,4th)
 +1 group of 4 books --> 20% discount  (1st,2nd,3rd,5th)
 This would give a total of
 4 books at a 20% discount
 +4 books at a 20% discount
 Giving
 4 x (8-1.60) == 4 x 6.40 == 25.60
 +4 x (8-1.60) == 4 x 6.40 == 25.60
 For a total of 51.20

 And 51.20 is the price with the biggest discount.

 ----------------
 If you followed the tip from the previous test, you probably got 51.60 as a result :-(
 There are many ways to group the books to maximize the discount.
 If you can conceive an advanced algorithm, well, that's nice...
 but brute-forcing it should be more than enough.
 ----------------

 */

function isInvalid(book) {
    return !BOOKS.includes(book);
}

const discountsByDistinct = {
    1: 0,
    2: 0.05,
    3: 0.1,
    4: 0.2,
    5: 0.25
}

function getDiscount(books) {
    const distinctElements = countDistinct(books)
    return discountsByDistinct[distinctElements] ?? 0
}

const distinct = books => [...new Set(books)];

const countDistinct = books => distinct(books).length;

function priceDistinct(books) {
    const cartCost = 8 * books.length
    const discount = getDiscount(books)
    return cartCost * (1 - discount);
}

function recursivePartitions(_booksOccurrences) {
    const allThePartitions = []
    const booksOccurrences = Object.fromEntries(
        Object.entries(_booksOccurrences).filter(([, v]) => v > 0)
    )
    const keys = Object.keys(booksOccurrences);
    const distinctCount = keys.length
    for (let mask = 1; mask < 2 ** distinctCount; mask++) {
        const rest = {...booksOccurrences}
        const chosen = []
        for (let bitPos = 0; bitPos < distinctCount; bitPos++) {
            if ((mask >> bitPos) & 1) {
                const book = keys[bitPos];
                chosen.push(book)
                rest[book]--
            }
        }

        const restIsNotEmpty = Object.entries(rest).some(([, v]) => v > 0)
        if (restIsNotEmpty) {
            const restCombos = recursivePartitions(rest)
            restCombos.forEach(array => array.push(chosen))
            allThePartitions.push(...restCombos)
        } else {
            allThePartitions.push([chosen])
        }
    }

    return allThePartitions
}

const getAllPartitions = books => {
    const booksOccurrences = {}
    const distinctBooks = distinct(books);
    distinctBooks.forEach(x =>
        booksOccurrences[x] = books.filter(b => b === x).length
    )
    return recursivePartitions(booksOccurrences);
};

const calculatePriceForSet = set => set
    .map(priceDistinct)
    .reduce((total, price) => total + price, 0);

module.exports = function resolve(input) {
    const books = input.split(' ')

    if (books.some(isInvalid)) return 'ERROR'

    const allSets = getAllPartitions(books)
    return Math.min(...allSets.map(calculatePriceForSet))
}

module.exports.getAllPartitions = getAllPartitions
