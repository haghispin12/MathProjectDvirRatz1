package com.example.mathprojectdvirratz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
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


    Button etgar;

    Button cefel;
    Button lwach;
    TextView number1;
    TextView caful;
    TextView number2;
    EditText Answer;
    Button examination;
    Button save;
    Button show;
    Exercise e;
    int result;
    MainViewModel viewModel;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=new Exercise();



        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

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



                //ss
            }
        });





        etgar = findViewById(R.id.etgar);
        cefel = findViewById(R.id.cefel);
        lwach = findViewById(R.id.lwach);
        examination = findViewById(R.id.examination);
        //save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        number1 = findViewById(R.id.number1);
        caful = findViewById(R.id.caful);
        number2 = findViewById(R.id.number2);
        Answer = findViewById(R.id.Answer);



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
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                number1.setText("                   ");
//                number2.setText("                   ");
//                Answer.setText(null);
//                Answer.setHint("           Answer");
//
//            }
//        });
        examination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b =e.isGoodAnswer(Answer.getText().toString());
                if(Answer==null)
                    showToast("you are need to ");
                if(b==true)
                    showToast("you are good");
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
                // M.ExRandom1();
//                e.random1();
//                number1.setText(e.getNum1() + "");
//                number2.setText(e.getNum2() + "");


            }
        });
        cefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vRandom2();
//                e.random2();
//                number1.setText(e.getNum1()+"");
//                number2.setText(e.getNum2()+"");

            }
        });
        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vRandom3();
//                e.random3();
//                number1.setText(e.getNum1()+"");
//                number2.setText(e.getNum2()+"");


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

