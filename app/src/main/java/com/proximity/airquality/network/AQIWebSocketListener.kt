package com.proximity.airquality.network

import kotlinx.coroutines.channels.Channel
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class AQIWebSocketListener : WebSocketListener() {

    val socketEventChannel: Channel<SocketUpdate> = Channel(10)
    override fun onOpen(webSocket: WebSocket, response: Response) {
        //   webSocket.send("What's up ?");
        //  webSocket.send(ByteString.decodeHex("abcd"));
        //   webSocket.close(CLOSE_STATUS, "Socket Closed !!");
    }

    override fun onMessage(webSocket: WebSocket, message: String) {
        print("Receive Message: $message")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        print("Receive Bytes : " + bytes.hex())
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(CLOSE_STATUS, null)
        print("Closing Socket : $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket, throwable: Throwable, response: Response?) {
        print("Error : " + throwable.message)
    }

    companion object {
        private const val CLOSE_STATUS = 1000
    }

    class SocketAbortedException : Exception()


}