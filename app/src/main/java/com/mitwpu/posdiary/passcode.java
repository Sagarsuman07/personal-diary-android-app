package com.mitwpu.posdiary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class passcode extends AppCompatActivity
{
    private EditText pin1,pin2,pin3,pin4;
    private Button submitbtn;
    private String pin="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_passcode);

        pin1=findViewById(R.id.key1);
        pin2=findViewById(R.id.key2);
        pin3=findViewById(R.id.key3);
        pin4=findViewById(R.id.key4);


        submitbtn=findViewById(R.id.button);

        pin1.addTextChangedListener(new PinTextWatcher(pin1,pin2));
        pin2.addTextChangedListener(new PinTextWatcher(pin2,pin3));
        pin3.addTextChangedListener(new PinTextWatcher(pin3,pin4));
        pin4.addTextChangedListener(new PinTextWatcher(pin4,null));


        pin1.setOnKeyListener(new PinKeyListner(pin1,null));
        pin2.setOnKeyListener(new PinKeyListner(pin2,pin1));
        pin3.setOnKeyListener(new PinKeyListner(pin3,pin2));
        pin4.setOnKeyListener(new PinKeyListner(pin4,pin3));


        submitbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(passcode.this,dashboard.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private class PinTextWatcher implements TextWatcher
    {
        private View currentview;
        private View nextview;

        PinTextWatcher(View currentview,View nextview)
        {
            this.currentview=currentview;
            this.nextview=nextview;
        }

        @Override
        public void beforeTextChanged(CharSequence s,int start,int count,int after)
        {
        }

        @Override
        public void onTextChanged(CharSequence s,int start,int before,int count)
        {
            if(s.length()==1 && nextview != null)
            {
                nextview.requestFocus();
            }
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            if(currentview.getId()==R.id.key4)
            {
                pin=pin1.getText().toString()+
                    pin2.getText().toString()+
                    pin3.getText().toString()+
                    pin4.getText().toString();
            }
        }
    }


    public class PinKeyListner implements View.OnKeyListener
    {
        private View currentview,previousview;
        public PinKeyListner(View currentview,View previousview)
        {
            this.currentview=currentview;
            this.previousview=previousview;
        }


        @Override
        public boolean onKey(View v, int keycode, KeyEvent event)
        {
            if(keycode==KeyEvent.KEYCODE_DEL && event.getAction()==KeyEvent.ACTION_DOWN)
            {
                if(((EditText) currentview).getText().length()==0  &&  previousview!=null)
                {
                    previousview.requestFocus();
                }
            }
            return false;
        }
    }


}