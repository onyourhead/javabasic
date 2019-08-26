package edu.ncut.zzq.util;


import java.util.Map;

/**
 * @ClassName: Json2KeyValueRow
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/16 15:36
 * @Version: 1.0
 */
public class Json2KeyValueRow {
    public static void main(String[] args) {
        String temp = ReadTxt.readAll("temp.txt");
        parse(temp);
    }
    public static void parse(String s) {
//        Map<String, String> map = JsonUtils.toObject(s, Map.class);
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
    }
}
