package com.lionel.multipermissionp;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.lionel.multipermissionp.PermissionChecker.PERMISSION_ALL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
    }

    private void checkPermission() {
        PermissionChecker.requestPermissions(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ALL) {
            if (grantResults.length > 0) {
                int sumResult = 0;
                for (int result : grantResults) {
                    sumResult += result;
                }
                if (sumResult == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permissions granted.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permissions denied.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
