package com.example.executioncounteragent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class ExecutionCounterAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        // Create a new AgentBuilder with the default configuration
        new AgentBuilder.Default()
                .type(ElementMatchers.any()
                        .and(ElementMatchers.not(ElementMatchers.named("com.example.executioncounteragent.ExecutionCounterAdvice")))
                        .and(ElementMatchers.not(ElementMatchers.named("com.example.executioncounteragent.ExecutionCounterAgent")))
                )
                // Transform the matched classes by applying the 'ExecutionCounterAdvice' to all methods in the class
                .transform((builder, typeDescription, classLoader, javaModule) ->
                        builder.visit(Advice.to(ExecutionCounterAdvice.class).on(ElementMatchers.any()))
                )
                // Install the agent on the provided instrumentation instance
                .installOn(instrumentation);
    }
}
