package com.example.parcial1_pdm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1_pdm.pojos.Partido

@Dao
interface PartidoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido)

    @Query("SELECT * FROM partido_table")
    fun getAllPartidos(): LiveData<List<Partido>>

}