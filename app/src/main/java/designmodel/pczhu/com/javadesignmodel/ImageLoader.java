package designmodel.pczhu.com.javadesignmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/2/16 下午5:32
 * 版本：V1.0
 * 修改历史：
 */
public class ImageLoader {
    private Bitmap defaultBitmap;
    public ImageLoader(int drawableid,Context mContext){
        //做OOM处理
        defaultBitmap = BitmapFactory.decodeResource(mContext.getResources(),drawableid);
    }
    ImageCache imageCache = new ImageCache();
    ExecutorService mExecutorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
    public void displayImage(final String url,final ImageView imageView){
        Bitmap bitmap = imageCache.getBitmap(url);
        imageView.setTag(url);
        if(bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }else{
            mExecutorService.submit(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = downLoadImage(url);
                    if(bitmap == null){
                        imageView.setImageBitmap(defaultBitmap);
                        return;
                    }else if(imageView.getTag().equals(url)){
                        imageView.setImageBitmap(bitmap);
                    }
                    imageCache.putBitmap(url,bitmap);
                }
            });
        }

    }

    private Bitmap downLoadImage(String key) {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            inputStream = new URL(key).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                try {
                    if(inputStream!=null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return bitmap;
    }
}
