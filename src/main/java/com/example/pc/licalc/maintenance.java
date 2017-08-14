package com.example.pc.licalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pc on 13-08-2017.
 */

public class maintenance extends AppCompatActivity {
    TextView textView,textView2;
    EditText editText4,editText,editText2,editText3;
    int total=0,electricity=0,water=0,rent=0,pay=0,totalrevenue,nos,budget,thirdparty,tutor,marketing,management;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintenance);

        Intent mIntent = getIntent();
        budget = mIntent.getIntExtra(forreference.budget, 0);
        totalrevenue=mIntent.getIntExtra(forreference.totalrevenue, 0);
        nos=mIntent.getIntExtra(forreference.nos, 0);
        thirdparty =mIntent.getIntExtra(forreference.thirdparty,0);
        tutor =mIntent.getIntExtra(forreference.tutor,0);
        marketing=mIntent.getIntExtra(forreference.marketing,0);
        management=mIntent.getIntExtra(forreference.management,0);

        textView=(TextView)findViewById(R.id.maintainmoneyleft);
        editText=(EditText)findViewById(R.id.maintainelectricity);
        editText2=(EditText)findViewById(R.id.maintainwater);
        editText3=(EditText)findViewById(R.id.maintainrent);
        editText4=(EditText)findViewById(R.id.maintainpay);
        textView2=(TextView)findViewById(R.id.maintainamtpaid);

        textView.setText("Rs."+budget);
    }
    public void maintainbutton(View view) {
        String a = editText.getText().toString();
        try {
            electricity = Integer.parseInt(a);
        } catch (Exception e) {
            electricity=0;
        }
        a = editText2.getText().toString();
        try {
            water = Integer.parseInt(a);
        } catch (Exception e) {
            water=0;
        }
        a = editText3.getText().toString();
        try {
            rent = Integer.parseInt(a);
        } catch (Exception e) {
            rent=0;
        }
        a = editText4.getText().toString();
        try {
            pay = Integer.parseInt(a);
        } catch (Exception e) {
            pay=0;
        }

        total = total+electricity+water+pay+rent;
        textView2.setText("Rs." + String.valueOf(total));
        budget=budget-(electricity+water+pay+rent);

        Intent intent= new Intent(this, summary.class);
        intent.putExtra(forreference.budget, budget);
        intent.putExtra(forreference.totalrevenue, totalrevenue);
        intent.putExtra(forreference.nos, nos);
        intent.putExtra(forreference.thirdparty,thirdparty);
        intent.putExtra(forreference.tutor, tutor);
        intent.putExtra(forreference.marketing,marketing);
        intent.putExtra(forreference.management, management);
        intent.putExtra(forreference.maintenance,total);
        startActivity(intent);
        finish();
    }
}
