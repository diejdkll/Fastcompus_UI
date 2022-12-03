package com.example.androidui

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val backgroundTask = BackgroundAsyncTask(
            findViewById(R.id.progressBar),
            findViewById(R.id.progressBarText)
        )

        findViewById<TextView>(R.id.start).setOnClickListener {
            backgroundTask.execute()
        }

        findViewById<TextView>(R.id.stop).setOnClickListener {
            backgroundTask.cancel(true)
        }

        findViewById<TextView>(R.id.shot).setOnClickListener {
            Log.d("testt", "SHOT!!")
        }
    }
}

class BackgroundAsyncTask(
    val progressBar : ProgressBar,
    val progressText : TextView
):AsyncTask<Int, Int, Int>(){
    // Params, Progress, Result
    // params -> doInBackground에서 사용할 타입
    // Result -> onProgressUpdate에서 사용할 타입
    // progress -> onPostExecute에서 사용할 타입

    // deprecated -> 더 이상 사용을 권장하지 않는다
    // 코루틴 -> 멀티 태스킹, 동기/비동기 처리

    var percent : Int = 0
    override fun doInBackground(vararg p0: Int?): Int {
        while (isCancelled() == false){
            percent++
            if(percent > 100) break
            else{
                publishProgress(percent)
            }
            Thread.sleep(100)
        }
        return percent
    }

    override fun onPreExecute() {
        super.onPreExecute()
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        progressText.text = "작업이 완료되었습니다"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        progressBar.setProgress(values[0] ?: 0)
        progressText.text = "" + values[0] +"%"
    }

    override fun onCancelled() {
        super.onCancelled()
        progressBar.setProgress(0)
        progressText.text = "작업이 취소되었습니다"
    }
}