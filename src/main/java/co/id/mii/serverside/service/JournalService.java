package co.id.mii.serverside.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import co.id.mii.serverside.model.Journal;
import co.id.mii.serverside.repository.JournalRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JournalService {
    private JournalRepository journalRepository;

   
    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Journal getById(Long id) {
        return journalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Journal not Found"));
    }


    public Journal create(Journal journal) {
        if (journal.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jurnal already exist");
        }
        if (journalRepository.findByName(journal.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jurnal name already exist");
        }
        return journalRepository.save(journal);
    }    
}
