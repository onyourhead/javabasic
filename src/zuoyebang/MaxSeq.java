package zuoyebang;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: MaxSeq
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/14 19:38
 * @Version: 1.0
 */
public class MaxSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int [strings.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings [i].trim();
            if (i == 0) {
                nums[i]= Integer.parseInt(strings [i].substring(1));
            } else if (i == nums.length - 1){
                nums [i] = Integer.parseInt(strings [i].substring(0, strings[i].length() - 1));
            } else {
                nums [i] = Integer.parseInt(strings [i]);
            }
        }

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            int key = nums [i];
            map.put(key, 1);
            if (map.containsKey(key - 1)) {
                int firstValue = map.get(key -map.get(key-1));
                map.put(key, firstValue  + 1);
                map.put(key -map.get(key-1), firstValue + 1);
                res = res > map.get(key) ? res : map.get(key);
            }
            if (map.containsKey(key + 1)) {
                int lastValue = map.get(key + map.get(key + 1));
                int curValue = map.get(key);
                int last = key + map.get(key + 1);
                map.put(key + map.get(key + 1), lastValue + curValue);
                map.put(key - lastValue + 1, lastValue  + curValue);
                res = res > map.get(last) ? res : map.get(last);
            }
        }
        System.out.println(res);
    }
}
