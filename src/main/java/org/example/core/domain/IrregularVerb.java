package org.example.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IrregularVerb {

    private Long id;
    private String translation;
    private String v1;
    private String v2;
    private String v3;

}
