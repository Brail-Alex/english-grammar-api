package org.example.domain;

public class IrregularVerb {

    private Long id;
    private String translation;
    private String v1;
    private String v2;
    private String v3;

    public IrregularVerb() {
    }

    public IrregularVerb(Long id, String translation, String v1, String v2, String v3) {
        this.id = id;
        this.translation = translation;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Long getId() {
        return id;
    }

    public String getTranslation() {
        return translation;
    }

    public String getV1() {
        return v1;
    }

    public String getV2() {
        return v2;
    }

    public String getV3() {
        return v3;
    }
}
