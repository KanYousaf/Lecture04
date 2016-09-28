package com.example.kanwal.lecture03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    private EditText userName_id, password_id;
    private Button login_button_id;
    private TextView textView_tmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userName_id=(EditText) this.findViewById(R.id.editText);
        password_id=(EditText)this.findViewById(R.id.editText2);

        login_button_id=(Button)this.findViewById(R.id.login_button);

        //display charactername and rating
        textView_tmnt = (TextView) this.findViewById
                (R.id.display_tmnt_result);


    }

    public void login_function(View view) {
        if((userName_id.getText().toString().equals("")) ||
                (password_id.getText().toString().equals(""))){
            Toast.makeText(this, "please enter username and password",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(HomePage.this, MainActivity.class);
            intent.putExtra("userName_key",userName_id.getText().toString());
            startActivityForResult(intent,123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==123){
            textView_tmnt.setText(data.getStringExtra("tmnt_character_name")+" "+
                    data.getExtras().getFloat("tmnt_rate"));


        }


    }
}
