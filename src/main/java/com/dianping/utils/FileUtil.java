package com.dianping.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by byebyejude on 2017/9/24.
 */
public class FileUtil {

    /**
     * 将MultipartFile保存到指定的路径下
     *
     * @param file
     *            Spring的MultipartFile对象
     * @param savePath
     *            保存路径
     * @return 保存的文件名，当返回NULL时为保存失败。
     * @throws IOException
     * @throws IllegalStateException
     */
    public static String save(MultipartFile file, String savePath) throws IllegalStateException, IOException {
        if (file != null && file.getSize() > 0) {
            File fileFolder = new File(savePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            File saveFile = getFile(savePath, file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile.getName();
        }else {
            return null;
        }

    }

    /**
     * 删除文件
     *
     * @param filePath
     *            文件路径
     * @return 是否删除成功：true-删除成功，false-删除失败
     */
    public static boolean delete(String filePath) {
        File file = new File(filePath);
        if (file.isFile()) {
            file.delete();
            return true;
        }
        return false;
    }

    private static File getFile(String savePath, String originalFilename) {
        String fileName = System.currentTimeMillis() + "_" + originalFilename;
        File file = new File(savePath + fileName);
        if (file.exists()) {
            return getFile(savePath, originalFilename);
        }
        return file;
    }

}
