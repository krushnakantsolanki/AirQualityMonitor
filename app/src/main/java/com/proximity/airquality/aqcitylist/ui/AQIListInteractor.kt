package com.proximity.airquality.aqcitylist.ui

import com.proximity.airquality.network.SocketUpdate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel

class AQIListInteractor constructor(private val repository: AQIListRepository) {

    @ExperimentalCoroutinesApi
    fun stopSocket() {
        repository.closeSocket()
    }

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> = repository.startSocket()

}