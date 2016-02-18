package designmodel.pczhu.com.javadesignmodel;

import android.graphics.Bitmap;

/**
 * 名称：DoubleCache
 * 作用：
 * 描述：双缓存
 * 作者：pczhu
 * 创建时间： 16/2/17 下午2:47
 * 版本：V1.0
 * 修改历史：
 */
public class DoubleCache implements ImageCache{
    ImageCache imagecache = new MemoryImageCache();
    ImageCache sdImageCache = new DiskImageCache();
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        imagecache.putBitmap(url, bitmap);
        sdImageCache.putBitmap(url, bitmap);
    }

    @Override
    public Bitmap getBitmap(String url) {
        Bitmap bitmap = imagecache.getBitmap(url);
        if(bitmap == null)
            bitmap = sdImageCache.getBitmap(url);
        return bitmap;
    }
}
