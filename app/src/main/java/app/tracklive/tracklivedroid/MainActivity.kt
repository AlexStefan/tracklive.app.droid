package app.tracklive.tracklivedroid

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var broadcastService = BroadcastService()
    private var broadcastRunning = false
    private lateinit var thread : Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button.setOnClickListener{ _ ->
            if (!broadcastRunning) {
                thread = Thread(broadcastService)
                thread.start()
                broadcastRunning = true
                button.text = resources.getString(R.string.stop_broadcast)
            } else {
                thread.interrupt()
                broadcastRunning = false
                button.text = resources.getString(R.string.start_broadcast)
            }
        };

        fab.setOnClickListener { view ->
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

}
