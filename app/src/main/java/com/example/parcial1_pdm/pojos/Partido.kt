package com.example.parcial1_pdm.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



data class Partido(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "Fecha")
    val Fecha: String,
    @ColumnInfo(name = "Hora")
    val Hora: String,
    @ColumnInfo(name = "Equipo1")
    val Equipo1: String,
    @ColumnInfo(name = "PtsEquipo1")
    val PtsEquipo1: Int,
    @ColumnInfo(name = "Equipo2")
    val Equipo2: String,
    @ColumnInfo(name = "PtsEquipo2")
    val ptsEquipo2: Int
)