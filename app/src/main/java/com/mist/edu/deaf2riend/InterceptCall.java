package com.mist.edu.deaf2riend;

/**
 * Created by Administrator on 10/16/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class InterceptCall extends BroadcastReceiver {
    Camera camera;
    Camera.Parameters parameters;
    boolean isOn;

    @Override
    public void onReceive(Context context, Intent intent) {

        camera = Camera.open();
        parameters = camera.getParameters();



        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {

                for(int i=0;i<100 ;i++){
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    Toast.makeText(context, "Ringing!", Toast.LENGTH_LONG).show();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.stopPreview();

                }


            }

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
                Toast.makeText(context, "Recieved", Toast.LENGTH_SHORT).show();
            }
            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
                Toast.makeText(context, "Idle!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
