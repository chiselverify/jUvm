# jUvm: Verification of digital circuits in Java and Scala

This repository investigates how to test and verify digital circuits in Java, a modern, statically typed language.
Furthermore, we also want Scala bindings.
It shall replace the cocotb/PyUVM simulation environment.

## Steps

 * [ ] Start as simple as possible: peek/poke with `BigInt` in Java
   - Just three functions are needed: `poke()`, `peek()`, and `step()`
 * [ ] Maybe start with a dummy backend, e.g., some Java class representing HW
 * [ ] Use the simplest backend possible
 * [ ] Explore Scala features
 * [ ] Read on SW testing

## To Explore

 * Checkout Scala based drivers for Verilator
   - New driver in the Chisel library
   - Simulator from SpineHDL
   - Old driver from ChiselTest
 * What shall the API be?
 * Concurrency: Java Ruannble, ChiselTest fork, some coroutine syntax?
   - For performance reasons, we would like real coroutines (not simulating them with threads)
   - Singel threaded tests shall not have any overhead (SpinalHDL has a notion of callback)

## Questions

 * Shall we start with Scala 3?
 * Maybe a fake HDL for getting started quickly
 * Can we use functional programming to make testing nicer? E.g. as in the follwing ScalaTest example:
```Scala
val xs = 1 to 3
val it = xs.iterator
eventually { it.next() shouldBe 3 }
```

## TODO

 * Explore cocotb and PyUVM
 * UVM in Java? It is industry standard, but do we like it?
 * Find a better abstraction than UVM
 * Can we learn from SW testing?
 * What else is out in the field (related work)?
 * We shall have a ChiselTest compatible API for the transition from Chisel 5/6
 * A better name, I don't like jUvm

## Issues

 * We cannot mix Scala 3 and Chisel (Scala 2)
   - It is possible according to Scala 3 documentation, but macros/compiler plugin might give us troubles
 * We can use Chisel types, but we cannot compute with them, or assign new values

## Annoying Stuff in ChiselTest

 * I want to test different implementations with the same test. Following does not work:
```Scala
  val rfs = List(Module(new RegisterFile()), Module(new RegisterFile2()))

for (rf <- rfs) {
   "RegisterFile" should "pass" in {
      test(rf) {
         d => {
```