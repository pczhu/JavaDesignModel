package designmodel.pczhu.com.javadesignmodel;

import android.graphics.Bitmap;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/2/17 下午2:43
 * 版本：V1.0
 * 修改历史：
 */
public interface ImageCache {
    public void putBitmap(String url,Bitmap bitmap);
    public Bitmap getBitmap(String url);
}
