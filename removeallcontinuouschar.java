// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach : stack to store each character and its consecutive count, processing the string in one pass. Whenever a group reaches count > 2, remove it, and use the stack to handle any new adjacent groups formed after deletion 
import java.util.*;
public class Main {

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    static String removeContinuous(String s) {
        Stack<Pair> stack = new Stack<>();

        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);
            int j = i;

            // Find length of current continuous group
            while (j < s.length() && s.charAt(j) == ch) {
                j++;
            }

            int count = j - i;

            // If group itself has 3 or more, remove it
            if (count >= 3) {
                i = j;
                continue;
            }

            // Merge with previous group if same character
            if (!stack.isEmpty() && stack.peek().ch == ch) {

                int newCount = stack.peek().count + count;
                stack.pop();

                if (newCount < 3) {
                    stack.push(new Pair(ch, newCount));
                }
                // else remove the merged group
            } else {
                stack.push(new Pair(ch, count));
            }

            i = j;
        }

        StringBuilder ans = new StringBuilder();

        for (Pair p : stack) {
            for (int k = 0; k < p.count; k++) {
                ans.append(p.ch);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeContinuous("abba"));      
        System.out.println(removeContinuous("abbb"));      
        System.out.println(removeContinuous("abbbaa"));     
        System.out.println(removeContinuous("abbacccaa"));  
    }
}