package com.todo.todo_list.controller;

import com.todo.todo_list.model.ListHeader;
import com.todo.todo_list.service.ListHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/list_headers")
public class ListHeaderController {

    @Autowired
    private ListHeaderService listHeaderService;

    @GetMapping
    public List<ListHeader> getAllListHeaders() {
        return listHeaderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListHeader> getListHeaderById(@PathVariable Long id) {
        Optional<ListHeader> listHeader  = listHeaderService.findById(id);
        return listHeader.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ListHeader createListHeader(@RequestBody ListHeader listHeader) {
        return listHeaderService.save(listHeader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListHeader> updateListHeader(@PathVariable Long id, @RequestBody ListHeader listHeaderDetails) {
        Optional<ListHeader> optionalListHeader = listHeaderService.findById(id);
        if (optionalListHeader.isPresent()) {
            ListHeader listHeader = optionalListHeader.get();
            listHeader.setDescription(listHeaderDetails.getDescription());
            listHeader.setStarredList(listHeaderDetails.getStarredList());
            listHeader.setListItems(listHeaderDetails.getListItems());
                
            
            return ResponseEntity.ok(listHeaderService.save(listHeader));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListHeader(@PathVariable Long id) {
        if (listHeaderService.findById(id).isPresent()) {
            listHeaderService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

