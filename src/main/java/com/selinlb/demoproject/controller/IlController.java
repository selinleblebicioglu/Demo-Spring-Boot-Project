package com.selinlb.demoproject.controller;

import com.selinlb.demoproject.model.Il;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/iller")
public class IlController {
    private final List<Il> iller;

    public IlController() {
        Il il1 = new Il("id1", "İstanbul");
        Il il2 = new Il("id2", "İzmir");

        iller = Arrays.asList(il1, il2);
    }

    @GetMapping
    public ResponseEntity<List<Il>> getIller() {
        return new ResponseEntity<>(iller, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id) {
        Il result = iller.stream()
                .filter(il -> il.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Il bulunamadi."));

        return new ResponseEntity<>(result, OK);
    }
}
