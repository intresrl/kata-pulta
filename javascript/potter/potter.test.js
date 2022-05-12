const resolve = require("./potter");


const sapiens = (input, expectedOutput) => {
    expect(resolve(input) + '').toEqual(expectedOutput + '')
};

describe('Harry Potter bookshop', () => {

    it('Book A costs 8 euros', () => sapiens("A", 8))

    it(`Book F returns 'ERROR'`, () => sapiens("F", 'ERROR'))

    it(`Two copies of book B cost 16 EUR`, () => sapiens("B B", 16))

    it(`Books C + D cost 16 EUR - 5%`, () => sapiens("C D", 16 * 0.95))

    it(`Books A + C + D cost 16 EUR - 10%`, () => sapiens("A C D", 24 * 0.90))

})





























































































































































