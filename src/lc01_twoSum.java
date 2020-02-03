import java.util.HashMap;
import java.util.Map;

public class lc01_twoSum {

    /**
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)的时间。因此时间复杂度为 O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i){
            int targetNums = target - nums[i];
            for (int j = i + 1; j < nums.length; ++j){
                if (nums[j] == targetNums)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表
     * 时间复杂度：O(n)，
     * 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i] ;
            if (map.containsKey(complement) && i != map.get(complement))
                return new int[] {i, map.get(complement)};
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public  static void main(String[] args) {
        lc01_twoSum s = new lc01_twoSum();
        int[] nums = {3,2,4};
        int[] output;
        output = s.twoSum3(nums, 6);
        //System.out.print(1);

        for (int i: output) {
            System.out.print(i);
        }
    }

}
