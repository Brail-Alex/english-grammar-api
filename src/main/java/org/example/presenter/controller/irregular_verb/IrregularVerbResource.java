package org.example.presenter.controller.irregular_verb;

import org.example.core.domain.IrregularVerb;
import org.example.presenter.model.VariantTargetResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/irregular_verb")
public interface IrregularVerbResource {
    @GetMapping(params = {"id"})
    CompletableFuture<IrregularVerb> getIrregularVerbById(@RequestParam Short id);

    @GetMapping
    CompletableFuture<List<IrregularVerb>> getAllIrregularVerbs();

    @GetMapping("/variant")
    CompletableFuture<VariantTargetResponse> getRandomVariantTarget();

    @PostMapping
    CompletableFuture<Boolean> postAnswerAtCompare(@RequestParam Short id, @RequestParam String target, @RequestParam String answer);
}
