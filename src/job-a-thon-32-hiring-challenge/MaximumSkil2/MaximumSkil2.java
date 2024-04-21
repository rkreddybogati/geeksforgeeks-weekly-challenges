import java.io.*;
import java.util.*;

/**
 * Geek currently has skills and d days left for placements. He has a array
 * problems of n problems where ith problem is represented as
 * problems[i]={rating;, gain;}. Geek could solve the ith problem only if his
 * currenty skill is not smaller than the rating;. And solving ith problem will
 * increase geek's skill by the gain;.
 * Geek wants his skill to get maximised because the placement season is
 * near. Find the maximum rating Geek could reach if he could solve only
 * one problem in a day, if there are problems that he could solve.
 * 
 * Example 1:
 * Input:
 * s = 25
 * n = 3
 * d = 3
 * problems = {{35, 45}, {13, 6}, {100, 4}}
 * Output:
 * 31
 * Explanation:
 * Geek can solve the 2nd problem on the 1st day making his skill 31, 
 * he couldn't solve any problem on the 2nd day and on the 3rd days
 * 
 */
class MaximumSkil2 {

    public static void main(String[] args) {
        int s = 25;
        int n = 3;
        int d = 3;
        int[][] problems = {{35, 45}, {13, 6}, {100, 4}};
        System.out.println(maximumSkill2(s, n, d, problems));
    }

    public static int maximumSkill2(int s, int n, int d, int[][] problems) {
        // code here
        int maxRating = s;
        for (int i = 0; i < n; i++) {
            if (problems[i][0] <= maxRating && d > 0) {
                maxRating = Math.max(maxRating, problems[i][0] + problems[i][1]);
                d--;
            }
        }
        return maxRating;

        
    }
}
   