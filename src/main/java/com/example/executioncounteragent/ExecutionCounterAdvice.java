package com.example.executioncounteragent;


import net.bytebuddy.asm.Advice;
import java.util.concurrent.ConcurrentHashMap;


public class ExecutionCounterAdvice {
    public static final ConcurrentHashMap<String, Integer> statementCounter = new ConcurrentHashMap<>();

    @Advice.OnMethodEnter
    public static void onEnter(@Advice.Origin String methodSignature) {
        statementCounter.compute(methodSignature, ExecutionCounterAdvice::increment);
    }

    public static void printExecutionCounts() {
        System.out.println("hello");
        statementCounter.forEach((k, v) -> System.out.println("Statement: " + k + " - Executions: " + v));
    }

    public static ConcurrentHashMap<String, Integer> getStatementCounter() {
        return statementCounter;
    }

    public static Integer increment(String k, Integer v) {
        return v == null ? 1 : v + 1;
    }
}
