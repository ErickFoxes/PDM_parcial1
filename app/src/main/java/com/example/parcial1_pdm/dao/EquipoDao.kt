package com.example.parcial1_pdm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1_pdm.pojos.Equipo

@Dao
interface EquipoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(equipo: Equipo)

    @Query("SELECT * FROM equipo_table")
    fun getAllEquipos(): LiveData<List<Equipo>>

}