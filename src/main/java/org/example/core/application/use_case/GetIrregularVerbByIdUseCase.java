package org.example.core.application.use_case;

import lombok.Value;
import org.example.core.application.port.IrregularVerbsService;
import org.example.core.domain.IrregularVerb;

import java.util.List;

public class GetIrregularVerbByIdUseCase extends UseCase<GetIrregularVerbByIdUseCase.InputValues, GetIrregularVerbByIdUseCase.OutputValues> {

    private final IrregularVerbsService irregularVerbsService;

    public GetIrregularVerbByIdUseCase(IrregularVerbsService irregularVerbsService) {
        this.irregularVerbsService = irregularVerbsService;
    }

    @Override
    public OutputValues execute(InputValues inputValues) {
        return new OutputValues(irregularVerbsService.getIrregularVerbById(inputValues.id));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        Short id;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        IrregularVerb irregularVerb;
    }

}
