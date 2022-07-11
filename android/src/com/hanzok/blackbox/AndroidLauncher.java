package com.hanzok.blackbox;

import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.hanzok.blackbox.BlackBox;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useImmersiveMode= true;
		config.useCompass = false;
		config.useAccelerometer = false;
		config.hideStatusBar = true;
		config.useGyroscope = false;
		config.useRotationVectorSensor = false;


		initialize(new BlackBox(), config);
	}
}
