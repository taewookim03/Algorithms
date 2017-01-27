package CTCI.p8;


import java.util.HashMap;
import java.util.Map;

class p8_14_boolean_eval {
    static int numEval(String expr, boolean bool){
        return numEval(expr, bool, new HashMap<>());
    }

    static int numEval(String expr, boolean bool, Map<String, Integer> memo){
        //base case - 0 or 1
        if (expr.length() == 0) return 0;
        if (expr.length() == 1){
            if (strToBool(expr) == bool) return 1;
            return 0;
        }

        //check if previously computed
        if (memo.containsKey(expr + bool)) return memo.get(expr + bool);

        //iterate over possible division points and count number of paren config that works
        int totalWays = 0;
        for (int i = 1; i < expr.length(); i += 2){
            String left = expr.substring(0, i);
            String right = expr.substring(i+1);

            int leftTrue = numEval(left, true);
            int leftFalse = numEval(left, false);
            int rightTrue = numEval(right, true);
            int rightFalse = numEval(right, false);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            char operator = expr.charAt(i);
            int trueResult = 0;
            if (operator == '&'){
                trueResult = leftTrue * rightTrue;
            }
            else if (operator == '|'){
                trueResult = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
            }
            else if (operator == '^'){
                trueResult = leftTrue * rightFalse + leftFalse * rightTrue;
            }
            totalWays += bool ? trueResult : total - trueResult;
        }
        memo.put(expr + bool, totalWays);
        return totalWays;
    }
    static boolean strToBool(String s){
        return s.equals("1");
    }

    public static void main(String[] args){
        System.out.println(numEval("0&0&0&1^1|0", true));
    }
}
