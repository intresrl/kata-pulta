from potter import calc_groups

def test_given_an_element_return_one_group():
    assert calc_groups(['A']) == [[['A']]]

def test_given_2_elements_return_2_groups():
    assert calc_groups(['A', 'B']) == [[['A'], ['B']],[['A', 'B']]]
