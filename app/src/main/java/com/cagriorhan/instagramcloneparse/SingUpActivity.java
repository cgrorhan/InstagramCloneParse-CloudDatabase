package com.cagriorhan.instagramcloneparse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SingUpActivity extends AppCompatActivity {

    EditText nameText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameText=findViewById(R.id.sign_up_activity_name_text);
        passwordText=findViewById(R.id.sign_up_activity_password_text);

        ParseUser parseUser=ParseUser.getCurrentUser();
        if(parseUser!=null){
            Intent intent=new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View view){
        ParseUser.logInInBackground(nameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Toast.makeText(SingUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SingUpActivity.this,"WELCOME "+user.getUsername(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);

                }
            }
        });

    }

    public void signUp(View view){

        ParseUser user=new ParseUser();
        user.setUsername(nameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(SingUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SingUpActivity.this,"USER CREATED..", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);

                }
            }
        });


    }
}
