package org.example.presenter.controller.irregular_verb;

import org.example.core.domain.IrregularVerb;
import org.example.presenter.entities.VariantTargetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/irregular_verb")
public interface IrregularVerbResource {

    @GetMapping
    CompletableFuture<List<IrregularVerb>> getAllIrregularVerbs();

    @GetMapping("/variant")
    CompletableFuture<VariantTargetResponse> getRandomVariantTarget();
}
