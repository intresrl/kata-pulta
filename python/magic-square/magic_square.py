test = [[1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]]

input = [1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0]

def permutate_list(input_list):
        if len(input_list) <= 1:
                return [input_list]
        big_list = []
        for entry in input_list:
                rest = list(filter(lambda x: x != entry, input_list))
                other_permutations = permutate_list(rest)
                for perm in other_permutations:
                        perm.append(entry)
                        big_list.append(perm)
        return big_list

def list_to_matrix(input_list):
        matrix = []
        matrix.append(input_list[0:3])
        matrix.append(input_list[3:6])
        matrix.append(input_list[6:9])
        return matrix

def compute_magic_number(linear_square):
        return sum(linear_square) / 3

def is_magic_square(square, magic):
        sums = [sum(row) for row in square]
        if not(all(element == magic for element in sums)):
                return False
        for i in range(3):
                sum_column = 0
                for row in square:
                        sum_column += row[i]
                if sum_column != magic:
                        return False
        sum_right_diag = square[0][0] + square[1][1] + square[2][2]
        sum_left_diag = square[0][2] + square[1][1] + square[2][0]
        return sum_left_diag == sum_right_diag == magic

if __name__ == "__main__":
        magic = compute_magic_number(input)
        all_perms = permutate_list(input)
        for perm in all_perms:
                if is_magic_square(list_to_matrix(perm), magic):
                        print(list_to_matrix(perm))
