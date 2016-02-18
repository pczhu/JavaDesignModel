package designmodel.pczhu.com.javadesignmodel;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        ImageLoader imageLoader = new ImageLoader(R.mipmap.ic_launcher,this);
        imageLoader.setImageCache(new DoubleCache());
        imageLoader.displayImage("http://imgsrc.baidu.com/forum/w%3D580/sign=30a0758fb1fd5266a72b3c1c9b199799/3d950a7b02087bf4bbba2e8df5d3572c11dfcf04.jpg",imageView);
    }

}
