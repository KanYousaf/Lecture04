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
    String name;
    private Button button_press_id;
    private EditText editText_user_id, editText_user_password;
    private TextView textView_display_result;
    private RadioGroup tmnt_rg_id;
    private RadioButton tmnt_rb_don, tmnt_rb_leo, tmnt_rb_mike, tmnt_rb_raph;
    private ImageView tmnt_image_view_id;
    private RatingBar rate_tmnt;
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
        rate_tmnt=(RatingBar)this.findViewById(R.id.rate_tmnt);

        rate_tmnt.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate_tmnt.setRating(rating);
            }
        });

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
                editText_user_password.getText()+", rating is: "+rate_tmnt.getRating()
                +", and tmnt character is: "+tmnt_name(), Toast.LENGTH_SHORT).show();
    }

    public String tmnt_name(){
        if(tmnt_rb_don.isChecked())
        {
            name=String.valueOf(tmnt_rb_don.getText());
        }
        else if(tmnt_rb_leo.isChecked()){
            name=String.valueOf(tmnt_rb_leo.getText());
        }
        else if(tmnt_rb_mike.isChecked()){
            name=String.valueOf(tmnt_rb_mike.getText());
        }
        else {
            name=String.valueOf(tmnt_rb_raph.getText());
        }
        return name;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(this,"Hello Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"Hello Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this,"Hello Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Toast.makeText(this,"Hello Exit", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.playstore:
                Toast.makeText(this,"Hello Google", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
