package com.example.mathprojectdvirratz1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel{
    Exercise e;
    User user;



    MutableLiveData<Integer>vNum1;

    MutableLiveData<Integer>vNum2;

    MutableLiveData<Integer>vScore;


    public MainViewModel(){
        user = new User();
        e = new Exercise();
        vNum2=new MutableLiveData<>();
        vNum1=new MutableLiveData<>();
        vScore = new MutableLiveData<>();
    }

    public void vRandom3(){
        e.random3();
        vNum1.setValue(e.getNum1());
        vNum2.setValue(e.getNum2());
    }

    public void vRandom2(){
        e.random2();
        vNum1.setValue(e.getNum1());
        vNum2.setValue(e.getNum2());
    }

    public void vRandom1(){
        e.random1();
        vNum1.setValue(e.getNum1());
        vNum2.setValue(e.getNum2());
    }

    public Boolean vChack(String str, int state){
        boolean b= e.isGoodAnswer(str);
        if(b){
            if(state == 1){
                user.setScore(user.getScore()+5);
            } else if (state == 2){
                user.setScore(user.getScore()+20);
            } else if (state == 3){
                user.setScore(user.getScore()+10);
            }
        }
        vScore.setValue(user.getScore());

        return  b;

    }
    public void set_user_name (String name){
        user.setUser_name(name);
    }



}
