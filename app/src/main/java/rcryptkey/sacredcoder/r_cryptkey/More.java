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
import android.widget.TextView;

public class More extends AppCompatActivity {


    Button update_v;
    Button update_d;
    Button backtomain;
    EditText ipin;
    String ipaddr=null;
    TextView ipshow;
    Button lockdown;
    Button checkcon;
    Button exitb;
    Button shutdownb;
    Button hybernateb;
    EditText password;
String masterpass="7291835";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ipin=findViewById(R.id.ipin);
        update_d=findViewById(R.id.update_data);
        update_v=findViewById(R.id.update_view);
        ipshow=findViewById(R.id.ipshow);
        backtomain=findViewById(R.id.backtomain);
        lockdown=findViewById(R.id.lockdown);
        checkcon=findViewById(R.id.checkconn);
        exitb=findViewById(R.id.exitb);
        shutdownb=findViewById(R.id.shutdownb);
        hybernateb=findViewById(R.id.hybernateb);
        password=findViewById(R.id.password);




        try{
           SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                    ipaddr=sharedPreferences.getString("ipaddr","127.0.0.1");
            ipshow.setText("IP ADDR : "+ipaddr);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e2)
        {
            e2.printStackTrace();
        }
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        update_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                ipshow.setText("IP ADDR : "+sharedPreferences.getString("ipaddr","127.0.0.1"));
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

        update_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("ipaddr",ipin.getText().toString());
                editor.commit();
                ipshow.setText(ipin.getText().toString());
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



        lockdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                new clientAction().execute("realLockD",sharedPreferences.getString("ipaddr","127.0.0.1"));
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



        checkcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                new clientAction().execute("TC",sharedPreferences.getString("ipaddr","127.0.0.1"));
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



        exitb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if(password.getText().toString().equals(masterpass)) {


                    SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                    new clientAction().execute("EXIT",sharedPreferences.getString("ipaddr","127.0.0.1"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(250);
                    }

                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(1000);
                    }
                }
            }
        });


        shutdownb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (password.getText().toString().equals(masterpass)) {
                    SharedPreferences sharedPreferences = getSharedPreferences("rkeydata", MODE_PRIVATE);
                    new clientAction().execute("ShutDownExeFinalForce", sharedPreferences.getString("ipaddr", "127.0.0.1"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(250);
                    }
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(1000);
                    }
                }
            }
        });


        hybernateb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (password.getText().toString().equals(masterpass))
                {

                    SharedPreferences sharedPreferences = getSharedPreferences("rkeydata", MODE_PRIVATE);
                    new clientAction().execute("SA", sharedPreferences.getString("ipaddr", "127.0.0.1"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(250);
                    }
                }
                else
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vibrator.vibrate(1000);
                    }
                }
            }
        });

    }



    public void backToMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }

}
