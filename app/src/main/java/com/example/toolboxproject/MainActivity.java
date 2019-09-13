package com.example.toolboxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch toggleImage = (Switch) findViewById(R.id.switch1);
        final ImageView image = (ImageView) findViewById(R.id.imageView);

        toggleImage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    image.setVisibility(View.INVISIBLE);
                }
                else{
                    image.setVisibility(View.VISIBLE);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerTheme);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onCheckboxChecked(View v){
        TextView textView = (TextView) findViewById(R.id.wowTextView);
        boolean isChecked = ((CheckBox) v).isChecked();

        if(isChecked){
            textView.setText(R.string.checkText);
        }
        else {
            textView.setText(R.string.wowText);
        }
    }

    public void onRadioButtonClicked(View v){
        TextView textView = (TextView) findViewById(R.id.wowTextView);
        boolean isChecked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.radioBlue:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorBlue));
                }
                break;
            case R.id.radioRed:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorRed));
                }
                break;
            case R.id.radioGreen:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorGreen));
                }
                break;
            case R.id.radioBlack:
                if(isChecked){
                    textView.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
                break;
        }
    }



}
