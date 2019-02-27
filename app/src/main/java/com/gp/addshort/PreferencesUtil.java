package com.gp.addshort;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by guoping on 2017/5/13.
 */

public class PreferencesUtil {

    private static SharedPreferences preferences;

    static {
        preferences = App.globalContext.getSharedPreferences("shortCut", Context.MODE_PRIVATE);
    }

    public static boolean hasCreateShortcut(){

        return preferences.getBoolean("short_cut", false);
    }

    public static void setCreateShortCut(boolean b){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("short_cut", b).apply();
    }

    public static boolean hasCreateShortcutOneKeyClean(){
        return preferences.getBoolean("oneKeyClean", false);
    }

    public static  void setCreateShortCutOneKeyClean(boolean b){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("oneKeyClean", b).apply();
    }
    public static boolean hasCreateShortcutMyGame(){
        return preferences.getBoolean("myGame", false);
    }

    public static  void setCreateShortcutMyGame(boolean b){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("myGame", b).apply();
    }
}
