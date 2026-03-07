import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // 1. Count frequencies (Equivalent to unordered_map)
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 2. Convert map to list to sort (Equivalent to vector<pair>)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        
        // Sort descending based on value (frequency)
        list.sort((a, b) -> b.getValue() - a.getValue());

        // 3. Build the answer string using StringBuilder
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            int count = entry.getValue();
            
            // Append the character 'count' times
            // (If using Java 11+, you can use: ans.append(String.valueOf(c).repeat(count));)
            for (int i = 0; i < count; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}