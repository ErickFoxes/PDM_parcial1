package com.example.parcial1_pdm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.parcial1_pdm.dao.EquipoDao
import com.example.parcial1_pdm.dao.PartidoDao
import com.example.parcial1_pdm.pojos.Equipo
import com.example.parcial1_pdm.pojos.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(
        Partido::class,
        Equipo::class
    ), version = 2
)

public abstract class PartidosRoomDatabase : RoomDatabase() {
    abstract fun PartidoDao(): PartidoDao
    //abstract fun EquipoDao(): EquipoDao

    companion object {
        @Volatile
        private var INSTANCE: PartidosRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): PartidosRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidosRoomDatabase::class.java,
                    "Partidos_Database"
                ).fallbackToDestructiveMigration()
                    .addCallback(PartidoDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }

        private class PartidoDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(
                            database.PartidoDao()
                            //database.EquipoDao()
                        )
                    }
                }
            }
        }

        suspend fun populateDatabase(
            PartidoDao: PartidoDao
            //EquipoDao: EquipoDao
        ) {

            //authorDao.deleteAll()
            //bookDao.deleteAll()
            //publisherDao.deleteAll()

            //var eq1 = Equipo(0, "España")
            //EquipoDao.insert(eq1)

            //var eq2 = Equipo(1, "El Salvador")
            //EquipoDao.insert(eq2)

            var par = Partido(0, "10/20/2018", "2:00", "España", 1, "El salvador", 5)
            PartidoDao.insert(par)

        }
    }
}