package com.example.seiska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Context context = null;
    TextView text;
    EditText input;
    String filename = " ";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        input = findViewById(R.id.editText);
        context = MainActivity.this;
        System.out.println("DIR!!!!!!!!!: " + context.getFilesDir());
    }
    public void save(View a) {
        try {
                text.setText("Writing to file: '" + filename + "'");
                OutputStreamWriter file = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_APPEND));
                String text = input.getText().toString();
                file.write(text + "\n");
                file.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void read(View b){
        try {
            filename = input.getText().toString();
            text.setText("Reading file: '" + filename + "'");
            InputStream file = context.openFileInput(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            file.close();
        }catch (FileNotFoundException e){
            System.out.println("error");
        }catch (IOException e){
            System.out.println("error");
        }
    }

}
