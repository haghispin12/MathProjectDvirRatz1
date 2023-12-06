package com.example.mathprojectdvirratz1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private void showToast (String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }



    ActivityResultLauncher<Intent>activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int myrate = result.getData().getIntExtra("End", -1);
                    showToast("you choose "+myrate);
                }
            });




    Button save;
    Button rate;
    Button etgar;
    Button cefel;
    Button lwach;
    TextView number1;
    TextView caful;
    TextView number2;
    EditText Answer;
    Button examination;
//    Button save;
    Button show;
    //Exercise exercise;
    int result;
    MainViewModel viewModel;
    TextView score;
    int state = 1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        showToast("hello "+name+"");





        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.set_user_name(name);

        viewModel.vNum1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                number1.setText(integer+"");
            }
        });

        viewModel.vNum2.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                number2.setText(integer+"");
            }

        });
        viewModel.vScore.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                score.setText(integer+"");


            }
        });




        save = findViewById(R.id.save);
        rate = findViewById(R.id.rate);
        etgar = findViewById(R.id.etgar);
        cefel = findViewById(R.id.cefel);
        lwach = findViewById(R.id.lwach);
        examination = findViewById(R.id.examination);
        show = findViewById(R.id.show);
        number1 = findViewById(R.id.number1);
        caful = findViewById(R.id.caful);
        number2 = findViewById(R.id.number2);
        Answer = findViewById(R.id.Answer);
        score = findViewById(R.id.score);




        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(  MainActivity.this, RateActivity.class );
                activityResultLauncher.launch(intent);




            }
        });
        Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        examination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=viewModel.vNum1.getValue();
                int num2=viewModel.vNum2.getValue();
                String str = num*num2+"";

                boolean b= viewModel.vChack(str,state);
                if(b)
                    showToast("you are good bro");
                else
                    showToast("not so good this is false");
                Answer.setText("");
                number2.setText("");
                number1.setText("");
            }
        });
        lwach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vRandom1();
                state = 1;


            }
        });
        cefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vRandom2();
                state = 3;

            }
        });
        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vRandom3();
                state = 2;


            }

        });
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



    }

}

