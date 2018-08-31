package app.tracklive.tracklivedroid

class BroadcastService: Runnable {
    public override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}