package ru.levelp.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.message;

public class RegisterActivity extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private String login;
    private String password;
    private String confirmPassword;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        mLogin = (EditText) findViewById(R.id.edit_text_login_register);
        mPassword = (EditText) findViewById(R.id.edit_text_password_register);
        mConfirmPassword = (EditText) findViewById(R.id.edit_text_password_confirm);
        mRegister = (Button) findViewById(R.id.register_button);
        
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {

        login = mLogin.getText().toString();
        password = mPassword.getText().toString();
        confirmPassword = mConfirmPassword.getText().toString();
        if(login.length() == 0){
            showMessage("Invalid login!");
        }else if(password.length() < 8){
            showMessage("Very short password!");
        }else if(!password.equals(confirmPassword)){
            showMessage("Passwords not equals!");
        }else {
            showMessage("Success!");
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
