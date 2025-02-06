package com.example.extendedlottery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.extendedlottery.ui.theme.ExtendedLotteryTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    var numberOfClicks=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GUI()
        }
    }
    @Composable
    fun GUI(){

        var resultsArray by remember{mutableStateOf(mutableListOf(0,0,0,0,0,0))}
        var number1 by remember{ mutableStateOf(0) }
        var number2 by remember{ mutableStateOf(0) }
        var number3 by remember{ mutableStateOf(0) }
        var number4 by remember{ mutableStateOf(0) }
        var number5 by remember{ mutableStateOf(0) }
        var number6 by remember{ mutableStateOf(0) }

        number1=resultsArray[0];
        number2=resultsArray[1];
        number3=resultsArray[2];
        number4=resultsArray[3];
        number5=resultsArray[4];
        number6=resultsArray[5];

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(){
                Text("Results = ", fontSize = 25.sp)
                Text(""+number1,fontSize=26.sp)
                Text(" "+number2, fontSize = 26.sp)
                Text(" "+number3, fontSize = 26.sp)
                Text(" "+number4, fontSize = 26.sp)
                Text(" "+number5, fontSize = 26.sp)
                Text(" "+number6, fontSize = 26.sp)
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick = {resultsArray = calculate()}){
                    Text("Generate", fontSize = 26.sp)
                }
                Spacer(Modifier.width(20.dp))
                Button(onClick = {resultsArray = sort(resultsArray)}){
                    Text("Sort", fontSize = 26.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick = {
                    var newNumber = Random.nextInt(1,60);
                    while(newNumber in  resultsArray){
                        newNumber = Random.nextInt(1,60);
                    }
                    resultsArray[0]=newNumber;
                    number1 = newNumber
                }) {
                    Text("Change the first number",fontSize=16.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick={
                    var newNumber = Random.nextInt(1,60);
                    while(newNumber in resultsArray){
                        newNumber = Random.nextInt(1,60);
                    }
                    resultsArray[1] = newNumber;
                    number2 = newNumber;
                }){
                    Text("Change the second number",fontSize=16.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick={
                    var newNumber = Random.nextInt(1,60);
                    while(newNumber in resultsArray){
                        newNumber = Random.nextInt(1,60);
                    }
                    resultsArray[2]=newNumber;
                    number3 = newNumber;
                }){
                    Text("Change the third number",fontSize=16.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick = {
                    var newNumber = Random.nextInt(1,60);
                    while(newNumber in resultsArray){
                        newNumber = Random.nextInt(1,60);
                    }

                    resultsArray[3] = newNumber;
                    number4 = newNumber
                }){
                    Text("Change the fourth number", fontSize = 16.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick={
                    var newNumber = Random.nextInt(1,60);
                    while(newNumber in resultsArray){
                        newNumber = Random.nextInt(1,60);
                    }
                    resultsArray[4] = newNumber;
                    number5 = newNumber
                }){
                    Text("Change the fifth number",fontSize=16.sp)
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(){
                Button(onClick = {
                    var newNumber = Random.nextInt(1,60)
                    while(newNumber in resultsArray){
                        newNumber = Random.nextInt(1,60)
                    }
                    resultsArray[5]=newNumber;
                    number6 = newNumber;
                }){
                    Text("Change the sixth number",fontSize=16.sp)
                }
            }
        }
    }

    fun calculate():MutableList<Int>{
        var numberList= mutableListOf<Int>();

        while(numberList.size < 6){
            var number = Random.nextInt(1,60);
            if(number !in numberList){
                numberList.add(number);
            }
        }
        return numberList;
    }

    fun sort(result:MutableList<Int>):MutableList<Int>{
        numberOfClicks+=1;

        var newList = result.toMutableList();

        if(numberOfClicks % 2==1){
            newList.sort();
        }
        else{
            newList.sort();
            newList.reverse();
        }
        return newList;
    }
}