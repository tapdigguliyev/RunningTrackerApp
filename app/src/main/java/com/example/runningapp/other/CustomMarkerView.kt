package com.example.runningapp.other

import android.annotation.SuppressLint
import android.content.Context
import android.icu.util.Calendar
import android.widget.TextView
import com.example.runningapp.R
import com.example.runningapp.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ViewConstructor")
class CustomMarkerView(
    private val runs: List<Run>,
    context: Context,
    layoutId: Int
) : MarkerView(context, layoutId) {

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null) return

        val tvDate = findViewById<TextView>(R.id.tvRunDate)
        val tvDuration = findViewById<TextView>(R.id.tvDuration)
        val tvAvgSpeed = findViewById<TextView>(R.id.tvAvgSpeedInKmH)
        val tvDistance = findViewById<TextView>(R.id.tvDistanceInKm)
        val tvCaloriesBurned = findViewById<TextView>(R.id.tvCaloriesBurned)

        val curRunId = e.x.toInt()
        val run = runs[curRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        tvDate.text = dateFormat.format(calendar.time)

        val avgSpeed = "${run.avgSpeedInKMH}km/h"
        tvAvgSpeed.text = avgSpeed

        val distanceInKm = "${run.distanceInMeters / 1000f}km"
        tvDistance.text = distanceInKm

        val caloriesBurned = "${run.caloriesBurned}kCal"
        tvCaloriesBurned.text = caloriesBurned

        tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
    }
}