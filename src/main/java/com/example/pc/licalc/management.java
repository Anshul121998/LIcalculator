package com.example.pc.licalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pc on 13-08-2017.
 */

public class management extends AppCompatActivity {
    TextView textView,textView2;
    EditText editText,editText2,editText3;
    int total=0,nos1=0,charge=0,bonus=0,totalrevenue,nos,budget,thirdparty,tutor,marketing=0,tosend=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management);

        Intent mIntent = getIntent();
        budget = mIntent.getIntExtra(forreference.budget, 0);
        totalrevenue=mIntent.getIntExtra(forreference.totalrevenue, 0);
        nos=mIntent.getIntExtra(forreference.nos, 0);
        thirdparty =mIntent.getIntExtra(forreference.thirdparty,0);
        tutor =mIntent.getIntExtra(forreference.tutor,0);
        marketing =mIntent.getIntExtra(forreference.marketing,0);

        textView=(TextView)findViewById(R.id.managemoneyleft);
        editText=(EditText)findViewById(R.id.managedstudent);
        editText2=(EditText)findViewById(R.id.managepay);
        editText3=(EditText)findViewById(R.id.managebonus);
        textView2=(TextView)findViewById(R.id.manageamtpaid);

        textView.setText("Rs."+budget);
    }
    public void managenextpg(View view) {
        String a = editText.getText().toString();
        try {
            nos1 = Integer.parseInt(a);
        } catch (Exception e) {
            nos1=0;
        }
        a = editText2.getText().toString();
        try {
            charge = Integer.parseInt(a);
        } catch (Exception e) {
            charge=0;
        }
        a = editText3.getText().toString();
        try {
            bonus = Integer.parseInt(a);
        } catch (Exception e) {
            bonus=0;
        }
        tosend=((nos1 * charge) + bonus);
        total = total +tosend;
            textView2.setText("Rs." + String.valueOf(tosend));
            budget=budget-tosend;

        Intent intent= new Intent(this, maintenance.class);
        intent.putExtra(forreference.budget, budget);
        intent.putExtra(forreference.totalrevenue, totalrevenue);
        intent.putExtra(forreference.nos, nos);
        intent.putExtra(forreference.thirdparty,thirdparty);
        intent.putExtra(forreference.tutor, tutor);
        intent.putExtra(forreference.marketing,marketing);
        intent.putExtra(forreference.management, total);
        startActivity(intent);
        tosend=0;
        textView.setText("Rs."+budget);
        if(nos1>=nos){
            finish();
        }
    }
}
