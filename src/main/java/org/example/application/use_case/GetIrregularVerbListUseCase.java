package org.example.application.use_case;

import lombok.Value;
import org.example.domain.IrregularVerb;

import java.util.List;

public class GetIrregularVerbListUseCase extends UseCase<GetIrregularVerbListUseCase.InputValues, GetIrregularVerbListUseCase.OutputValues>{

    @Override
    public OutputValues execute(InputValues inputValues) {
        return null;
    }
    @Value
    public static class InputValues implements UseCase.InputValues{}
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        List<IrregularVerb> irregularVerbs;
    }
}
