package com.example.tehtava_81;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> bottles;
    float money=0;
    int sodaBottles=5;

    TextView coin;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottles = new ArrayList<>();
        bottles.add("Pepsi Max");
        bottles.add("Pepsi Max");
        bottles.add("Pepsi Max");
        bottles.add("Pepsi Max");
        bottles.add("Pepsi Max");

        SeekBar addcoin = findViewById(R.id.addCoin);
        Button addmoney = findViewById(R.id.addmoney);
        Button retMoney = findViewById(R.id.retmoney);
        Button buy = findViewById(R.id.buy);
        text = (TextView) findViewById(R.id.textScreen);
        coin = (TextView) findViewById(R.id.numberScreen);

        //add coin
        addcoin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float cent=(float)progress/10;
                coin.setText(String.valueOf(cent));
                //add money
                addmoney.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        money += cent;
                        text.setText("Klink! Added more money! \nBalance:"+String.format("%.1f",money));
                        addcoin.setProgress(0);
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //return money
        retMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money==0){
                    text.setText("Klink klink!! All money gone!");
                }
                else if (money>0){
                    text.setText("Klink klink. Money came out!");
                }
            }
        });
        //buy bottle
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money>=1.8){
                    text.setText("Add money first!");
                }
                else if(sodaBottles<1){
                    text.setText("Out of stock");
                }
                else{
                    money -= 1.8;
                    sodaBottles -= 1;
                    text.setText("KACHUNK! "+bottles.get(0)+ " came out of the dispenser!");

                }
            }
        });
    }
}