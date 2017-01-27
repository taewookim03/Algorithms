package CTCI.p1;

class p1_5_one_away {
    //using levenshtein edit distance - O(nm) time, O(nm) space
    static int notMatch(char c1, char c2){
        if (c1 == c2) return 0;
        else return 1;
    }

    static int distance(String s1, String s2){
        int a = s1.length();
        int b = s2.length();

        int[][] matrix = new int[a+1][b+1];

        for (int i = 0; i <= a; i++){
            matrix[i][0] = i;
        }
        for (int j = 0; j <= b; j++){
            matrix[0][j] = j;
        }

        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= b; j++){
                int insert = 1 + matrix[i][j-1];
                int remove = 1 + matrix[i-1][j];
                int replace = notMatch(s1.charAt(i-1), s2.charAt(j-1)) + matrix[i-1][j-1];

                int min = insert;
                if (remove < min) min = remove;
                if (replace < min) min = replace;

                matrix[i][j] = min;

            }
        }

        return matrix[a][b];
    }

    static boolean oneAwayLV(String s1, String s2){
        int dist = distance(s1, s2);
        return dist <= 1;
    }



    //using array - O(n) time
    static boolean oneAway(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        if (n == m){
            //check replacement
            return checkReplacement(s1, s2);
        }
        else if (n == m-1){
            //check insertion
            return checkInsertion(s1, s2);
        }
        else if (n-1 == m){
            //check insertion (with s1 s2 flipped)
            return checkInsertion(s2, s1);
        }

        return false;
    }

    static boolean checkReplacement(String s1, String s2){
        boolean replaced = false;
        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2){
                if (replaced) return false;
                replaced = true;
            }
        }
        return true;
    }

    static boolean checkInsertion(String s1, String s2){
        int i = 0;//s1 index
        int j = 0;//s2
        boolean inserted = false;
        while (i < s1.length() && j < s2.length()){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2){
                if (inserted) return false;
                inserted = true;
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(oneAwayLV("pale", "bake"));
        System.out.println(oneAway("bakes", "pale"));
    }
}
