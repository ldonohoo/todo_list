package com.todo.todo_list.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name="list_header")

// class to hold the list of todo list names
public class ListHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "starred_list")
    private Boolean starredList;
    @OneToMany(mappedBy = "list_item")
    private List<ListItem> listItems;

    // constuctors

    // (no arg for JPA default)
    public ListHeader() {}

    public ListHeader(String description, boolean starredList) {
        this.description = description;
        this.starredList = starredList;
    }

    // getters, setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStarredList() {
        return starredList;
    }

    public void setStarredList(boolean starredList) {
        this.starredList = starredList;
    }

    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }
}
