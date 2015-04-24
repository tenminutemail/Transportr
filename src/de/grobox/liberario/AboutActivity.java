/*    Liberario
 *    Copyright (C) 2013 Torsten Grote
 *
 *    This program is Free Software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.grobox.liberario;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().requestFeature(Window.FEATURE_LEFT_ICON);
		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, android.R.drawable.ic_dialog_info);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		setTitle(getResources().getString(R.string.action_about) + " " + getResources().getString(R.string.app_name));

		String versionName;
		try {
			versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			versionName = "?.?";
		}

		// add app name and version
		TextView aboutApp = (TextView) findViewById(R.id.aboutApp);
		aboutApp.setText(getResources().getString(R.string.app_name) + "  " + versionName);

		// create real paragraphs
		TextView t = (TextView) findViewById(R.id.aboutTextView);
		t.setText(Html.fromHtml(getString(R.string.about)));

		// make links in about text clickable
		t.setMovementMethod(LinkMovementMethod.getInstance());
	}

	public void close(View v) {
		finish();
	}

}
