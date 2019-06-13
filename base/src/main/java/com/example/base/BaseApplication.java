package com.example.base;

import android.app.Application;
import android.content.Context;

/**
 * Created on 2019/6/11.
 *
 * @author xq
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        modulesApplicationInit();
    }

    public static BaseApplication getInstance(){
        return instance;
    }

    public static Context getContext() {
        return getInstance().getApplicationContext();
    }

    private void modulesApplicationInit(){
        for (String moduleImpl : ModuleConfig.MODULESLIST){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof ApplicationImpl){
                    ((ApplicationImpl) obj).onCreate(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
