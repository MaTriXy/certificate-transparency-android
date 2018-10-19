/*
 * Copyright 2018 Babylon Healthcare Services Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.certificatetransparency.ctlog

import okhttp3.OkHttpClient
import org.certificatetransparency.ctlog.internal.logclient.HttpLogClient
import org.certificatetransparency.ctlog.internal.logclient.LogClientService
import org.certificatetransparency.ctlog.logclient.LogClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LogClientFactory {
    fun create(baseUrl: String): LogClient {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder().client(client).addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
        val logClientService = retrofit.create(LogClientService::class.java)

        return HttpLogClient(logClientService)
    }
}
