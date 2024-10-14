import java.util.*;

import javax.swing.tree.TreeNode;

public class Helper {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            pq.offer(num);
        }
        long score = 0;
        while(k>0){
            int max = pq.poll();
            score+=max;
            int newElement = (max+2)/3;
            pq.offer(newElement);
            k--;
        }
        return score;

    }
    
    public static void main(String[] args) {
        
        int nums[] = {672579538,806947365,854095676,815137524};
        System.out.println(maxKelements(nums, 3));
        // System.out.println((854095676+2)/3);
    }
}

