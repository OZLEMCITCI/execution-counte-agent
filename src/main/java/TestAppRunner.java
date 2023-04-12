import java.io.IOException;

public class TestAppRunner {
    public static void main(String[] args) throws IOException {
        Calculator.main(args);

        // Print the execution counts
        com.example.executioncounteragent.ExecutionCounterAdvice.printExecutionCounts();
    }
}

