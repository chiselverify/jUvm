import chisel3._
object CheckChisel extends App {
  println("Hello")
  val u = UInt(8.W)
  println(u)
  // u := 0.U
  val v = 0.U(4.W)
  println(v)
  val i = 10
  val w = i.U(4.W)
  println(w)
}