package com.scriptintech.unitconverterx.repository

data class UnitResult (
    val from: String,
    val data: List<Result>
)

data class Result (
    val title: String,
    val unit: String,
    val value: String
)