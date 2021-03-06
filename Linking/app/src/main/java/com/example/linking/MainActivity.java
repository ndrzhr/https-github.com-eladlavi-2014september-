package com.example.linking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    public static final int REQUEST_CODE = 105;
    public static final String STR_1 = "str1";
    public static final String AGE_1 = "age1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnClick(View view){
        //Intent intent = new Intent("com.example.linking.SecondActivity");
        //startActivity(Intent.createChooser(intent, "Please choose"));

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(STR_1,"This is a string");
        intent.putExtra(AGE_1, 25);

        Bundle extras = new Bundle();
        extras.putString("str2","This is a string");
        extras.putInt("age2", 35);
        Dog d = new Dog();
        d.age = 5;
        extras.putSerializable("myDog",d);
        intent.putExtras(extras);

        //String s = intent.getStringExtra("str1");

        //startActivity(intent);

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_LONG).show();
            }
        }
    }
}
