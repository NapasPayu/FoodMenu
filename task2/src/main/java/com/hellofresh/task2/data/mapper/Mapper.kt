package com.hellofresh.task2.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
}