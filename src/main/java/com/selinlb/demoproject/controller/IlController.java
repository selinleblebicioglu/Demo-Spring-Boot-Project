package com.selinlb.demoproject.controller;

import com.selinlb.demoproject.exception.IlNotFoundException;
import com.selinlb.demoproject.model.Il;
import com.selinlb.demoproject.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class IlController {

    private final IlService ilService;

    private Il getIlById(String id) {
        return ilService.getIlById(id);
    }

    @GetMapping
    public ResponseEntity<List<Il>> getIller(@RequestParam(required = false) String name ) {
        return new ResponseEntity<>(ilService.getIller(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id) {
        return new ResponseEntity<>(getIlById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Il> addIl(@RequestBody Il newIl) {
        return new ResponseEntity<>(ilService.addIl(newIl), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateIl(@PathVariable String id, @RequestBody Il newIl) {
        ilService.updateIl(id, newIl);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id) {
        ilService.deleteIl(id);
        return new ResponseEntity<>(OK);
    }

    @ExceptionHandler(IlNotFoundException.class)
    public ResponseEntity<String> handleException(IlNotFoundException ex) {
         return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }
}
