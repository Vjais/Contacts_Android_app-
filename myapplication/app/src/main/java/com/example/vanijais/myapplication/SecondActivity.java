package com.example.vanijais.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    //final Intent intent = new Intent();

    protected static int RESULT_CODE = 1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText fname = (EditText) findViewById(R.id.editText2);
        final TextView tname = (TextView) findViewById(R.id.textView);

        final Button buttn2 = (Button) findViewById(R.id.button2);
        final String fname1 = fname.getText().toString();

        final View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_INSERT);
                i.setType(ContactsContract.Contacts.CONTENT_TYPE);
                i.putExtra(ContactsContract.Intents.Insert.NAME, fname.getText().toString());
                i.putExtra("finishActivityOnSaveCompleted", true);
                startActivityForResult(i, RESULT_CODE);
            }
        };

        buttn2.setOnClickListener(event);




//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        TextView tname = (TextView) findViewById(R.id.textView);
//        if (requestCode == 1) {
//
//            if (resultCode == RESULT_OK) {
//                tname.setText("Contact is added ");
//            }
//            else if (resultCode == RESULT_CANCELED) {
//                tname.setText("Contact not added");
//
//            }
//        }
//
//    }
    }
    @Override
    public void onActivityResult(int resultCode, int requestCode, Intent data){
        final TextView xView = (TextView)findViewById(R.id.textView);
        if (requestCode == -1){
            xView.setText("ContactSaved");
        }
        else{
            xView.setText("Contact not saved.");
        }
    }
}








