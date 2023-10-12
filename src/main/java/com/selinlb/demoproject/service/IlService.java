package com.selinlb.demoproject.service;

import com.selinlb.demoproject.exception.IlNotFoundException;
import com.selinlb.demoproject.model.Il;
import com.selinlb.demoproject.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IlService {
    private final IlRepository ilRepository;

    public List<Il> getIller(String name) {
        if(name == null) {
            return ilRepository.findAll();
        } else {
            return ilRepository.findByName(name);
        }
    }

    public Il addIl(Il newIl) {
        return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public void updateIl(String id, Il newIl) {
        Il oldIl = getIlById(id);
        oldIl.setName(newIl.getName());
        ilRepository.save(oldIl);
    }

    public Il getIlById(String id) {
        return ilRepository.findById(id).orElseThrow(() -> new IlNotFoundException("Il bulunamadi."));
    }
}
