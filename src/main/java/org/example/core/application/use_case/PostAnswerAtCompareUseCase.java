package org.example.core.application.use_case;

import lombok.Value;
import org.example.core.application.port.IrregularVerbsService;

public class PostAnswerAtCompareUseCase extends UseCase<PostAnswerAtCompareUseCase.InputValues, PostAnswerAtCompareUseCase.OutputValues>{

    private final IrregularVerbsService irregularVerbsService;

    public PostAnswerAtCompareUseCase(IrregularVerbsService irregularVerbsService) {
        this.irregularVerbsService = irregularVerbsService;
    }

    @Override
    public OutputValues execute(InputValues inputValues) {
        return new OutputValues(irregularVerbsService.isTargetEqualsToAnswer(inputValues.id, inputValues.target, inputValues.answer));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Short id;
        String target;
        String answer;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
       Boolean targetEqualsToAnswer;
    }
}
