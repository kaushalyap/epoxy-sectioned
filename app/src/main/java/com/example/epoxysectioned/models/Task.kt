package com.example.epoxysectioned.models

import java.util.concurrent.atomic.AtomicInteger

public val globalId = AtomicInteger(1)

data class Task(val name: String, val date: String, val id: Int = globalId.getAndIncrement())
