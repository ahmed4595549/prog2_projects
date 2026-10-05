package PROBLEM3;

public class Exercise {
        public int[] twoSum(int[] nums, int target) {
            int[] arr;
            for (int i = 0; i < nums.length; i++) {
                int x = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (x == nums[j]) {
                        arr=new int[2];
                        arr[0]=i;
                        arr[1]=j;
                        return arr;
                    }
                }
            }

            return new int[]{};
        }

}
