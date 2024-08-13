
    package com.todo.todo_list.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Column;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
    
    @Entity
    @Table(name="list_item")
    public class ListItem {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        private ListHeader listHeader;
        private String description;
        private Boolean completed;
        private Byte priority;  //only need 1-3
    
        // constructors 
        //    -(no arg for JPA default)
        public ListItem() {}

        //    - constructor for no priority
        public ListItem(String description) {
            this.description = description;
            this.completed = false;
            this.priority = 3;
        }

        //    - constructor for priority selected
        public ListItem(String description, Byte priority) {
            this.description = description;
            this.completed = false;
            this.priority = priority;
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
    
        public boolean getCompleted() {
            return completed;
        }
    
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public Byte getPriority() {
            return priority;
        }

        public void setPriority(Byte priority) {
            this.priority = priority;
        }
    
        public ListHeader getListHeader() {
            return listHeader;
        }

        public void setListHeader(ListHeader listHeader) {
            this.listHeader = listHeader;
        }
    }
    
