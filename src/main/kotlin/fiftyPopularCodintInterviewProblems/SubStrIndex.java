package fiftyPopularCodintInterviewProblems;

public class SubStrIndex {
    public int  subStrIndex(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (m > n)
            return -1;
        else if (m == n)
            return str1 == str2 ? 0 : -1;
        else if (m == 0)
            return -1;
        int i = 0;
        int j = 0;
        int[] lps = getLps(str2);
        while (i < n && j < m) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else if (j > 0)
                j = lps[j - 1];
            else
                i += 1;
        }
        return j == m ? i - m : -1;
    }

    public int[] getLps(String str) {
        int i = 1;
        int j = 0;
        char[] chars = str.toCharArray();
        int[] lps = new int[str.length()];
        lps[0] = 0;
        while (i < str.length()) {
            if (chars[i] == chars[j]) {
                j++;
                lps[i] = j;
                i++;
            } else if (j > 0)
                j = lps[j - 1];
            else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }


}
