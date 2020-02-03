import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc03_lengthOfLongestSubstring {

    /**
     * 暴力法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(min(n, m))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = (j - i) > ans ? (j - i) : ans;
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (!set.add(ch))
                return false;
        }

        return true;
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     *
     * 空间复杂度：O(min(m, n))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化的滑动窗口
     * 时间复杂度：O(n)，可以直接跳过 [i，j] 范围内的所有元素，并将 i 变为 j' + 1
     * 空间复杂度：O(min(m, n))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public  static void main(String[] args) {
        lc03_lengthOfLongestSubstring len = new lc03_lengthOfLongestSubstring();
        int i = len.lengthOfLongestSubstring("");
        System.out.println(i);
    }
}
