package app;

import android.app.Application;

import com.example.admin.qqloginicondemo.BuildConfig;
import com.example.admin.qqloginicondemo.User;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

public class MyApp extends Application {
    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

    private static MyApp sApp;
    private User user;
    private UMShareAPI mUMShareAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        sApp = this;
        mUMShareAPI = UMShareAPI.get(this);
    }

    public static MyApp getInstance() {
        return sApp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UMShareAPI getUMShareAPI() {
        return mUMShareAPI;
    }

    public void setUMShareAPI(UMShareAPI UMShareAPI) {
        mUMShareAPI = UMShareAPI;
    }
}
