package org.example.core.application.port;

import org.example.core.domain.IrregularVerb;

import java.util.List;

public interface IrregularVerbsService {
    List<IrregularVerb> getAll();
    String[] getRandomVariantAndTarget();
}
