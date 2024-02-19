//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 6696, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class Lc15_ThreeSum{
    public static void main(String[] args) {
        Solution solution = new Lc15_ThreeSum().new Solution();
        // TO TEST
        int[] nums = {-1,0,1,2,-1,-4};
        solution.threeSum(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> sum = new ArrayList<List<Integer>>(){};

            // 1. 特判，数组为空或者长度不满3
            if (nums == null || nums.length < 3) {
                return sum;
            }

            // 2. 排序
            Arrays.sort(nums);

            // 3. 遍历排序后的数组
            for (int index = 1; index < nums.length; index++) {
                int start = 0, end = nums.length - 1;
                // 去重，index的数与index-1的数相同，[0, index-1]区间已经遍历过了
                if (index > 1 && nums[index] == nums[index - 1]) {
                    start = index - 1;
                }

                while (start < index && end > index) {
                    // 去重，遍历[0, index-1]区间时，start跳过重复的值
                    if (start > 0 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    // 去重，遍历[index+1, nums.length -1]区间时，end跳过重复的值
                    if (end < nums.length -1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    // 不重复时
                    int addNum = nums[start] + nums[index] + nums[end];
                    if (addNum == 0) {
                        sum.add(Arrays.asList(nums[start], nums[index], nums[end]));
                        start++;
                        end--;
                    } else if (addNum > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}