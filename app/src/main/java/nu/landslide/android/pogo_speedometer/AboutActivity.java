package nu.landslide.android.pogo_speedometer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class AboutActivity extends Activity {

	private static final String CONTACT_SUBJECT = "PoGo Speedometer";
	private static final String CONTACT_TEXT = "Enter your message here";
	private static final String DEVELOPER_EMAIL = "johan@landslide.nu";
	private static final String GITHUB_URL = "https://github.com/johan-karlsson-goobit-se/PoGo-Speedometer";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		findViewById(R.id.contact_button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				String[] recipients = { DEVELOPER_EMAIL };
				intent.putExtra(Intent.EXTRA_EMAIL, recipients);
				intent.putExtra(Intent.EXTRA_SUBJECT, CONTACT_SUBJECT);
				intent.putExtra(Intent.EXTRA_TEXT, CONTACT_TEXT);
				intent.setType("text/html");
				startActivity(Intent.createChooser(intent, getString(R.string.contact)));
			}

		});

		findViewById(R.id.github_button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
				startActivity(browserIntent);
			}

		});
	}
}
