package org.example.presentor.use_case;

import org.example.core.application.use_case.UseCase;
import org.example.core.application.use_case.UseCaseExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor {

    @Override
    public <Result, Input extends UseCase.InputValues, Output extends UseCase.OutputValues>
    CompletableFuture<Result> execute(UseCase<Input, Output> useCase,
                                      Input input,
                                      Function<Output, Result> outputMapper) {
        return CompletableFuture.supplyAsync(() -> input).thenApplyAsync(useCase::execute).thenApplyAsync(outputMapper);
    }
}
