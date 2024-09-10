package ru.polovinko.springmvc.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.polovinko.springmvc.dto.PutDealRequest;
import ru.polovinko.springmvc.dto.ValidationDto;
import ru.polovinko.springmvc.exception.BadRequestException;
import ru.polovinko.springmvc.validation.NameGroup;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mvc")
public class MvcController {

    @PutMapping("/deals/{dealId}")
    public ResponseEntity<String> updateDeal(@PathVariable String dealId, @RequestBody PutDealRequest body) {
        return ResponseEntity.ok()
                .body(String.format("dealId: %s, dealNumber: %s", dealId, body.getNumber()));
    }

    @GetMapping("/deals/secret")
    public ResponseEntity<String> securedByInterceptor(@RequestParam String token) {
        return ResponseEntity.ok()
                .body(token);
    }

    @PostMapping("/deals/validate")
    public ResponseEntity<Void> validate(@Valid @RequestBody ValidationDto body, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(
                    bindingResult.getFieldErrors()
                            .stream()
                            .map(x -> x.getField() + ": " + x.getRejectedValue() + " is incorrect")
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deals/validate-group")
    public ResponseEntity<Void> validateGroup(@Validated(NameGroup.class) @RequestBody ValidationDto body, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(
                    bindingResult.getFieldErrors()
                            .stream()
                            .map(x -> x.getField() + ": " + x.getRejectedValue() + " is incorrect")
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
        return ResponseEntity.ok().build();
    }
}
