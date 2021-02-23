package org.example.resolve;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //resolve requirement 1
    public String solution1(int[] digits){
        List<String> combinations = letterCombinations(digits);
        StringBuilder ret = new StringBuilder();
        combinations.forEach(s -> {
            ret.append(s).append(" ");
        });
        if(ret.length() > 0){
            ret.deleteCharAt(ret.length()-1);
        }
        return ret.toString();
    }

    // resolve requirement 2
    public String solution2(int[] digits){
        List<Integer> list = new ArrayList<>();
        for (int t : digits) {
            if (t > 9) {
                int a = t / 10;
                int b = t % 10;
                list.add(a);
                list.add(b);
            } else {
                list.add(t);
            }
        }
        int[] tmp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        return solution1(tmp);
    }


    private List<String> letterCombinations(int[] digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length == 0) {
            return combinations;
        }
        String[] phoneMap = new String[]{"","","abc","def","ghi"
                ,"jkl","mno","pqrs","tuv","wxyz"};

        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations, String[] phoneMap, int[] digits, int index, StringBuffer combination) {
        if (index == digits.length) {
            //reach to the last level and get a result
            combinations.add(combination.toString());
        } else {
            int digit = digits[index];
            String letters = phoneMap[digit];
            int lettersCount = letters.length();
            //handle all the next level data
            for (int i = 0; i < lettersCount; i++) {
                //combine the letter of current level
                combination.append(letters.charAt(i));
                //deep to next level
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                //back to previous level
                combination.deleteCharAt(index);
            }
        }
    }

}
