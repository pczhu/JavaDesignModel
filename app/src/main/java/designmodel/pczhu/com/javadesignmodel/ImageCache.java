package designmodel.pczhu.com.javadesignmodel;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/2/16 下午5:33
 * 版本：V1.0
 * 修改历史：
 */
public class ImageCache {
    LruCache<String,Bitmap> lruCache;
    public ImageCache(){
        initCache();
    }
    private void initCache(){
        final int maxSize = (int)(Runtime.getRuntime().maxMemory()/1024L);
        final int cacheSize = maxSize/4;
        lruCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return (int)(value.getRowBytes() * value.getHeight() /1024L);
            }
        };
    }
    public void putBitmap(String url,Bitmap bitmap){
        lruCache.put(url,bitmap);
    }
    public Bitmap getBitmap(String url){
        return lruCache.get(url);
    }
}
