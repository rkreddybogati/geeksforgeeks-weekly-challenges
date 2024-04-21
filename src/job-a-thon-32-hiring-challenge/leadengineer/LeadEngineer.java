//{ Driver Code Starts
    import java.io.*;
    import java.util.*;

    //format the class



    /**
     * There are N SDEs working in a company. The ith SDE has E[i] years of experience.
     * The CEO wants to elect one of them for the Lead Engineer role.
     * He wants to select the one having the maximum years of experience.
     * Find out how many possibilities the CEO has.
     * 
     * Example 1:
     * Input:
     * N=3
     * E[]={4,4,5}
     * Output:
     * 1
     * Explanation:
     * Since only the 3rd SDE has a maximum of years of experience,
     * thus the CEO has only one possibility.
     * 
     * Example 2:
     * Input:
     * N=3
     * E[]={4,4,4}
     * Output:
     * 3
     * Explanation:
     * Since all the SDEs have the same years of experience,
     * thus the CEO has 3 possibilities.
     * 
     * 
     */
    class LeadEngineer {

        public static void main(String[] args) throws IOException {
            int N = 3;
            int[] E = {4, 4, 4};
            System.out.println(leadOptions(N, E));
        }

        public static int leadOptions(int N, int[] E) {
            // code here
            
            int length = E.length;
            
            
            if(length==0) {
                return 0;
            }
            
            if(length==1) {
                return E[0];
            }
    
            Arrays.sort(E);
            
            int last = length-1;
            int  count = 1;
            while(0<last) {
                if(E[last]!=E[last-1]){
                    break;
                } 
                count++;
                last--;
            }
            
            return count;
        
        }
    }
    