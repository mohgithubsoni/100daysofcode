import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        comb(candidates, target, 0, 0, ans, res);

        return res;
    }

    public static void comb(int[] candidates, int target, int idx, int total,List<Integer> ans, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (idx >= candidates.length || total > target) {
            return;
        }

        ans.add(candidates[idx]);
        comb(candidates, target, idx + 1, total + candidates[idx], ans, res);
        ans.remove(ans.size() - 1);

        int next = idx + 1;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }

        comb(candidates, target, next, total, ans, res);
    }
}