package array;

/**
 * @author: 9Chestnut
 * @Date: 2022年09月16日 10:52
 * @Description:
 *
 * 问题 ：寻找数组的中心索引
 *
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * 示例一
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 *
 * 示例二
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *
 * 解法
 * 中心元素要保证两边元素之和相等。
 * 不妨先求总和Sum。
 * 之后新建一个变量leftSum用以存储随遍历不断增大的左侧总和。
 * 进行数组遍历 leftSum==(sum-leftSum-nums[i]) 满足该条件直接返回i。
 * 具有普适性 不需要考虑边界。
 *
 */
public class Problem1 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for(int i : nums){
            sum += i;
        }
        for(int i = 0; i < nums.length; i++){
            if(leftSum == (sum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
