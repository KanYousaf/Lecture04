package com.example.kanwal.lecture03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button button_press_id;
    private EditText editText_user_id, editText_user_password;
    private TextView textView_display_result;
    private RadioGroup tmnt_rg_id;
    private RadioButton tmnt_rb_don, tmnt_rb_leo, tmnt_rb_mike, tmnt_rb_raph;
    private ImageView tmnt_image_view_id;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_press_id = (Button) this.findViewById(R.id.press_button_id);
        textView_display_result = (TextView) this.findViewById(R.id.display_result);
        textView_display_result.setText(String.valueOf(count));
        tmnt_rg_id = (RadioGroup) this.findViewById(R.id.tmnt_rg);
        tmnt_rg_id.setVisibility(View.INVISIBLE);

        //Radio Button's IDs

        tmnt_rb_don = (RadioButton) this.findViewById(R.id.rb_don);
        tmnt_rb_leo = (RadioButton) this.findViewById(R.id.rb_leo);
        tmnt_rb_mike = (RadioButton) this.findViewById(R.id.rb_mike);
        tmnt_rb_raph = (RadioButton) this.findViewById(R.id.rb_raph);

        //ImageView for turtles
        tmnt_image_view_id = (ImageView) this.findViewById(R.id.display_tmnt_images);

        editText_user_id = (EditText) this.findViewById(R.id.edit_text_name);
        editText_user_password = (EditText) this.findViewById(R.id.edit_text_password);



//        button_press_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count++;
//                textView_display_result.setText(String.valueOf(count));
//            }
//        });
    }

    public void button_play_pressed(View view) {
        count++;
        textView_display_result.setText(String.valueOf(count));
        if (count % 2 == 0) {
            tmnt_rg_id.setVisibility(view.INVISIBLE);
            tmnt_image_view_id.setVisibility(view.INVISIBLE);
        } else {
            tmnt_rg_id.setVisibility(view.VISIBLE);
            tmnt_image_view_id.setVisibility(view.VISIBLE);
            tmnt_rb_don.setChecked(true);
            tmnt_display(tmnt_rb_don);
        }
    }

    public void tmnt_display(View view) {
        if (view.getId() == tmnt_rb_don.getId()) {
            tmnt_image_view_id.setImageResource(R.drawable.tmntdon);
        } else if (view.getId() == tmnt_rb_leo.getId()) {
            tmnt_image_view_id.setImageResource(R.drawable.tmntleo);
        } else if (view.getId() == tmnt_rb_mike.getId()) {
            tmnt_image_view_id.setImageResource(R.drawable.tmntmike);
        } else {
            tmnt_image_view_id.setImageResource(R.drawable.tmntraph);
        }
    }

    public void display_user_details(View view) {
        Toast.makeText(MainActivity.this, "The user name is: " + editText_user_id.getText() + " ,Password: " +
                editText_user_password.getText(), Toast.LENGTH_SHORT).show();
    }
}
