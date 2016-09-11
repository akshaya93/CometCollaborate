package com.akshaya.sendemail;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"akshaya.udaya1593@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Test message");

                    emailIntent.setType("message/rfc822");
                    startActivity(emailIntent);
                }
                catch(ActivityNotFoundException e)
                {
                    Toast toast=Toast.makeText(MainActivity.this,"Sorry no email client found :(",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
