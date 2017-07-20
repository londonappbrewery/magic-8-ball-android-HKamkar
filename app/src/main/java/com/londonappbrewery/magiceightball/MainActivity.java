package com.londonappbrewery.magiceightball;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import static com.londonappbrewery.magiceightball.R.drawable.background_1;
import static com.londonappbrewery.magiceightball.R.drawable.background_2;

public class MainActivity extends AppCompatActivity {
  //Fields
  ConstraintLayout layout;
  Button btn_ask;
  Button btn_theme;
  ImageView ballDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    layout = (ConstraintLayout) findViewById(R.id.main);
    btn_ask = (Button) findViewById(R.id.btn_ask);
    btn_theme = (Button) findViewById(R.id.btn_background);
    ballDisplay = (ImageView) findViewById(R.id.img_8bal);
    final int[] ballArray = {R.drawable.ball1,
      R.drawable.ball2,
      R.drawable.ball3,
      R.drawable.ball4,
      R.drawable.ball5};

    // Click on Ask Button
    btn_ask.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int randomNumber = new Random().nextInt(5);
        ballDisplay.setImageResource(ballArray[randomNumber]);
      }
    });

    // Change theme
    btn_theme.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        changeTheme();
      }
    });
  }

  public void changeTheme() {
    if (layout.getBackground().getConstantState().equals(getResources().getDrawable(background_1).getConstantState())) {
      layout.setBackgroundResource(background_2);
      btn_theme.setBackgroundColor(getResources().getColor(R.color.button_color2));
      btn_ask.setBackgroundColor(getResources().getColor(R.color.button_color2));
    } else {
      layout.setBackgroundResource(background_1);
      btn_theme.setBackgroundColor(getResources().getColor(R.color.button_color));
      btn_ask.setBackgroundColor(getResources().getColor(R.color.button_color));
    }
  }
}
