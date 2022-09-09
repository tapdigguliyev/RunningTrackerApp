package com.example.runningapp.repositories

import com.example.runningapp.db.Run
import com.example.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val runDAO: RunDAO
) {

    suspend fun insertRun(run: Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getAllRunsOrderedByDate() = runDAO.getAllRunsOrderedByDate()

    fun getAllRunsOrderedByAvgSpeed() = runDAO.getAllRunsOrderedByAvgSpeed()

    fun getAllRunsOrderedByDistance() = runDAO.getAllRunsOrderedByDistance()

    fun getAllRunsOrderedByTimeInMillis() = runDAO.getAllRunsOrderedByTimeInMillis()

    fun getAllRunsOrderedByCaloriesBurned() = runDAO.getAllRunsOrderedByCaloriesBurned()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()

    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()
}