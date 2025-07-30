package qucoon.mod.SpringServerless.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.model.entity.User;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncUserService {

    @Async  // This method will run asynchronously in a separate thread
    public CompletableFuture<String> createUserAsync(User user) {
        // Simulate a long-running task (e.g., database operation or external API call)
        try {
            // Implement Business Logic here
            Thread.sleep(2000);  // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture("Task interrupted");
        }
        // After processing, return the result wrapped in a CompletableFuture
        return CompletableFuture.completedFuture("User created successfully");
    }
}
