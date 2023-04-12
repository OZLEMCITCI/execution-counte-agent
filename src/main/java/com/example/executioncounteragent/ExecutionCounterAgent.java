package com.example.executioncounteragent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class ExecutionCounterAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any()
                        .and(ElementMatchers.not(ElementMatchers.named("com.example.executioncounteragent.ExecutionCounterAdvice")))
                        .and(ElementMatchers.not(ElementMatchers.named("com.example.executioncounteragent.ExecutionCounterAgent")))
                )
                .transform((builder, typeDescription, classLoader, javaModule) ->
                        builder.visit(Advice.to(ExecutionCounterAdvice.class).on(ElementMatchers.any()))
                )
                .installOn(instrumentation);
    }
}
