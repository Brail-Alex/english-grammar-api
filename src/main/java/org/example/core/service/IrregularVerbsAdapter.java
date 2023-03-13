package org.example.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.core.application.port.IrregularVerbsService;
import org.example.core.domain.IrregularVerb;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    public IrregularVerb getIrregularVerbById(Short id) {
        return irregularVerbs.get(id);
    }

    @Override
    public String[] getRandomVariantAndTarget() {

        IrregularVerb irregularVerb = irregularVerbs.get(getRandomNumberFromZero((short) (irregularVerbs.size() - 1)));

        short variantFieldIndex = getRandomNumberFromZero((short) 3);
        short targetFieldIndex = getRandomNumberFromZero((short) 3);

        while (variantFieldIndex == targetFieldIndex) {
            targetFieldIndex = getRandomNumberFromZero((short) 3);
        }

        String variant = "";
        String target = "";
        String id = String.valueOf(irregularVerb.getId());

        switch (variantFieldIndex) {
            case (0):
                variant = irregularVerb.getTranslation();
                break;
            case (1):
                variant = irregularVerb.getV1();
                break;
            case (2):
                variant = irregularVerb.getV2();
                break;
            case (3):
                variant = irregularVerb.getV3();
                break;
        }

        switch (targetFieldIndex) {
            case (0):
                target = "translation";
                break;
            case (1):
                target = "V1";
                break;
            case (2):
                target = "V2";
                break;
            case (3):
                target = "V3";
                break;
        }

        String variantTarget[] = new String[]{id, variant, target};

        return variantTarget;
    }

    @Override
    public Boolean isTargetEqualsToAnswer(Short id, String target, String answer) {
        IrregularVerb irregularVerb = irregularVerbs.get(id);
        String targetValue = "";
        switch (target) {
            case ("translation"):
                targetValue = irregularVerb.getTranslation();
                break;
            case ("V1"):
                targetValue = irregularVerb.getV1();
                break;
            case ("V2"):
                targetValue = irregularVerb.getV2();
                break;
            case ("V3"):
                targetValue = irregularVerb.getV3();
                break;
        }

        return Objects.equals(answer, targetValue);
    }

    private Short getRandomNumberFromZero(short to) {
        return (short) (Math.random() * to);
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
