package com.selinlb.demoproject.service;

import com.selinlb.demoproject.model.Il;
import com.selinlb.demoproject.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IlService {
    private final IlRepository ilRepository;

    public List<Il> getIller() {
        return ilRepository.findAll();
    }

    public Il addIl(Il newIl) {
        return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {
        return null;
        //return ilRepository.findById(id);
    }
}
