public class Leet567 {
    // O(N)
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        // corner case
        //counter用来表示目前需要的在window之类的字符的总数
        // count用来统计目前所需要的各字符的个数
        // 两个index i 和 j, j 代表加入字符串，i 代表移除字符串，所以j对应减少，i对应增加
        if (len1 > len2) return false;
        int[] count = new int[26];
        // initialize the count for each unique character
        for (char c : s1.toCharArray()) {
            count[c - 'a'] ++;
        }
        // initialize the sliding window with static size len1
        int i = 0, j = 0, counter = len1;
        while (j < len1) {
            if (count[s2.charAt(j++) - 'a']-- > 0) {
                counter--;
            }
        }
        while (j < len2 && counter != 0) {
            if (count[s2.charAt(i++) - 'a']++ >= 0) counter ++;
            if (count[s2.charAt(j++) - 'a']-- > 0) counter --;
        }
        return counter == 0;
    }
}
