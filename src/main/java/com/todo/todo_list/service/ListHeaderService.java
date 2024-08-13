package com.todo.todo_list.service;

import com.todo.todo_list.model.ListHeader;
import com.todo.todo_list.repository.ListHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListHeaderService {
    
    @Autowired
    private ListHeaderRepository listHeaderRepository;

    public List<ListHeader> findAll() {
        return listHeaderRepository.findAll();
    }

    public Optional<ListHeader> findById(Long id) {
        return listHeaderRepository.findById(id);
    }

    public ListHeader save(ListHeader listHeader) {
        return listHeaderRepository.save(listHeader);
    }

    public void deleteById(Long id) {
        listHeaderRepository.deleteById(id);
    }
}
