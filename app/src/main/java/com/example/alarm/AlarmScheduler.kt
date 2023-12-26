package com.example.alarm

import java.time.LocalDateTime

interface AlarmScheduler {
    fun schedule(item:LocalDateTime)
    fun cancel(item:LocalDateTime)
}