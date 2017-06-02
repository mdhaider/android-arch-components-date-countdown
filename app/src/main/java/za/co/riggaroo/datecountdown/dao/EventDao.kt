package za.co.riggaroo.datecountdown.dao


import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import org.threeten.bp.LocalDateTime
import za.co.riggaroo.datecountdown.entity.Event

@Dao
interface EventDao {

    //kotlin does weird renaming of parameters.
    @Query("SELECT * FROM events WHERE date > :p0")
    fun getEvents(minDate: LocalDateTime): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEvent(event: Event)

    @Delete
    fun deleteEvent(event: Event)

    @Update(onConflict = REPLACE)
    fun updateEvent(event: Event)

}