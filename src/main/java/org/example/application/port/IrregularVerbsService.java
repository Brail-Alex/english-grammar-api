package org.example.application.port;

import org.example.domain.IrregularVerb;

import java.util.List;

public interface IrregularVerbsService {
    List<IrregularVerb> getAll();
}
