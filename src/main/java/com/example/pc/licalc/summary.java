package com.example.pc.licalc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pc on 13-08-2017.
 */

public class summary extends AppCompatActivity {
    int nos,totalrevenue,budget,thirdparty,tutor,marketing,management,maintenance;
    double percentage=0;
    TextView editText,editText2,editText3,editText4,editText5,editText6,editText7,editText8;
    TextView textView2,textView3,textView4,textView5,textView6,textView7;
    TextView sol,sol2,sol3,sol4,sol5,sol6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        Intent mIntent = getIntent();
        budget = mIntent.getIntExtra(forreference.budget, 0);
        totalrevenue=mIntent.getIntExtra(forreference.totalrevenue, 0);
        nos=mIntent.getIntExtra(forreference.nos, 0);
        thirdparty =mIntent.getIntExtra(forreference.thirdparty,0);
        tutor =mIntent.getIntExtra(forreference.tutor,0);
        marketing=mIntent.getIntExtra(forreference.marketing,0);
        management=mIntent.getIntExtra(forreference.management,0);
        maintenance=mIntent.getIntExtra(forreference.maintenance,0);

        editText = (TextView) findViewById(R.id.totalearning);
        editText2 = (TextView) findViewById(R.id.paidtotutor);
        editText3 = (TextView) findViewById(R.id.thirdpartyearning);
        editText4 = (TextView) findViewById(R.id.spentinmarketing);
        editText5 = (TextView) findViewById(R.id.spentinmanagement);
        editText6 = (TextView) findViewById(R.id.spentinmaintenance);
        editText7 = (TextView) findViewById(R.id.profit);
        editText8 = (TextView) findViewById(R.id.totalnumberofstudents);

        sol=(TextView) findViewById(R.id.sol1);
        sol2=(TextView) findViewById(R.id.sol2);
        sol3=(TextView) findViewById(R.id.sol3);
        sol4=(TextView) findViewById(R.id.sol4);
        sol5=(TextView) findViewById(R.id.sol5);
        sol6=(TextView) findViewById(R.id.sol6);

        textView2 = (TextView) findViewById(R.id.ipaidtotutor);
        textView3 = (TextView) findViewById(R.id.ithirdpartyearning);
        textView4 = (TextView) findViewById(R.id.ispentinmarketing);
        textView5 = (TextView) findViewById(R.id.ispentinmanagement);
        textView6 = (TextView) findViewById(R.id.ispentinmaintenance);
        textView7 = (TextView) findViewById(R.id.iprofit);

        editText.setText("Rs."+Integer.toString(totalrevenue));
        editText2.setText("Rs."+Integer.toString(tutor));
        editText3.setText("Rs."+Integer.toString(thirdparty));
        editText4.setText("Rs."+Integer.toString(marketing));
        editText5.setText("Rs."+Integer.toString(management));
        editText6.setText("Rs."+Integer.toString(maintenance));
        editText7.setText("Rs."+Integer.toString(budget-(totalrevenue*26/100)));
        editText8.setText(Integer.toString(nos)+" Students");
        budget=budget-(totalrevenue*26/100);

        percentage=Math.round((tutor*100)/totalrevenue);
        if(tutor<20000){
            textView2.setTextColor(Color.GREEN);
        }
        else if(tutor==20000){
            textView2.setTextColor(Color.BLUE);
        }
        else{
            textView2.setTextColor(Color.RED);
            sol.setText("Reduce tutor's pay by "+Integer.toString(tutor-20000));
        }
        textView2.setText(Double.toString(percentage)+" %");

        percentage=Math.round((thirdparty*100)/totalrevenue);
        if(percentage<20){
            textView3.setTextColor(Color.GREEN);
        }
        else if(percentage==20){
            textView3.setTextColor(Color.BLUE);
        }
        else{
            textView3.setTextColor(Color.RED);
            if(sol.getText().equals("")){
                percentage=percentage-20;
                percentage=percentage*totalrevenue;
                sol.setText("Reduce third party payment by "+Double.toString(percentage));
            }
            else{
                percentage=percentage-20;
                percentage=percentage*totalrevenue;
                sol2.setText("Reduce third party payment by "+Double.toString(percentage));
            }
        }
        percentage=Math.round((thirdparty*100)/totalrevenue);
        textView3.setText(Double.toString(percentage)+" %");

        percentage=Math.round((marketing*100)/totalrevenue);
        if(marketing<5000){
            textView4.setTextColor(Color.GREEN);
        }
        else if(marketing==5000){
            textView4.setTextColor(Color.BLUE);
        }
        else{
            textView4.setTextColor(Color.RED);
            if (sol.getText().equals("")){
                sol.setText("Reduce marketing money by "+Integer.toString(marketing-5000));
            }
            else if (sol2.getText().equals("")){
                sol2.setText("Reduce marketing money by "+Integer.toString(marketing-5000));
            }
            else{
                sol3.setText("Reduce marketing money by "+Integer.toString(marketing-5000));
            }
        }
        textView4.setText(Double.toString(percentage)+" %");

        percentage=Math.round((management*100)/totalrevenue);
        if(management<5000){
            textView5.setTextColor(Color.GREEN);
        }
        else if(management==5000){
            textView5.setTextColor(Color.BLUE);
        }
        else{
            textView5.setTextColor(Color.RED);
            if (sol.getText().equals("")){
                sol.setText("Reduce management money by "+Integer.toString(management-5000));
            }
            else if (sol2.getText().equals("")){
                sol2.setText("Reduce management money by "+Integer.toString(management-5000));
            }
            else if (sol3.getText().equals("")){
                sol3.setText("Reduce management money by "+Integer.toString(management-5000));
            }
            else{
                sol4.setText("Reduce management money by "+Integer.toString(management-5000));
            }
        }
        textView5.setText(Double.toString(percentage)+" %");

        percentage=Math.round((maintenance*100)/totalrevenue);
        if(maintenance<8000){
            textView6.setTextColor(Color.GREEN);
        }
        else if(maintenance==8000){
            textView6.setTextColor(Color.BLUE);
        }
        else{
            textView6.setTextColor(Color.RED);
            if (sol.getText().equals("")){
                sol.setText("Reduce maintenance money by "+Integer.toString(maintenance-5000));
            }
            else if (sol2.getText().equals("")){
                sol2.setText("Reduce maintenance money by "+Integer.toString(maintenance-5000));
            }
            else if (sol3.getText().equals("")){
                sol3.setText("Reduce maintenance money by "+Integer.toString(maintenance-5000));
            }
            else if (sol4.getText().equals("")){
                sol4.setText("Reduce maintenance money by "+Integer.toString(maintenance-5000));
            }
            else{
                sol5.setText("Reduce maintenance money by "+Integer.toString(maintenance-5000));
            }
        }
        textView6.setText(Double.toString(percentage)+" %");

        percentage=Math.round((budget*100)/totalrevenue);
        if(budget>20000){
            textView7.setTextColor(Color.GREEN);
        }
        else if(budget==20000){
            textView7.setTextColor(Color.BLUE);
        }
        else{
            textView7.setTextColor(Color.RED);
            if (sol.getText().equals("")){
                sol.setText("Take two batches to achieve desired profit");
            }
            else if (sol2.getText().equals("")){

            }
            else if (sol3.getText().equals("")){

            }
            else if (sol4.getText().equals("")){

            }
            else if(sol5.getText().equals("")){

            }
            else{
                sol6.setText("Every dept. is over paid");
            }
        }
        textView7.setText(Double.toString(percentage)+" %");
        if (sol.getText().equals("")) {
            sol.setText("Good course design in terms of profit !");
        }
    }
}
