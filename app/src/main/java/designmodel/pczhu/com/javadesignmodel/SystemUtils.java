package designmodel.pczhu.com.javadesignmodel;

import android.content.Context;

import java.io.Closeable;
import java.io.IOException;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/2/17 下午5:13
 * 版本：V1.0
 * 修改历史：
 */
public class SystemUtils {
    public static String getDataCache(){
        return MainActivity.instance.getCacheDir() + "";
     }
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
    public static String getFileName(String filename){
        String fileTemp = getFileNameNoEx(filename);
        return fileTemp.substring(fileTemp.lastIndexOf("/")+1);
    }
    public static void closeIOstream(Closeable closeable){
        try {
            if(closeable!=null)
                closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
