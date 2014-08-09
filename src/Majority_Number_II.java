import java.util.*;

/**
 * Created by Administrator on 2014/8/9 0009.
 */
public class Majority_Number_II {
    /**
     * @param nums: A list of integers
     * @return: Find a  majority number that is the number that occurs more than 1/3 of the size of the array
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (null == nums || nums.size() == 0) {
            return 0;
        }

        if (nums.size() < 3) {
            return nums.get(0);
        }

        final int k = 3;

        LinkedList<HashSet<Integer>> pendings = new LinkedList<HashSet<Integer>>();

        for (int i = 0; i < nums.size(); ++i) {
            Integer cur = nums.get(i);
            Iterator<HashSet<Integer>> it = pendings.iterator();
            boolean processed = false;
            while (it.hasNext()) {
                HashSet<Integer> curPending = it.next();
                if (curPending.contains(cur)) {
                    continue;
                } else {
                    if (curPending.size() == k - 1) {
                        it.remove();
                    } else {
                        curPending.add(cur);
                    }
                    processed = true;
                    break;
                }
            }

            if (!processed) {
                HashSet<Integer> newPending = new HashSet<Integer>();
                newPending.add(cur);
                pendings.add(newPending);
            }
        }

        return pendings.get(0).iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(new Majority_Number_II().majorityNumber(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2, 2, 3,3,4,2))));
    }
}
