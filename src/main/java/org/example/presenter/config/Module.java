package org.example.presenter.config;

import org.example.core.application.port.IrregularVerbsService;
import org.example.core.application.use_case.GetIrregularVerbByIdUseCase;
import org.example.core.application.use_case.GetIrregularVerbListUseCase;
import org.example.core.application.use_case.GetRandomIrregularVerbUseCase;
import org.example.core.application.use_case.PostAnswerAtCompareUseCase;
import org.example.core.service.IrregularVerbsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {

    @Bean
    public IrregularVerbsService irregularVerbsService() {
        return new IrregularVerbsAdapter();
    }

    @Bean
    public GetIrregularVerbListUseCase getIrregularVerbListUseCase(IrregularVerbsService irregularVerbsService) {
        return new GetIrregularVerbListUseCase(irregularVerbsService);
    }

    @Bean
    public GetRandomIrregularVerbUseCase getRandomIrregularVerbUseCase(IrregularVerbsService irregularVerbsService) {
        return new GetRandomIrregularVerbUseCase(irregularVerbsService);
    }

    @Bean
    public PostAnswerAtCompareUseCase postAnswerAtCompareUseCase(IrregularVerbsService irregularVerbsService) {
        return new PostAnswerAtCompareUseCase(irregularVerbsService);
    }

    @Bean
    public GetIrregularVerbByIdUseCase getIrregularVerbByIdUseCase(IrregularVerbsService irregularVerbsService) {
        return new GetIrregularVerbByIdUseCase(irregularVerbsService);
    }
}
