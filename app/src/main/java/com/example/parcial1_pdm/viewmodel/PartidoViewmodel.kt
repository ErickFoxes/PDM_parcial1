package com.example.parcial1_pdm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial1_pdm.pojos.Equipo
import com.example.parcial1_pdm.pojos.Partido
import com.example.parcial1_pdm.repositories.PartidoRepository
import com.example.parcial1_pdm.room.PartidosRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewmodel(application: Application) : AndroidViewModel(application) {

    private val PartidoRepository: PartidoRepository
    val allPartidos: LiveData<List<Partido>>
    //val allEquipos: LiveData<List<Equipo>>

    init {
        val PartidoDao = PartidosRoomDatabase.getDatabase(application, viewModelScope).PartidoDao()
        //val EquipoDao = PartidosRoomDatabase.getDatabase(application, viewModelScope).EquipoDao()
        PartidoRepository = PartidoRepository(PartidoDao)

        allPartidos = PartidoRepository.allPartidos
       // allEquipos = PartidoRepository.allEquipos
    }

    fun insertPartido(Partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        PartidoRepository.insertPartido(Partido)
    }
    //fun insertEquipo(Equipo: Equipo) = viewModelScope.launch(Dispatchers.IO) {
     //   PartidoRepository.insertEquipo(Equipo)
    //}

    fun getAllPatidos():LiveData<List<Partido>> = allPartidos
    //fun getAllEquipos():LiveData<List<Equipo>> = allEquipos
}