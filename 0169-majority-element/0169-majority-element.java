class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int check = 0;
        
        for (int num : nums) {
            if (count == 0) {
                check = num;
            }
            
            if (num == check) {
                count++;
            } else {
                count--;
            }
        }
        
        return check;
    }
}