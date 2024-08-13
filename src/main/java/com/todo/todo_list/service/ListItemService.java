package com.todo.todo_list.service;

import com.todo.todo_list.model.ListItem;
import com.todo.todo_list.repository.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListItemService {
    
    @Autowired
    private ListItemRepository listItemRepository;

    public List<ListItem> findAll() {
        return listItemRepository.findAll();
    }

    public Optional<ListItem> findById(Long id) {
        return listItemRepository.findById(id);
    }

    public ListItem save(ListItem listHeader) {
        return listItemRepository.save(listHeader);
    }

    public void deleteById(Long id) {
        listItemRepository.deleteById(id);
    }
}
