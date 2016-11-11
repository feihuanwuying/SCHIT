package util;

import java.io.*;

/**
 * 文件操作
 * Created by ZouKaifa on 2016/11/11.
 */
public class FileHandler {
    /**
     * 根据文件名（带有绝对路径），保存文件
     * @param fileName
     */
    public static void saveFile(String fileName, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length = 0;
            while ((length = fis.read(b)) > 0) {
                fos.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
