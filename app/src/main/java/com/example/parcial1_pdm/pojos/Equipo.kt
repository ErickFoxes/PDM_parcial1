package com.example.parcial1_pdm.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "equipo_table")
data class Equipo(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "Nombre")
    val name : String
)