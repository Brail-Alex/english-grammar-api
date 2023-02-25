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

    @Override
    public List<IrregularVerb> getAll() {
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
