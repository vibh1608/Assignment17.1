package com.example.user.assignment171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    //creating reference of UI components
    Button mstart,mstop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting reference with their ID's
        mstart = findViewById(R.id.start);
        mstop = findViewById(R.id.stop);

        //on click of start button
        mstart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,MyServices.class);

                //starting service
                startService(intent);
            }
        });

        //on click of stop button
        mstop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,MyServices.class);

                //stopping service
                stopService(intent);
            }
        });
    }
}
