class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int lengthOfNums = nums.size();
        std::vector<int> ans(2 * lengthOfNums);
        int j = 0;

        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < lengthOfNums; k++) {
                ans[j] = nums[k];
                j++;
            }
        }

        return ans;
    }
};