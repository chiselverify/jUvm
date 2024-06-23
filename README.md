# jUvm: Verification of digital circuits in Java and Scala

This repository investigates how to test and verify digital circuits in Java, a modern, statically typed language.
Furthermore, we also want Scala bindings.
It shall replace the cocotb/PyUVM simulation environment. 

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
 * We can use Chisel types, but we cannot compute with them, or assign new values