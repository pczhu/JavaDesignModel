package designmodel.pczhu.com.javadesignmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 名称：DiskImageCache
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/2/17 下午2:58
 * 版本：V1.0
 * 修改历史：
 */
public class DiskImageCache implements ImageCache {
    private static final String cacheDir = SystemUtils.getDataCache() + "/";
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        BufferedOutputStream os = null;
        try {
            String fileName = SystemUtils.getFileName(url);

            File file = new File(cacheDir+fileName);
            file.createNewFile();
            os = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SystemUtils.closeIOstream(os);
        }
    }
    public void put() {

    }
    @Override
    public Bitmap getBitmap(String url) {
        //TODO 此处需要OOM处理
        String fileName = SystemUtils.getFileName(url);
        return BitmapFactory.decodeFile(cacheDir+fileName);
    }

}
