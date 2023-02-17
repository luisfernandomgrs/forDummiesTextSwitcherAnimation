package com.materialdesign.textswitcherwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

	private TextSwitcher textSwitcher;
	private Button nextButton;
	private int stringIndex = 0;
	private String[] row = {"take", "raise", "motivate", "dream", "cater"};
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textSwitcher = findViewById(R.id.textSwitcher);
		nextButton = findViewById(R.id.nextButton);
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (stringIndex == row.length -1) {
					stringIndex = 0;
					textSwitcher.setText(row[stringIndex]);
				} else {
					textSwitcher.setText(row[++stringIndex]);
				}
			}
		});

		textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
			@Override
			public View makeView() {
				textView = new TextView(MainActivity.this);
				textView.setTextColor(Color.BLUE);
				textView.setTextSize(60);
				textView.setGravity(Gravity.CENTER_HORIZONTAL);
				return textView;
			}
		});

		textSwitcher.setText(row[stringIndex]);
	}
}