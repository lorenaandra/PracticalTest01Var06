package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private CheckBox checkBox1, checkBox2, checkBox3;

    private EditText editText1, editText2, editText3;
    private Integer finalScore = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.play_button:

                    Integer score = 0;

                    ArrayList<String> values = new ArrayList<>();
                    values.add("1");
                    values.add("2");
                    values.add("3");
                    values.add("*");
                    Random rand = new Random();
                    int upperbound = 3;
                    int index = rand.nextInt(upperbound);
                    int checkCounter = 0;
                    StringBuilder content = new StringBuilder();

                    if(!checkBox1.isChecked()) {
                        editText1.setText(String.valueOf(values.get(index)));
                    } else {
                        checkCounter++;
                    }

                    if(!checkBox2.isChecked()) {
                        editText2.setText(String.valueOf(values.get(index)));
                    } else {
                        checkCounter++;
                    }

                    if(!checkBox3.isChecked()) {
                        editText3.setText(String.valueOf(values.get(index)));
                    } else {
                        checkCounter++;
                    }

                    content.append(editText1.getText().toString());
                    content.append(editText2.getText().toString());
                    content.append(editText3.getText().toString());

                    Toast.makeText(MainActivity.this, String.valueOf(values.get(index)), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                    intent.putExtra(Constants.CHECK_COUNTER, checkCounter);
                    intent.putExtra(Constants.CONTENT, (CharSequence) content);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);

                    Intent final_intent = getIntent();
                    if (final_intent != null && intent.getExtras().containsKey(String.valueOf(Constants.MAIN_ACTIVITY_REQUEST_CODE))) {
                        int currentScore = intent.getIntExtra(Constants.SCORE, -1);
                        finalScore += currentScore;
                        Toast.makeText(MainActivity.this,
                                "Total score is " + finalScore, Toast.LENGTH_SHORT).show();

                    }


//                    if (checkCounter == 0) {
//                        score = 100;
//                    } else if (checkCounter == 1) {
//                        score = 50;
//                    } else if (checkCounter == 2) {
//                        score = 10;
//                    }
//
//                    finalScore += score;
//                    Toast.makeText(MainActivity.this,
//                            "Final score is " + String.valueOf(finalScore), Toast.LENGTH_SHORT).show();

                    break;
            }



        }
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);

        checkBox1 = findViewById(R.id.hold1);
        checkBox2 = findViewById(R.id.hold2);
        checkBox3 = findViewById(R.id.hold3);

        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);
        editText3 = findViewById(R.id.edit3);
        }


}