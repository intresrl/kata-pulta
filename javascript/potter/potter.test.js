const resolve = require("./potter");
const {getAllPartitions} = require("./potter");


const sapiens = (input, expectedOutput) => {
    expect(resolve(input) + '').toEqual(expectedOutput + '')
};

describe('Harry Potter bookshop', () => {

    it('Book A costs 8 euros', () => sapiens("A", 8))

    it(`Book F returns 'ERROR'`, () => sapiens("F", 'ERROR'))

    it(`Two copies of book B cost 16 EUR`, () => sapiens("B B", 16))

    it(`Books C + D cost 16 EUR - 5%`, () => sapiens("C D", 16 * 0.95))

    it(`Books A + C + D cost 24 EUR - 10%`, () => sapiens("A C D", 24 * 0.90))

    it(`Books A + B + C + D cost 32 EUR - 20%`, () => sapiens("A B C D", 32 * 0.80))

    it(`Books A + B + C + D + E cost 40 EUR - 25%`, () => sapiens("A B C D E", 40 * 0.75))

    it(`Books A + E + C + E cost 24 EUR - 10% + 8 EUR`, () => sapiens("A E C E", 24 * 0.90 + 8))

    it(`Books AABBCCDE cost 51.20 EUR`, () => sapiens("A A B B C C D E", 51.20))

    it(`Books ABACADAEBECEDE cost 90.40 EUR`, () => sapiens("A B A C A D A E B E C E D E", 90.40))

    it(`Partition A`, () => expect(getAllPartitions(["A"])).toEqual([[1]]))

    it(`Partition AB`, () => {
        const partitions = getAllPartitions(['A', 'B']);
        expect(partitions).not.toContainEqual([1, 1]);
        expect(partitions).toContainEqual([2]);
    })

    it(`Partition AA`, () => {
        const partitions = getAllPartitions(['A', 'A']);
        expect(partitions).toContainEqual([1, 1]);
        expect(partitions).not.toContainEqual([2]);
    })


})





























































































































































