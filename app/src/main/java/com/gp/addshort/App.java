package com.gp.addshort;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by guoping on 2017/5/13.
 */

public class App extends Application {

    public static Context globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        // 程序终止的时候执行
        super.onTerminate();
    }

    /**
     * 老版本的相当于onTrimMemory()的TRIM_MEMORY_COMPLETE
     */
    @Override
    public void onLowMemory() {
        // 低内存的时候执行
        super.onLowMemory();
    }

    /**
     *4.0以后,api14
     *@param level TRIM_MEMORY_UI_HIDDEN 你的应用程序的所有UI界面被隐藏了，即用户点击了Home键或者Back键退出应用，
     *导致应用的UI界面完全不可见。这个时候应该释放一些不可见的时候非必须的资源
     *
     *程序正在前台运行的时候:
     *
     *TRIM_MEMORY_RUNNING_MODERATE：你的应用正在运行并且不会被列为可杀死的。但是设备此时正运行于低内存状态下，
     *系统开始触发杀死LRU Cache中的Process的机制
     *
     *TRIM_MEMORY_RUNNING_LOW：你的应用正在运行且没有被列为可杀死的。但是设备正运行于更低内存的状态下，你应该释放不用的资源用来提升系统性能
     *
     *TRIM_MEMORY_RUNNING_CRITICAL：你的应用仍在运行，但是系统已经把LRU Cache中的大多数进程都已经杀死，
     *             因此你应该立即释放所有非必须的资源。如果系统不能回收到足够的RAM数量，
     *             系统将会清除所有的LRU缓存中的进程，并且开始杀死那些之前被认为不应该杀死的进程，
     *             例如那个包含了一个运行态Service的进程。
     *
     *应用进程退到后台正在被Cached的时候:
     *
     *TRIM_MEMORY_BACKGROUND: 系统正运行于低内存状态并且你的进程正处于LRU缓存名单中最不容易杀掉的位置。
     *             尽管你的应用进程并不是处于被杀掉的高危险状态，系统可能已经开始杀掉LRU缓存中的其他进程了。你应该释放那些容易恢复的资源，
     *             以便于你的进程可以保留下来，这样当用户回退到你的应用的时候才能够迅速恢复。
     *
     *TRIM_MEMORY_MODERATE: 系统正运行于低内存状态并且你的进程已经已经接近LRU名单的中部位置。如果系统开始变得更加内存紧张，你的进程是有可能被杀死的。
     *
     *TRIM_MEMORY_COMPLETE: 系统正运行于低内存的状态并且你的进程正处于LRU名单中最容易被杀掉的位置。你应该释放任何不影响你的应用恢复状态的资源。
     */
    @Override
    public void onTrimMemory(int level) {
        // 程序在内存清理的时候执行
        //HOME键退出应用程序会调用
        //长按MENU键，打开Recent TASK，会调用
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                break;
            case TRIM_MEMORY_RUNNING_MODERATE:
                break;
            case TRIM_MEMORY_RUNNING_LOW:
                break;
            case TRIM_MEMORY_RUNNING_CRITICAL:
                break;
            case TRIM_MEMORY_BACKGROUND:
                break;
            case TRIM_MEMORY_MODERATE:
                break;
            case TRIM_MEMORY_COMPLETE:
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
