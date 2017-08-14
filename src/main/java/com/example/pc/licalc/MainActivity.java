package com.example.pc.licalc;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int nos=0,totalrevenue=0,budget,thirdparty=0,tutor=0;
    float charged=0,itutor=0,ithirdparty=0;
    EditText editText,editText2,editText3,editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText7);
        editText2 = (EditText) findViewById(R.id.editText8);
        editText3 = (EditText) findViewById(R.id.editText9);
        editText4 = (EditText) findViewById(R.id.editText10);
    }
    public void dataupdate(View view){
        String a = editText.getText().toString();
        try{
            nos = Integer.valueOf(a);
        }catch (Exception e){
            nos=0;
        }
        a = editText2.getText().toString();
        try{
            charged=Float.parseFloat(a);
        }catch (Exception e){
            charged=0;
        }
        a = editText3.getText().toString();
        try{
            itutor=Float.parseFloat(a);
        }catch (Exception e){
            itutor=0;
        }
        tutor=Math.round(itutor*1000);
        a = editText4.getText().toString();
        try{
            ithirdparty=Float.parseFloat(a);
        }catch (Exception e){
            thirdparty=0;
        }
        thirdparty=Math.round(ithirdparty*1000);
        totalrevenue=Math.round(nos*charged*1000);
        budget=Math.round(totalrevenue-(tutor)-(thirdparty));
        if(totalrevenue>0) {
            newclass();
        }
    }
    public void newclass(){
        Intent intent= new Intent(this, marketing.class);
        intent.putExtra(forreference.budget, budget);
        intent.putExtra(forreference.totalrevenue, totalrevenue);
        intent.putExtra(forreference.nos, nos);
        intent.putExtra(forreference.thirdparty,thirdparty);
        intent.putExtra(forreference.tutor,tutor);
        startActivity(intent);
        Log.i("third party",Integer.toString(thirdparty));
        Log.i("tutor",Integer.toString(tutor));
    }
}
