package com.todo.todo_list.repository;

import com.todo.todo_list.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {  
}
