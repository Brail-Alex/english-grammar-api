package org.example.core.application.port;

import org.example.core.application.use_case.PostAnswerAtCompareUseCase;
import org.example.core.domain.IrregularVerb;

import java.util.List;

public interface IrregularVerbsService {
    List<IrregularVerb> getAll();

    IrregularVerb getIrregularVerbById(Short id);

    String[] getRandomVariantAndTarget();

    Boolean isTargetEqualsToAnswer(Short id, String target, String answer);

}
