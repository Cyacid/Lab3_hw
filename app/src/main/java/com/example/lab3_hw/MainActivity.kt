package com.example.lab3_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name : EditText = findViewById(R.id.ed_name)
        var tv_text : TextView = findViewById(R.id.tv_text)
        var tv_name : TextView = findViewById(R.id.tv_name)
        var tv_won : TextView = findViewById(R.id.tv_won)
        var tv_cd : TextView = findViewById(R.id.tv_cd)
        var tv_pd : TextView = findViewById(R.id.tv_pd)
        var btn_sci : RadioButton = findViewById(R.id.btn_sci)
        var btn_rock : RadioButton = findViewById(R.id.btn_rock)
        var btn_paper : RadioButton = findViewById(R.id.btn_paper)
        var btn_do : Button = findViewById(R.id.btn_do)
        tv_text.setText("請輸入玩家姓名!")
        btn_do.setOnClickListener(View.OnClickListener {
            if(ed_name.length()<1){
                tv_text.setText("請輸入玩家姓名!")
            }
            else{
                tv_name.setText(String.format("名字\n%s",ed_name.getText().toString()))
                if(btn_sci.isChecked()){
                    tv_pd.setText("我方出拳\n剪刀")
                }
                else if(btn_rock.isChecked()){
                    tv_pd.setText("我方出拳\n石頭")
                }
                else if(btn_paper.isChecked()){
                    tv_pd.setText("我方出拳\n布")
                }
                var com : Int? =(Math.random()*3).toInt()

                if(com==0){
                    tv_cd.setText("電腦出拳\n剪刀")
                }
                else if(com==1){
                    tv_cd.setText("電腦出拳\n石頭")
                }
                else if(com==2){
                    tv_cd.setText("電腦出拳\n布")
                }

                if((btn_sci.isChecked() && com==2)||(btn_paper.isChecked() && com==1)||(btn_rock.isChecked() && com==0)){
                    tv_won.setText("勝利者\n"+ed_name.getText().toString())
                    tv_text.setText("恭喜獲勝!")
                }
                else if((btn_sci.isChecked() && com==1)||(btn_paper.isChecked() && com==0)||(btn_rock.isChecked() && com==2)){
                    tv_won.setText("勝利者\n電腦")
                    tv_text.setText("可惜，電腦獲勝!")
                }
                else if((btn_sci.isChecked() && com==0)||(btn_paper.isChecked() && com==2)||(btn_rock.isChecked() && com==1)){
                    tv_won.setText("勝利者\n平手")
                    tv_text.setText("平局，再一局!")
                }
            }
        })
    }
}
