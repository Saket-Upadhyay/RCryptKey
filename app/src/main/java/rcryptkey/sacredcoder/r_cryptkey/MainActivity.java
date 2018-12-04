package rcryptkey.sacredcoder.r_cryptkey;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    Button commandb;
    Button lockb;
    Button unlockb;
    EditText commin;
    Button opt;
//SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commandb=findViewById(R.id.commandb);
        lockb=findViewById(R.id.lockb);
        unlockb=findViewById(R.id.unlockb);
        opt=findViewById(R.id.opt);

        commin=findViewById(R.id.editText);



        lockb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);

                new clientAction().execute("lockd",sharedPreferences.getString("ipaddr","127.0.0.1"));
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vibrator.vibrate(250);
                }

            }
        });

        unlockb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);

                new clientAction().execute("opend",sharedPreferences.getString("ipaddr","127.0.0.1"));

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vibrator.vibrate(250);
                }
            }
        });

        commandb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                new clientAction().execute(commin.getText().toString(),sharedPreferences.getString("ipaddr","127.0.0.1"));
            }
        });




        opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               launchContactActivity();
            }
        });
    }

    private void launchContactActivity() {

        Intent intent = new Intent(this, More.class);
        startActivity(intent);
    }
}

