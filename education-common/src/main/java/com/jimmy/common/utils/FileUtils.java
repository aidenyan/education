package com.jimmy.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/19/019.
 */
public class FileUtils {

    private static final String BASE_PATH = "/api/upload/";

    public static String saveFile(String basePath, String path, InputStream inputStream, String fileType) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        File fileDir = new File(basePath + path);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File file = new File(fileDir, uuid + fileType);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(file);
            byte[] writeBy = new byte[1000 * 1024];
            int length = 0;
            while ((length = inputStream.read(writeBy)) > 0) {
                outputStream.write(writeBy, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return BASE_PATH + path + "/" + file.getName();
        } catch (Exception e) {
            throw new RuntimeException("写入图片信息失败！");
        }
    }

    public static String saveFile(String basePath, String path, String base64, String fileType) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        File fileDir = new File(basePath + path);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File file = new File(fileDir, uuid + "." + fileType);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = Base64.decodeBase64(base64.substring(base64.indexOf(",") + 1));
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            return BASE_PATH + path + "/" + file.getName();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入图片信息失败！");
        }
    }

}
