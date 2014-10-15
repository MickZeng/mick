package com.example.test;

import android.graphics.Color;
import android.graphics.Typeface;

import com.example.test.res.Res;
import com.example.test.scene.GameScene;
import com.example.test.util.ConstantUtil;
import com.orange.audio.sound.SoundFactory;
import com.orange.engine.camera.ZoomCamera;
import com.orange.engine.options.PixelPerfectEngineOptions;
import com.orange.engine.options.PixelPerfectMode;
import com.orange.engine.options.ScreenOrientation;
import com.orange.res.FontRes;
import com.orange.res.RegionRes;
import com.orange.res.SoundRes;
import com.orange.ui.activity.GameActivity;

public class MainActivity extends GameActivity {

	@Override
	protected PixelPerfectEngineOptions onCreatePixelPerfectEngineOptions() {
		PixelPerfectEngineOptions pixelPerfectEngineOptions = new PixelPerfectEngineOptions(
				this, ZoomCamera.class);
		pixelPerfectEngineOptions
				.setScreenOrientation(ScreenOrientation.PORTRAIT_FIXED);
		pixelPerfectEngineOptions
				.setPixelPerfectMode(PixelPerfectMode.CHANGE_HEIGHT);
		pixelPerfectEngineOptions.setDesiredSize(ConstantUtil.DESIRED_SIZE);
		return pixelPerfectEngineOptions;
	}

	@Override
	protected void onLoadComplete() {
		this.startScene(GameScene.class);
	}

	@Override
	protected void onLoadResources() {
		RegionRes.loadTexturesFromAssets(Res.ALL_XML);

		FontRes.loadFont(128, 128,
				Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32, true,
				Color.BLACK, ConstantUtil.FONT_CARD_NUM);
		FontRes.loadFont(128, 128,
				Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 25, true,
				Color.WHITE, ConstantUtil.FONT_SCORE_NUM);

		SoundFactory.setAssetBasePath("mfx/");
		SoundRes.loadSoundFromAssets(ConstantUtil.SOUND_SELECT, "select.mp3");
		SoundRes.loadSoundFromAssets(ConstantUtil.SOUND_SETPOS, "setpos.mp3");
		SoundRes.loadSoundFromAssets(ConstantUtil.SOUND_MERGE, "merge.mp3");
	}

}
