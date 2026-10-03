public class Solution {
    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private static void dfs(int idx, List<Integer> path, int cur, int[] candidates, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (cur + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            dfs(i + 1, path, cur + candidates[i], candidates, target);
            path.remove(path.size() - 1);
        }
    }
}