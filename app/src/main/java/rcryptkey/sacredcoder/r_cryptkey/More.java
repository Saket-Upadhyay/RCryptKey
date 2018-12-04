package rcryptkey.sacredcoder.r_cryptkey;

import android.content.Intent;
import android.content.SharedPreferences;
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
            }
        });



        lockdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                new clientAction().execute("realLockD",sharedPreferences.getString("ipaddr","127.0.0.1"));
            }
        });



        checkcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("rkeydata",MODE_PRIVATE);
                new clientAction().execute("TC",sharedPreferences.getString("ipaddr","127.0.0.1"));
            }
        });
    }



    public void backToMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
