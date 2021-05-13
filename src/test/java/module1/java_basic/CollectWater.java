package module1.java_basic;

public class CollectWater {
    public static void main(String[] args){
        int[] arr = {5, 3, 7, 2, 6, 4, 5, 9, 1, 2};
        int left = 0;
        int right = arr.length - 1;
        int l_max = 0;
        int r_max = 0;
        int water = 0;
        while (left <= right) {
            if (l_max <= r_max) {
                water += Math.max(0, l_max - arr[left]);
                l_max = Math.max(l_max, arr[left]);
                left++;
            } else {
                water += Math.max(0, r_max - arr[right]);
                r_max = Math.max(r_max, arr[right]);
                right--;
            }
        }
        System.out.println(water);
    }
}
