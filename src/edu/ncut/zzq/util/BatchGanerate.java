package edu.ncut.zzq.util;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BatchGanerate
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/26 14:28
 * @Version: 1.0
 */
public class BatchGanerate {
    @Test
    public void main() {
        List<Text> list = new ArrayList<>();
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null && !line.trim().isEmpty()) {
                list.add(new Text(line.split("\t")));
                line = br.readLine(); // 一次读入一行数据
            }
            br.close();
            reader.close();

            /* 写入Txt文件 */
            File writename = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (Text text : list) {
                out.write(text.toString());
                out.write("\r\n"); // \r\n即为换行
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    class Text {
        private String newOperationName;
        private String newOperationId;
        private String newOperationDesc;

        public Text(String[] strings) {
            this.newOperationName = strings[0];
            this.newOperationId = strings[1];
            this.newOperationDesc = strings[2];
        }

        public Text(String newOperationName, String newOperationId, String newOperationDesc) {
            this.newOperationName = newOperationName;
            this.newOperationId = newOperationId;
            this.newOperationDesc = newOperationDesc;
        }

//        输出样例：
//        ARTICLE_ONLINE(100101, "文章上线", ActionTypeEnum.ADMIN.code);
        @Override
        public String toString() {
            return newOperationName + "(" + newOperationId + ", \"" + newOperationDesc + "\", ActionTypeEnum.ADMIN.code),";
        }
    }
}
