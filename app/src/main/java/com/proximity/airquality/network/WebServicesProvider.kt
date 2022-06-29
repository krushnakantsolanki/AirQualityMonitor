package com.proximity.airquality.network

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit

class WebServicesProvider {

    private var _webSocket: WebSocket? = null

    private val socketOkHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(39, TimeUnit.SECONDS)
        .hostnameVerifier { _, _ -> true }
        .build()

    @ExperimentalCoroutinesApi
    private var _webSocketListener: AQIWebSocketListener? = null

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> =
        with(AQIWebSocketListener()) {
            startSocket(this)
            this@with.socketEventChannel
        }

    @ExperimentalCoroutinesApi
    fun startSocket(webSocketListener: AQIWebSocketListener) {
        _webSocketListener = webSocketListener
        _webSocket = socketOkHttpClient.newWebSocket(
            Request.Builder().url("ws://city-ws.herokuapp.com/").build(),
            webSocketListener
        )
        socketOkHttpClient.dispatcher.executorService.shutdown()
    }

    @ExperimentalCoroutinesApi
    fun stopSocket() {
        try {
            _webSocket?.close(NORMAL_CLOSURE_STATUS, null)
            _webSocket = null
            _webSocketListener?.socketEventChannel?.close()
            _webSocketListener = null
        } catch (ex: Exception) {
        }
    }

    companion object {
        const val NORMAL_CLOSURE_STATUS = 1000
    }

}