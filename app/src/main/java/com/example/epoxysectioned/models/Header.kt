package com.example.epoxysectioned.models


data class Header(val title:String, val id: Int = globalId.getAndIncrement())