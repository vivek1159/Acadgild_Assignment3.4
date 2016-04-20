package com.example.vivek.assignment24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Email,Password;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Password);

        LoginButton=(Button)findViewById(R.id.LoginButton);

    }

    public void onClickLogin(View v)
    {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.equals(""))
        {
            Email.setError("Email id cannot be blank");
        }
        else if (password.equals(""))
        {
            Password.setError("Password cannot be blank");
        }
        else if(password.length()<8)
        {
            Password.setError("Password should be minimum 8 characters");
        }
        else if (isValidEmail(email))
        {
            Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Email.setError("Email ID not valid!");
        }
    }

    public static boolean isValidEmail(CharSequence target)
    {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
