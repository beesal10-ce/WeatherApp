package firstapp.weatherapp.work_manager

import android.content.Context
import android.content.Intent
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import firstapp.weatherapp.NotificationService


class GetWeatherDataWorker(
    private val context: Context,
    private val workerParameters: WorkerParameters,

    ) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val intent = Intent(context, NotificationService::class.java)
        context.startService(intent)
        return Result.retry()
    }
}