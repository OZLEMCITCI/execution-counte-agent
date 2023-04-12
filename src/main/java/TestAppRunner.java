import java.io.IOException;

public class TestAppRunner {
    public static void main(String[] args) throws IOException {
        // Call the main method of the class with the provided arguments
        Calculator.main(args);

        // Print the execution counts collected by the ExecutionCounterAdvice class
        com.example.executioncounteragent.ExecutionCounterAdvice.printExecutionCounts();
    }

    //java -javaagent:build/libs/ExecutionCounterAgent.jar -cp src/main/java TestAppRunner

//    java: The command to start the Java Virtual Machine (JVM).
//    javaagent:build/libs/ExecutionCounterAgent.jar: This flag indicates that you want to use the ExecutionCounterAgent.jar as a Java agent. It is located in the build/libs directory.
//    cp src/main/java: This flag sets the classpath for your Java application. It tells the JVM where to look for your classes, in this case, the src/main/java directory.
//    TestAppRunner: This is the main class of your application that the JVM should run.
}

