class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // Example:
        // nums = [1, 2, 3]
        // n = 3 → total subsets = 2^3 = 8
        // We will generate subsets using binary representation

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // total subsets = 2^n
        int subsets = 1 << n;   // 1<<3 = 8

        // i represents subset in binary form
        // i goes from 0 → 7
        for(int i = 0; i < subsets; i++){

            // Example flow:
            // i = 0 → 000 → []
            // i = 1 → 001 → [1]
            // i = 2 → 010 → [2]
            // i = 3 → 011 → [1,2]
            // i = 4 → 100 → [3]
            // i = 5 → 101 → [1,3]
            // i = 6 → 110 → [2,3]
            // i = 7 → 111 → [1,2,3]

            List<Integer> list = new ArrayList<>();

            // check each bit
            for(int j = 0; j < n; j++){

                // check if jth bit is set in i
                // Example:
                // i = 5 → 101
                // j = 0 → (101 & 001) = 1 → include nums[0]
                // j = 1 → (101 & 010) = 0 → skip
                // j = 2 → (101 & 100) = 4 → include nums[2]

                if((i & (1 << j)) != 0){
                    list.add(nums[j]);
                }
            }

            // add generated subset
            res.add(list);
        }

        // final result contains all subsets
        return res;
    }
}