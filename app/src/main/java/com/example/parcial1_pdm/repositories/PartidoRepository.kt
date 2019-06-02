package com.example.parcial1_pdm.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.parcial1_pdm.dao.EquipoDao
import com.example.parcial1_pdm.dao.PartidoDao
import com.example.parcial1_pdm.pojos.Equipo
import com.example.parcial1_pdm.pojos.Partido

class PartidoRepository(
    private val PartidoDao: PartidoDao
    //private val EquipoDao: EquipoDao
){

    val allPartidos: LiveData<List<Partido>> = PartidoDao.getAllPartidos()
    //val allEquipos: LiveData<List<Equipo>> = EquipoDao.getAllEquipos()

    @WorkerThread
    suspend fun insertPartido(Partido: Partido) {
        PartidoDao.insert(Partido)
    }
    /*
    @WorkerThread
    suspend fun insertEquipo(Equipo: Equipo) {
        EquipoDao.insert(Equipo)
    }
    */
}