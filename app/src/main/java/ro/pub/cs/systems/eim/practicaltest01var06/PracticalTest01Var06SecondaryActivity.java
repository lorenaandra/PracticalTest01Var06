package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.CHECK_COUNTER) && intent.getExtras().containsKey(Constants.CONTENT)) {
            int checkCounter = intent.getIntExtra(Constants.CHECK_COUNTER, -1);
            String content = intent.getStringExtra(Constants.CONTENT);
            String[] arrOfStr = content.split("");
            int current_score = 0;

            if (checkCounter == 0) {
                current_score = 100;
                Toast.makeText(PracticalTest01Var06SecondaryActivity.this,
                        "Score is " + current_score, Toast.LENGTH_SHORT).show();

            } else if (checkCounter == 1) {
                current_score = 50;
                Toast.makeText(PracticalTest01Var06SecondaryActivity.this,
                        "Score is " + current_score, Toast.LENGTH_SHORT).show();

            } else if (checkCounter == 2) {
                current_score = 10;
                Toast.makeText(PracticalTest01Var06SecondaryActivity.this,
                        "Score is " + current_score, Toast.LENGTH_SHORT).show();

            }

            if(arrOfStr[0] == arrOfStr[1]) {
                if (arrOfStr[1] == arrOfStr[2]) {
                    Toast.makeText(PracticalTest01Var06SecondaryActivity.this,
                            "GAINED", Toast.LENGTH_SHORT).show();

                }
            }

            Toast.makeText(PracticalTest01Var06SecondaryActivity.this,
                   content, Toast.LENGTH_SHORT).show();

            Intent intent_final = new Intent(getApplicationContext(), MainActivity.class);
            intent_final.putExtra(Constants.SCORE, String.valueOf(current_score));
            startActivityForResult(intent_final, Constants.MAIN_ACTIVITY_REQUEST_CODE);

//            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
        }

//        setContentView(R.layout.activity_practical_test01_var06_secondary);
    }
}