import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2014/8/9 0009.
 */
public class Majority_Number {
    /**http://lintcode.com/accounts/login/
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (null == nums || nums.size() == 0) {
            return 0;
        }

        if (nums.size() < 3) {
            return nums.get(0);
        }

        // write your code
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nums.get(0));

        for (int i = 1; i < nums.size(); ++i) {
            Integer cur = nums.get(i);
            if (q.peek() != cur) {
                q.poll();
            } else {
                q.add(cur);
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Majority_Number().majorityNumber(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 2, 2))));
    }
}
