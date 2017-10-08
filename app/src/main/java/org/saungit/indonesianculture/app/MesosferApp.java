package org.saungit.indonesianculture.app;

import android.app.Application;

import com.eyro.mesosfer.Mesosfer;

/**
 * Created by Muhtar on 19/11/2016.
 */

public class MesosferApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Mesosfer.initialize(this, "KNVFgcSJ4u", "ykfNcA4xhxBRZ5Z4N9PmczsZYvjSUaEJ");
    }
}
