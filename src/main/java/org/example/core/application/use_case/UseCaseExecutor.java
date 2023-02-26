package org.example.core.application.use_case;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    <Result, Input extends UseCase.InputValues, Output extends UseCase.OutputValues>
    CompletableFuture<Result> execute(UseCase<Input, Output> useCase,
                                      Input input,
                                      Function<Output, Result> outputMapper);
}
