package co.id.mii.serverside.controller;

import co.id.mii.serverside.model.Journal;
import co.id.mii.serverside.service.JournalService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/journal")
public class JournalController {

    private JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public ResponseEntity<List<Journal>> getAll() {
        return new ResponseEntity(journalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Journal> getById(@PathVariable Long id) {
        return new ResponseEntity(journalService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Journal> create(@RequestBody Journal journal) {
        return new ResponseEntity(journalService.create(journal), HttpStatus.CREATED);
    }
}
