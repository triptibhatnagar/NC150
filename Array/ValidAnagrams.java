import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {
    // T: O(NlogN + NlogN + N)
    // S: O(N + N)
    static boolean sorting(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    // T: O(N + N) where map operations take O(1) [can be N or NlogN or N^2]
    // S: O(N)
    static boolean hashmap1(String s, String t) {
        if(s.length() != t.length()) 
            return false;

        Map<Character, Integer> mp = new HashMap<>();// < character, frequency >

        // count frequencies from s
        for(int i=0; i<s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
        }

        // decrement frequencies using t
        for(int i=0; i<t.length(); i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)-1);
            if(mp.get(t.charAt(i)) < 0) // extra character in t
                return false;
        }
        return true;
    }

    // T: O(N or NlogN or N^2 + N)
    // S: O(N)
    static boolean hashmap2(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        
        Map<Character, Integer> mp = new HashMap<>();// < character, frequency >

        for(int i=0; i<s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)-1);
        }

        for(int x: mp.values()) {
            if(x != 0)
                return false;
        }
        return true;
    }

    // T: O(N + N)
    // S: O(26)
    static boolean freqArr1(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            arr[t.charAt(i)-'a']--;
            if(arr[t.charAt(i)-'a'] < 0)
                return false;
        }
        return true;
    }

    // T: O(N+26)
    // S: O(26)
    static boolean freqArr2(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++) {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
        String s = "racecar";
        String t = "carrace";
        System.out.println(sorting(s, t));
        System.out.println(hashmap1(s, t));
        System.out.println(hashmap2(s, t));
        System.out.println(freqArr1(s, t));
        System.out.println(freqArr2(s, t));
    }
    // freq arr is fastest but it works only for lowercase characters
}