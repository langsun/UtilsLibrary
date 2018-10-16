package com.sun.library;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sun on 18/10/16.
 */

public class ToastUtil {
    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, int res) {
        Toast.makeText(context, res, Toast.LENGTH_LONG).show();
    }
}
