package com.lionel.multipermissionp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

public class PermissionChecker {

    public static final int PERMISSION_ALL = 100;
    private static String[] PERMISSIONS = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_SMS,
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.CALL_PHONE
    };

    @TargetApi(Build.VERSION_CODES.M)
    public static void requestPermissions(Activity activity) {
        if (!hasPermissions(activity, PERMISSIONS)) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS, PERMISSION_ALL);
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
