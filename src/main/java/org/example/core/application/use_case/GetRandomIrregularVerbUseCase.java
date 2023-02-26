package org.example.core.application.use_case;

import lombok.Value;
import org.example.core.domain.IrregularVerb;

import java.util.List;

public class GetRandomIrregularVerbUseCase extends UseCase<GetRandomIrregularVerbUseCase.InputValues, GetRandomIrregularVerbUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues inputValues) {
        return null;

    }

    @Value
    public static class InputValues implements UseCase.InputValues {
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        short id;
        String target;
        String variant;
    }
}
