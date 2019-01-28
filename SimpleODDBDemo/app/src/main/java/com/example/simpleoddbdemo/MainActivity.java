package com.example.simpleoddbdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nanimono.simpleoddb.DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_PERMISSION_CODE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private String fileName = "oddl_test.oddl";
    File oddlFile;

    private Button mExecuteButton;
    private Button mOpenButton;
    private Button mClearButton;
    private Button mResetButton;
    private TextView mTextQuery;
    private EditText mEditOddl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
        }
        DB.reset();

        mEditOddl = findViewById(R.id.edit_oddl);
        mTextQuery = findViewById(R.id.text_query);
        mTextQuery.setMovementMethod(new ScrollingMovementMethod());
        mExecuteButton = findViewById(R.id.button_execute);
        mExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditOddl.getText().toString();
                String result = DB.execute(input);
                StringBuilder builder = new StringBuilder(mTextQuery.getText());
                builder.append(result);
                mTextQuery.setText(new String(builder));
            }
        });
        mOpenButton = findViewById(R.id.button_open);
        mOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String oddl;
                try {
                    InputStream is = new FileInputStream(oddlFile);
                    int available = is.available();
                    byte[] data = new byte[available];
                    is.read(data);
                    oddl = new String(data);
                    mEditOddl.setText(oddl);
                    is.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        mClearButton = findViewById(R.id.button_clear);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditOddl.setText(null);
            }
        });
        mResetButton = findViewById(R.id.button_reset);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.reset();
                mTextQuery.setText(null);
            }
        });

        oddlFile = new File(Environment.getExternalStoragePublicDirectory("."), fileName);
    }
}
