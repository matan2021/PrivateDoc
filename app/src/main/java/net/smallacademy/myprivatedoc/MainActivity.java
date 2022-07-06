package net.smallacademy.myprivatedoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mLoginBtn = findViewById(R.id.LoginBtn);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("Matan28", "Matan28!", "205577349"));
        users.add(new Users("Chen15", "Chen1712@$", "315979401"));
        EditText mUserName = findViewById(R.id.fullName);
        EditText mPassword = findViewById(R.id.password);
        EditText mID = findViewById(R.id.id);
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        if (SetValidation(users, mUserName, mPassword, mID))
        {
            Intent intent = new Intent(this, NewPatient.class);
            startActivity(intent);
        }

    }
    public boolean SetValidation(ArrayList<Users> accounts, EditText mUserName, EditText mPassword, EditText mID) {
        String user_name = mUserName.getText().toString();
        String pass = mPassword.getText().toString();
        String id = mID.getText().toString();
        Users user=null;
        DialogLogin d=new DialogLogin();
        if (user_name.equals("") || pass.equals("") || id.equals("")) {
            d.setTitle("\nError\n");
            d.setMsg("Empty field\n please check you entered all details");
            d.show(getSupportFragmentManager(), "");
            return false;
        }
        for (int i = 0; i < accounts.size(); i++)
        {
            user= accounts.get(i);
            if(!user.validName())
            {
                d.setTitle("\nError\n");
                d.setMsg("Invalid Name\n");
                d.show(getSupportFragmentManager(), "");
                return false;
            }
            else if(!user.validPassword())
            {
                d.setTitle("\nError\n");
                d.setMsg("Invalid Password\n");
                d.show(getSupportFragmentManager(), "");
                return false;
            }
            else if(!user.validID())
            {
                d.setTitle("\nError\n");
                d.setMsg("Invalid ID\n");
                d.show(getSupportFragmentManager(), "");
                return false;
            }
            else if((accounts.get(i).username.equals(user_name)) && (accounts.get(i).password.equals(pass)) && (accounts.get(i).id_number.equals(id)))
            {
                return true;
            }
        }
        d.setTitle("\nError\n");
        d.setMsg("Unknown user\n");
        d.show(getSupportFragmentManager(), "");
        return false;
    }
}
