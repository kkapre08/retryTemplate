package com.example.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    @Retryable(maxAttempts=9,value=IllegalAccessException.class,backoff=@Backoff(delay = 2000))
    public void retry() throws IllegalAccessException {
        System.out.println("retry logic\n");
        throw new IllegalAccessException();
    }
}
