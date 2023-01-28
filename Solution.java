class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Given that our list may contain duplicates, we will use a HashSet to remove dups.
        HashSet<List<Integer>> res = new HashSet<>();
        backtrack(res, nums, new boolean[nums.length], new LinkedList<Integer>());
        return(new ArrayList<>(res));
    }
    public void backtrack(HashSet<List<Integer>> res, int[] nums, boolean[] seen, LinkedList<Integer> curr){
        //Exit Condition
        if(curr.size() == nums.length){
            //Add it to the res.
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        else
        {
            for(int i = 0; i < nums.length; i++){
                if(!seen[i]){
                    seen[i] = true;
                    curr.add(nums[i]);
                    backtrack(res, nums, seen, curr);
                    seen[i] = false;
                    curr.removeLast();
                }
            }
        }
    }
}
