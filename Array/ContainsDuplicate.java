import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // T: O(N*N)
    // S: O(1)
    static boolean bruteforce(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j])
                    return true;
            }
        }
        return false;
    }

    // T: O(NlogN + N)
    // S: O(1)
    static boolean sorting(int arr[]) {
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1])
                return true;
        }
        return false;
    }

    // T: O(N or NlogN or N^2) [dep on hash collisions]
    // S: O(N)
    static boolean hashset(int arr[]) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(st.contains(arr[i]))
                return true;
            st.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 3, 1, 5};
        System.out.println(bruteforce(arr));
        System.out.println(sorting(arr));
        System.out.println(hashset(arr));
    }
}