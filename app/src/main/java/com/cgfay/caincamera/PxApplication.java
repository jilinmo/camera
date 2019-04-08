package com.cgfay.caincamera;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cgfay.caincamera.fragment.PxFragment;
import com.cgfay.caincamera.model.PxModel;
import com.cgfay.caincamera.model.PxsModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PxApplication extends Application {

    private static Context mContext;
    private static PxApplication application;
    public static PxApplication getInstance() {
        return application;
    }

    public PxsModel getPxsModel() {
        return pxsModel;
    }

    public void setPxsModel(PxsModel pxsModel) {
        this.pxsModel = pxsModel;
    }

    private PxsModel pxsModel;
    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        mContext = getApplicationContext();

        //获取配置
        setPxsModel(getPxs());
    }

    //获取配置
    public PxsModel getPxs() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + "px.json");
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                // stringBuilder.append(line);
                stringBuilder.append(line);
            }
            reader.close();
            reader.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String jsonstr = stringBuilder.toString();
        return gson.fromJson(jsonstr, PxsModel.class);
    }

    public void showFragment(AppCompatActivity activity, PxModel model) {

        FrameLayout frameLayout=new FrameLayout(activity);
        frameLayout.setId(com.cgfay.imagelibrary.R.id.fragment_container);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        if (model.getType() ==1){
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        //设置顶部,左边布局
        params.gravity= Gravity.TOP|Gravity.LEFT;
        activity.addContentView(frameLayout, params);

        PxFragment pxFragment = PxFragment.newInstance(model);
        ft.add(com.cgfay.imagelibrary.R.id.fragment_container, pxFragment);
        ft.commit();
        model.setEnable(0);
    }

}
