package com.file;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class FileConvert {

    public static void fileConvert(String fromEncode, String toEncode)
            throws IOException {
        // GBK编码格式源码路径
        // String srcDirPath = "D:\\wlyxworkspace\\MyWebContent\\src";
        String srcDirPath = "C:\\Users\\jack\\Desktop\\temp\\sf";
        // 转为UTF-8编码格式源码路径
        // String utf8DirPath = "D:\\UTF8\\src";
        String utf8DirPath = "D:\\temp\\UTF8";

        // 获取所有java文件
        Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(
                srcDirPath), new String[] { "java" }, true);

        for (File javaGbkFile : javaGbkFileCol) {
            // UTF8格式文件路径
            String utf8FilePath = utf8DirPath
                    + javaGbkFile.getAbsolutePath().substring(
                    srcDirPath.length());
            // 使用GBK读取数据，然后用UTF-8写入数据
            FileUtils.writeLines(new File(utf8FilePath), toEncode,
                    FileUtils.readLines(javaGbkFile, fromEncode));
        }
    }

    public static void main(String[] args) throws IOException {
        fileConvert("GBK", "UTF-8");
    }

}
