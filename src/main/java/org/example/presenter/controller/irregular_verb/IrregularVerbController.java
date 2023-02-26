package org.example.presenter.controller.irregular_verb;

import org.example.core.application.use_case.GetIrregularVerbListUseCase;
import org.example.core.application.use_case.UseCaseExecutor;
import org.example.core.domain.IrregularVerb;
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

    @Override
    public CompletableFuture<List<IrregularVerb>> getAllIrregularVerbs() {
        return useCaseExecutor.execute(getIrregularVerbListUseCase,
                new GetIrregularVerbListUseCase.InputValues(),
                GetIrregularVerbListUseCase.OutputValues::getIrregularVerbs);

    }
}
