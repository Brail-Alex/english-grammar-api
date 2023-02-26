package org.example.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.core.application.port.IrregularVerbsService;
import org.example.core.domain.IrregularVerb;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class IrregularVerbsAdapter implements IrregularVerbsService {
    private final String FILE_NAME = "irregular_verbs.json";
    private final List<IrregularVerb> irregularVerbs;

    public IrregularVerbsAdapter() {
        irregularVerbs = readIrregularVerbsFromFile();
    }

    @Override
    public List<IrregularVerb> getAll() {

        return irregularVerbs;
    }

    @Override
    public IrregularVerb getRandom() {
        short index = (short) (Math.random() * (irregularVerbs.size() - 1));

        return irregularVerbs.get(index);
    }

    private List<IrregularVerb> readIrregularVerbsFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = Paths.get(FILE_NAME).toFile();
            List<IrregularVerb> irregularVerbs = Arrays.asList(mapper.readValue(file, IrregularVerb[].class));
            return irregularVerbs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
