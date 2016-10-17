package ru.levelp.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity{

    private int count = 0;

    private Button testButton;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testButton = (Button) findViewById(R.id.test_button);
        textView = (TextView) findViewById(R.id.text1);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTestButtonClicked();
            }
        });

    }

    private void onTestButtonClicked() {

//        testButton.setBackgroundResource(R.color.colorPrimary);
        count++;
        textView.setText(String.valueOf(count));
        if(count % 5 == 0){
            testButton.setBackgroundResource(R.color.colorPrimary);
        }else {
            testButton.setBackgroundResource(R.color.colorAccent);
        }
    }
}
