package ru.levelp.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.message;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mLogin;
    private EditText mPassword;
    private String login;
    private String password;
    private Button mSignIn;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

//        login = ((EditText) findViewById(R.id.edit_text_login)).getText().toString();
//        password = ((EditText) findViewById(R.id.edit_text_password)).getText().toString();

        mLogin = (EditText) findViewById(R.id.edit_text_login);
        mPassword = (EditText) findViewById(R.id.edit_text_password);
        mSignIn = (Button) findViewById(R.id.sign_in_button);
        mSignUp = (Button) findViewById(R.id.sign_up_button);
//        mSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signIn();
//            }
//        });
//        mSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(AuthActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });
        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);




    }

    private void showMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    private void signIn(){
        login = mLogin.getText().toString();
        password = mPassword.getText().toString();
        if(login.length() == 0 || password.length() == 0){
            showMessage("Invalid login or password!");
        }else {
            showMessage("Success!");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case (R.id.sign_in_button):
                signIn();
                break;
            case (R.id.sign_up_button):
                Intent i = new Intent(AuthActivity.this, RegisterActivity.class);
                startActivity(i);
                break;
        }

    }
}
