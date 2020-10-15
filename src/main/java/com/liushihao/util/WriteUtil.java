package com.liushihao.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class WriteUtil {

    /**
     * 将需要生成的文件的路径+文件名, 需要写入的内容以及是否向文件追加内容作为参数传入
     *
     * @param path  指定生成文件的路径
     * @param context   指定写入文件的内容
     * @param append 是否为追加内容, false: 不追加, 会覆盖掉同名文件|true: 追加, 会在同名文件内容后追加需要写入的内容
     * @param charset 设置需要指定写文件的字符编码格式
     * @return  返回写文件的结果 "成功"|"失败"
     */
    public static String write(String path, String context, Boolean append, Charset charset) {
        String result;   // 返回的flag
        String directory = path.substring(0, path.lastIndexOf("/"));
        log.info("WriteUtil中需要生成的文件路径directory ---> {}", directory);
        log.info("文件路径path ---> {}", path);
        File file1 = new File(directory);
        if (!file1.exists()) {   // 如果文件路径不存在则创建
            file1.mkdirs();
        }
        File file = new File(path); // 创建路径和文件
        if (!file.exists()) {   // 如果文件路径不存在则创建
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("创建文件失败...");
            }
        }
        try (BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, append), charset))) {  // 此处的true表示可以向文件中追加内容
            fileWriter.write(context);
            log.info("写入成功!!!" + (append ? "追加" : "非追加"));
            fileWriter.close();
            result = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            result = "失败";
        }
        return result;
    }

    /**
     * 可以在writer中使用该方法:
     * 如果在processor中返回了一个List集合, 那么在writer中将会给List集合再封装一层List
     * 也就是说在writer中的参数是List<? extends List<String>>
     *     那么这个时候在写文件的时候如果单纯的进行遍历写文件将会导致:
     *     a. 追加(true):     如果原来路径上已经存在了同名的文件, 那么就会在原来文件内容的基础上进行追加, 相当于是不会生成一个新的文件
     *     b. 不追加(false):   如果writer的List中存在多条数据, 那么最终写入文件中的只有一条数据即最后一条
     * 正确的解决方法应该是:
     *      在写List中的第一条数据的时候为不追加(即生成一个新的文件), 而在写第二条即之后的数据时应该为追加
     *
     * @param items 需要遍历的List集合
     * @param filePath 需要写入的文件的路径 + 文件名
     * @param charset 设置需要指定写文件的字符编码格式
     * @return 成功或失败标识
     */
    public static String writeList(List<? extends List<String>> items, String filePath, Charset charset){
        String result = null;
        if (items.get(0).size() != 0) {
            for (List<String> strings : items) {
                result = write(filePath, strings.get(0), false, charset);
                for (int i = 1; i < strings.size(); i++) {
                    result = write(filePath, strings.get(i), true, charset);
                }
            }
        } else {
            result = write(filePath, "", false, charset);
            log.info("没有符合条件的数据...");
        }
        return result;
    }
}
