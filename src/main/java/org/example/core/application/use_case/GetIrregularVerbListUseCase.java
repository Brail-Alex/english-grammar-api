package org.example.core.application.use_case;

import lombok.Value;
import org.example.core.application.port.IrregularVerbsService;
import org.example.core.domain.IrregularVerb;

import java.util.List;

public class GetIrregularVerbListUseCase extends UseCase<GetIrregularVerbListUseCase.InputValues, GetIrregularVerbListUseCase.OutputValues>{

    private final IrregularVerbsService irregularVerbsService;

    public GetIrregularVerbListUseCase(IrregularVerbsService irregularVerbsService) {
        this.irregularVerbsService = irregularVerbsService;
    }

    @Override
    public OutputValues execute(InputValues inputValues) {

        return new OutputValues(irregularVerbsService.getAll());
    }

    @Value
    public static class InputValues implements UseCase.InputValues{}
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        List<IrregularVerb> irregularVerbs;
    }

}
