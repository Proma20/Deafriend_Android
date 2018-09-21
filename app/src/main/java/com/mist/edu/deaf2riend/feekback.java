package com.mist.edu.deaf2riend;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class feekback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feekback);
    }
    public void send_click(View v){
        EditText name = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText subject = (EditText) findViewById(R.id.subject);
        EditText message = (EditText) findViewById(R.id.message);

        if(name.getText().toString().equals(""))
            name.setError("Mandatory feild");
        else if (email.getText().toString().equals(""))
            email.setError("Mandatory feild");
        else if (subject.getText().toString().equals(""))
            subject.setError("Mandatory feild");
        else if (message.getText().toString().equals(""))
            message.setError("Mandatory feild");
        else{
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"projectcse322@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, "Dear developer, \n"
                    +message.getText().toString() + "\n regards, "
                    + email.getText().toString());

            try{
                startActivity(Intent.createChooser(i,"send mail"));
            } catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(this,"no mail app found",Toast.LENGTH_SHORT).show();
            } catch (Exception ex){
                Toast.makeText(this, "Unexpected error" + ex.toString(),Toast.LENGTH_SHORT).show();
            }
        }


    }
}
