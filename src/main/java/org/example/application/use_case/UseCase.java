package org.example.application.use_case;

public abstract class UseCase <Input extends UseCase.InputValues, Output extends UseCase.OutputValues> {
    public abstract Output execute (Input input);

    public interface InputValues {
    }

    public interface OutputValues {
    }
}
