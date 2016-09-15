package nu.landslide.android.pogo_speedometer;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * Handles the placement of shortcuts and the selection of its options.
 * 
 * @author Roland Meyer
 * 
 */
public class ShortcutActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

	public static final String SHORTCUT_ENABLE = "ch.landslide.android.pogo_speedometer.enable";
	public static final String SHORTCUT_DISABLE = "ch.landslide.android.pogo_speedometer.disable";
	public static final String SHORTCUT_TOGGLE = "ch.landslide.android.pogo_speedometer.toggle";

	int choice = R.id.radio_shortcut_enable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shortcut);

		Button button = (Button) findViewById(R.id.btn_shortcut_ok);

		RadioGroup radio = (RadioGroup) findViewById(R.id.radio_shortcut);
		radio.setOnCheckedChangeListener(this);

		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		final int name;
		final String action;
		if (choice == R.id.radio_shortcut_enable) {
			name = R.string.shortcut_on;
			action = SHORTCUT_ENABLE;
		} else if (choice == R.id.radio_shortcut_disable) {
			name = R.string.shortcut_off;
			action = SHORTCUT_DISABLE;
		} else {
			name = R.string.shortcut_toggle;
			action = SHORTCUT_TOGGLE;
		}

		ShortcutIconResource icon = Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher);

		Intent intent = new Intent();

		Intent launchIntent = new Intent(this, DummyActivity.class);
		launchIntent.setPackage(getPackageName());
		intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, launchIntent);
		intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getText(name));
		intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		launchIntent.setAction(action);

		setResult(RESULT_OK, intent);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		choice = checkedId;
	}

}
