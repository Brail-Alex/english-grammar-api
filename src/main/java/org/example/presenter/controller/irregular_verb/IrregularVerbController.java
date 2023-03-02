package org.example.presenter.controller.irregular_verb;

import org.example.core.application.use_case.GetIrregularVerbListUseCase;
import org.example.core.application.use_case.GetRandomIrregularVerbUseCase;
import org.example.core.application.use_case.UseCaseExecutor;
import org.example.core.domain.IrregularVerb;
import org.example.presenter.model.VariantTargetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class IrregularVerbController implements IrregularVerbResource {
    @Autowired
    private UseCaseExecutor useCaseExecutor;
    @Autowired
    private GetIrregularVerbListUseCase getIrregularVerbListUseCase;
    @Autowired
    GetRandomIrregularVerbUseCase getRandomIrregularVerbUseCase;

    @Override
    public CompletableFuture<List<IrregularVerb>> getAllIrregularVerbs() {
        return useCaseExecutor.execute(getIrregularVerbListUseCase,
                new GetIrregularVerbListUseCase.InputValues(),
                GetIrregularVerbListUseCase.OutputValues::getIrregularVerbs);
    }

    @Override
    public CompletableFuture<VariantTargetResponse> getRandomVariantTarget() {
        return useCaseExecutor.execute(getRandomIrregularVerbUseCase,
                new GetRandomIrregularVerbUseCase.InputValues(),
                (outputValues) -> new VariantTargetResponse(outputValues.getId(), outputValues.getVariant(), outputValues.getTarget())
                );
    }
}
