package com.example.alarm

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarm.ui.theme.AlarmTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scheduler = AndroidAlarmScheduler(context = this)
        setContent {
            AlarmTheme {
                var secondsText by remember {
                    mutableStateOf("No Alarm")
                }
                var alarmTime: LocalDateTime? by remember {
                    mutableStateOf(null)
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = secondsText,
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            alarmTime = LocalDateTime.now().plusSeconds(10)
                            secondsText = LocalDateTime.now().toString()
                            alarmTime?.let {
                                scheduler.schedule(item = it)
                            }
                        }) {
                            Text(text = "Set Alarm")
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {
                            print("Cancelled Alarm ${LocalDateTime.now()}")
                            alarmTime?.let {
                                scheduler.cancel(item = it)
                                secondsText = ""
                                alarmTime = null
                            }
                        }) {
                            Text(text = "Cancel Alarm")
                        }
                    }
                }
            }
        }
    }
}