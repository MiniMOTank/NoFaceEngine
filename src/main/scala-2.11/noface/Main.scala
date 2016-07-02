package noface

import java.nio.ByteBuffer

import lorance.rxscoket.session
import lorance.rxscoket.session.{ServerEntrance, ConnectedSocket}
import rx.lang.scala.Observable
import lorance.rxscoket.session.implicitpkg._
import lorance.rxscoket.session.enCode

/**
  *
  */
object Main extends App {
  //forbid heart beat
  session.Configration.SEND_HEART_BEAT_BREAKTIME = 3600 * 24 * 365
  session.Configration.CHECK_HEART_BEAT_BREAKTIME = 3600 * 24 * 365

  val server = new ServerEntrance("127.0.0.1", 10127)
  val socket: Observable[ConnectedSocket] = server.listen
  val read = socket.map(l => (l, l.startReading))

  read.subscribe{ x =>
    x._2.subscribe{ y =>
      println("result - " + y.loaded.allToString)
      val bts = enCode(2.toByte, "hi client!")
      val bts2 = enCode(2.toByte, "测试!")
      val bts3 = enCode(2.toByte, "北京,你好!")
      val byteBuf = ByteBuffer.wrap(bts ++ bts2 ++ bts3)
      val byteBuf2 = ByteBuffer.wrap(bts ++ bts2 ++ bts3)
      x._1.send(byteBuf)

      Thread.sleep(5000)

      x._1.send(byteBuf2)
    }
  }

  Thread.currentThread().join()
}
