/**
 * iteration count: 10_000 (StringTesting.ITERATION_COUNT)
 *
 * ========================================
 * for-loop:
 * Execution time: 25742000 nano
 * Execution time: 25 millis
 *
 * StringBuilder loop:
 * Execution time: 1753292 nanos
 * Execution time: 1 millis
 *
 * StringList Reduce:
 * Execution time: 26590167 nanos
 * Execution time: 26 millis
 *
 * StringList Joining:
 * Execution time: 2567917 nanos
 * Execution time: 2 millis
 *
 * StringList Join:
 * Execution time: 1694750 nanos
 * Execution time: 1 millis
 *
 * ========================================
 * Concat with plus loop:
 * Execution time: 60834 nanos
 * Execution time: 0 millis
 *
 * Concat with StringBuilder loop:
 * Execution time: 2702833 nanos
 * Execution time: 2 millis
 *
 * Concat with plus and inner function loop:
 * Execution time: 210166 nanos
 * Execution time: 0 millis
 *
 * Length with plus loop:
 * Execution time: 171417 nanos
 * Execution time: 0 millis
 *
 * Length with StringBuilder loop:
 * Execution time: 1988542 nanos
 * Execution time: 1 millis
 *
 * ========================================
 * String.format:
 * Execution time: 9866167 nanos
 * Execution time: 9 millis
 *
 * String.formatted:
 * Execution time: 10715167 nanos
 * Execution time: 10 millis
 *
 * MessageFormat:
 * Execution time: 50556292 nanos
 * Execution time: 50 millis
 *
 * String Template:
 * I couldn't run templates with Java 25 and maven
 */
package dev.drf.prog.fun.str.testing;