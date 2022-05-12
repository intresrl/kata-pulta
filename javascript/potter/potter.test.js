import {resolve} from "./potter";


const sapiens = (input, expectedOutput) => {
    expect(resolve(input)).toEqual(expectedOutput)
};

describe('Harry Potter bookshop', () => {

    it('one book', () => sapiens("A", 8))

})
