package com.todo.todo_list.repository;

import com.todo.todo_list.model.ListHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListHeaderRepository extends JpaRepository<ListHeader, Long> {  
}
