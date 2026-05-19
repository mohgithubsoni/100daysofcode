class Solution(object):
    def minDeletionSize(self, input_strings):

        num_columns = len(input_strings[0])

        # Prepare adjacent string pairs for comparison
        string_pairs = []
        for i in range(len(input_strings) - 1):
            left_str = input_strings[i]
            right_str = input_strings[i + 1]
            string_pairs.append((left_str, right_str))

        deletion_count = 0

        for col_idx in range(num_columns):
            is_column_sorted = True
            # Pairs where chars are equal in this column—candidates for next round
            equal_char_pairs = []

            for left_str, right_str in string_pairs:
                left_char = left_str[col_idx]
                right_char = right_str[col_idx]

                # If this column is decreasing, mark for deletion
                if left_char > right_char:
                    is_column_sorted = False
                    break
                    
                # If equal, we need to keep checking these strings in future columns
                elif left_char == right_char:
                    equal_char_pairs.append((left_str, right_str))

            # If all remaining pairs were strictly non-decreasing and none left equal, we're done
            if is_column_sorted and not equal_char_pairs:
                return deletion_count

            if not is_column_sorted:
                deletion_count += 1
            else:
                # Only keep the pairs that remain tied at this column
                string_pairs = equal_char_pairs

        return deletion_count
