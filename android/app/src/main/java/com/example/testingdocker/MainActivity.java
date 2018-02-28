package com.example.testingdocker;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        setUpView();
        setUpEvents();
    }

    private void setUpView() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void setUpEvents() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.format("Welcome %s", etUserName.getText()), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void forceCrash(View view) {
        throw new Resources.NotFoundException();
    }
}
