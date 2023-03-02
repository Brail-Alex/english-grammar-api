package org.example.core.application.use_case;

import lombok.Value;
import org.example.core.application.port.IrregularVerbsService;

public class GetRandomIrregularVerbUseCase extends UseCase<GetRandomIrregularVerbUseCase.InputValues, GetRandomIrregularVerbUseCase.OutputValues> {

    private final IrregularVerbsService irregularVerbsService;

    public GetRandomIrregularVerbUseCase(IrregularVerbsService irregularVerbsService) {
        this.irregularVerbsService = irregularVerbsService;
    }

    @Override
    public OutputValues execute(InputValues inputValues) {

        String[] variantTarget = irregularVerbsService.getRandomVariantAndTarget();
        Short id = Short.valueOf(variantTarget[0]);
        String variant = variantTarget[1];
        String target = variantTarget[2];
        return new GetRandomIrregularVerbUseCase.OutputValues(id, variant, target);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Short id;
        String variant;
        String target;
    }
}
