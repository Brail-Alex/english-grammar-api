package org.example.presenter.controller.irregular_verb;

import org.example.core.application.use_case.*;
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
    @Autowired
    PostAnswerAtCompareUseCase postAnswerAtCompareUseCase;
    @Autowired
    GetIrregularVerbByIdUseCase getIrregularVerbByIdUseCase;

    @Override
    public CompletableFuture<IrregularVerb> getIrregularVerbById(Short id) {
        return useCaseExecutor.execute(getIrregularVerbByIdUseCase,
                new GetIrregularVerbByIdUseCase.InputValues(id),
                GetIrregularVerbByIdUseCase.OutputValues::getIrregularVerb);
    }


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

    @Override
    public CompletableFuture<Boolean> postAnswerAtCompare(Short id, String target, String answer) {
        return useCaseExecutor.execute(postAnswerAtCompareUseCase,
                new PostAnswerAtCompareUseCase.InputValues(id, target, answer),
                PostAnswerAtCompareUseCase.OutputValues::getTargetEqualsToAnswer);
    }
}
