package org.teknux.webapp

import io.netty.channel.Channel
import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.util.SelfSignedCertificate
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider
import org.glassfish.jersey.server.ResourceConfig
import org.slf4j.LoggerFactory
import javax.ws.rs.core.Application
import javax.ws.rs.core.UriBuilder

class App(private val config: Config = Config()) {

    private var server: Channel? = null

    fun start(join: Boolean) {
        val resourceConfig = ResourceConfig.forApplication(Application()).apply { packages("org.teknux.webapp.controller") }
        val uri = UriBuilder.fromUri(if (config.ssl) "https://0.0.0.0/" else "http://0.0.0.0/").port(config.port).build()

        server = NettyHttpContainerProvider.createHttp2Server(uri, resourceConfig, if (config.ssl) selfSignedCertificateContext() else null)
        Runtime.getRuntime().addShutdownHook(Thread(Runnable { server?.close() }))

        LOGGER.info("############## Server Up & Running (HTTP/2 enabled)! - Bound to ${uri.toURL()} ##############")
        if (join) Thread.currentThread().join()
    }

    fun stop() {
        server?.close()
        LOGGER.info("############## Server Stopped ##############")
    }

    private fun selfSignedCertificateContext(): SslContext {
        val ssc = SelfSignedCertificate()
        return SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build()
    }

    companion object {

        private val LOGGER = LoggerFactory.getLogger(App::class.java)

        private var app: App? = null

        @JvmStatic
        fun main(args: Array<String>) {
            start()
        }

        fun start() {
            app = App().apply { start(true) }
        }

        fun stop() = app?.stop()
    }

    class Config {
        var port: Int = (System.getProperty("port") ?: "8080").toInt()
        var ssl: Boolean = (System.getProperty("ssl") ?: "false").toBoolean()
    }
}