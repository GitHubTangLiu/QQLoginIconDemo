package com.example.admin.qqloginicondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.MyApp;


public class MainActivity extends AppCompatActivity {


    private ImageView userPhoto;
    private TextView userName, userCity;
    private TextView tuichu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.name);
        userPhoto = (ImageView) findViewById(R.id.image);
        userCity = (TextView) findViewById(R.id.city);
        tuichu = (TextView) findViewById(R.id.exit);

        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QQLogin.login(MainActivity.this, new QQLogin.QQLoginCallBack() {
                    @Override
                    public void success(User user) {

                        Glide.with(MainActivity.this).load(user.getUserPhotoUrl()).into(userPhoto);
                        userName.setText(user.getUserName());
                        userCity.setText(user.getCity());

                    }
                });
            }
        });
        initQQ();
    }


    private void initQQ() {
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QQLogin.exitLogin(MainActivity.this, new QQLogin.QQExitCallBack() {
                    @Override
                    public void exit() {
                        userPhoto.setImageResource(R.mipmap.ic_launcher);
                        userName.setText("");
                        userCity.setText("");
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MyApp.getInstance().getUMShareAPI().onActivityResult(requestCode, resultCode, data);
    }

}
