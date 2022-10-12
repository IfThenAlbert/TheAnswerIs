package com.fsc.theansweris

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get


class WelcomePage : AppCompatActivity() {

    // keep track on selected radio button
    var prevSelectedAnswer:Int=0

    // get the radio group
     lateinit var answerGroup:RadioGroup


    // store all the questions and answer (parallel array)
    val myQuestions = arrayOf("What is my name ?","My BCS prof is?","My day one best friend?","My friend on TIk TOk?"
    ,"Best Language?","Is Android better than Iphone?","What truck do you have ?")

    val myAnswers = arrayOf("Albert","Mohamad","Jonathan","Erin","KOTLIN","YES","TOYOTA")

    // keep track of user score
    var score:Int = 0
    lateinit var myStatusText:TextView

    // keep track on correct/user answer answer
    lateinit var correctAnswer:String
    lateinit var userAnswer:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        myStatusText = findViewById(R.id.txt_score)
        answerGroup = findViewById(R.id.btn_answer_group)
        answerGroup.setOnCheckedChangeListener { radioGroup, i ->
         var selected:RadioButton = findViewById(i)

            if(prevSelectedAnswer == 0) {
                prevSelectedAnswer = selected.id
            }else{
                var prevSelected:RadioButton = findViewById(prevSelectedAnswer)
                prevSelected.setBackgroundColor(Color.WHITE)
                prevSelectedAnswer = selected.id
            }
            selected.setBackgroundColor(Color.GREEN)
            userAnswer = selected.text.toString()
        }

        generateQuestion()

    }

    // event methods

    fun onSubmitAnswerClick(v:View) {
        if(userAnswer.equals(correctAnswer)) {
            generateQuestion()
            score += 5
            myStatusText.setText("$score")
        }else{
            Toast.makeText(applicationContext,"I'm sorry but\nThat is incorrect",Toast.LENGTH_SHORT).show()
        }
    }

    // preventing user from  going back using the device back button
    override fun onBackPressed() {

    }

    // non event method
    fun generateQuestion() {
        // get the view to output the question
        var txtQuestion:TextView = findViewById(R.id.txt_questioners)
        // this generates numbers between 0 and 6 both included
        var qanda:Int = (Math.random() * (6 -0 + 1)).toInt() + 0
        //output the question
        txtQuestion.setText(myQuestions[qanda])
        // get the correct answer based on the question
        correctAnswer = myAnswers[qanda]

        var correctPlace =  (Math.random() * (3 -0 + 1)).toInt() + 0

        for(i in 0..3) {
            var optionButton:RadioButton = answerGroup.getChildAt(i) as RadioButton
            if(i == correctPlace) {
                optionButton.setText(myAnswers[qanda])
            }else{
                var others = (Math.random() * (6 -0 + 1)).toInt() + 0
                while(myAnswers[qanda].equals(myAnswers[others])) {
                    others = (Math.random() * (6 -0 + 1)).toInt() + 0
                }
                optionButton.setText(myAnswers[others])
            }
        }
    }


}