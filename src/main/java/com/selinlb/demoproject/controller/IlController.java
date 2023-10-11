package com.selinlb.demoproject.controller;

import com.selinlb.demoproject.model.Il;
import com.selinlb.demoproject.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity<List<Il>> getIller() {
        return new ResponseEntity<>(ilService.getIller(), OK);
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
        Il oldIl = getIlById(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date( ));
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id) {
        ilService.deleteIl(id);
        return new ResponseEntity<>(OK);
    }
}
