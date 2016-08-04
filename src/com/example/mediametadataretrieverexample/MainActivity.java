package com.example.mediametadataretrieverexample;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView info = (TextView) findViewById(R.id.info);
		// load data file
		MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
		metaRetriever.setDataSource(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera/video2.mp4");

		String out = "";
		// get mp3 info
		out += metaRetriever
				.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
		info.setText(out);
		// out += "\n";
		// out +=
		// metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
		// out += "\n";
		// out +=
		// metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
		// out += "\n";
		// out +=
		// metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
		// out += "\n";
		// convert duration to minute:seconds
		
		//단위가 마이크로초(10000000초)
		Bitmap thumbnail = metaRetriever.getFrameAtTime(20000000);
		ImageView thumbnailView = (ImageView) findViewById(R.id.thumbnail);
		thumbnailView.setImageBitmap(thumbnail);

		// close object
		metaRetriever.release();
		// display output
	}

}
