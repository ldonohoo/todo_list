package com.todo.todo_list.controller;

import com.todo.todo_list.model.ListItem;
import com.todo.todo_list.service.ListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/list_items")
public class ListItemController {

    @Autowired
    private ListItemService listItemService;

    @GetMapping
    public List<ListItem> getAllListItems() {
        return listItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListItem> getListItemById(@PathVariable Long id) {
        Optional<ListItem> listItem = listItemService.findById(id);
        return listItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ListItem createListItem(@RequestBody ListItem listItem) {
        return listItemService.save(listItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListItem> updateListItem(@PathVariable Long id, @RequestBody ListItem listItemDetails) {
        Optional<ListItem> optionalListItem = listItemService.findById(id);
        if (optionalListItem.isPresent()) {
            ListItem listItem = optionalListItem.get();
            listItem.setDescription(listItemDetails.getDescription());
            listItem.setCompleted(listItemDetails.getCompleted());
            listItem.setPriority(listItemDetails.getPriority());
            return ResponseEntity.ok(listItemService.save(listItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListItem(@PathVariable Long id) {
        if (listItemService.findById(id).isPresent()) {
            listItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
