package com.example.checklist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.checklist.domain.Entry;
import com.example.checklist.domain.EntryRepository;
import com.example.checklist.domain.Importance;
import com.example.checklist.domain.ImportanceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntryRepositoryTest {

    @Autowired
    private EntryRepository repository;
    
    @Autowired
    private ImportanceRepository irepo;

    @Test
    public void findByEntryNameShouldReturnEntry() {
        List<Entry> entries = repository.findByEntryName("Ruokaostokset");
        
        assertThat(entries).hasSize(1);
        assertThat(entries.get(0).getEntryText()).isEqualTo("Muista ostaa omenoita");
    }
    
    Importance importance2 = new Importance("2");
    
    @Test
    public void createNewImportance() {
    	irepo.save(importance2);
    }
    
    @Test
    public void createNewEntry() {
    	Entry entry = new Entry(importance2, "Koira", "keissi ulos");
    	repository.save(entry);
    	assertThat(entry.getId()).isNotNull();
    }    

}
