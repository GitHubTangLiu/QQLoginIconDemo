package com.example.admin.qqloginicondemo;

import android.app.Activity;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import app.MyApp;


//类描述：QQ登录第三方友盟回传头像   QQ退出登录

public class QQLogin {
    public interface QQLoginCallBack {
        void success(User user);
    }

    public interface QQExitCallBack {
        void exit();
    }

    public static void login(Activity activity, final QQLoginCallBack callBack) {
        if (MyApp.getInstance().getUser() != null) {
            Toast.makeText(activity, "已登录", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApp.getInstance().getUMShareAPI().getPlatformInfo(activity, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                if (i == 0) {

                } else if (i == 2) {
                    String imageUrl = map.get("iconurl");
                    String name = map.get("name");
                    String city = map.get("city");

                    User user = new User(imageUrl, name, city);
                    MyApp.getInstance().setUser(user);
                    if (callBack != null) {
                        callBack.success(user);
                    }
                }
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }

    public static void exitLogin(Activity activity, final QQExitCallBack callBack) {
        if (MyApp.getInstance().getUser() == null) {
            Toast.makeText(activity, "未登录", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApp.getInstance().getUMShareAPI().deleteOauth(activity, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                MyApp.getInstance().setUser(null);
                if (callBack != null) {
                    callBack.exit();

                }
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }
}
