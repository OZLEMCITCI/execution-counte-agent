package com.example.executioncounteragent;
import net.bytebuddy.asm.Advice;
import java.util.concurrent.ConcurrentHashMap;


public class ExecutionCounterAdvice {
    // ConcurrentHashMap to store method signatures and their execution counts
    public static final ConcurrentHashMap<String, Integer> statementCounter = new ConcurrentHashMap<>();


    // Update the execution count of the method by calling the 'increment' function
    @Advice.OnMethodEnter
    public static void onEnter(@Advice.Origin String methodSignature) {
        statementCounter.compute(methodSignature, ExecutionCounterAdvice::increment);
    }
    // Method to print the execution counts of all the instrumented methods
    public static void printExecutionCounts() {
        System.out.println("hello");
        statementCounter.forEach((k, v) -> System.out.println("Statement: " + k + " - Executions: " + v));
    }

    public static ConcurrentHashMap<String, Integer> getStatementCounter() {
        return statementCounter;
    }
    // Helper method to increment the execution count
    public static Integer increment(String k, Integer v) {
        // If the method signature is not in the ConcurrentHashMap, initialize the count to 1
        // Otherwise, increment the count by 1
        return v == null ? 1 : v + 1;
    }
}
