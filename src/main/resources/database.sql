-- database creation file: todo_list

DROP TABLE IF EXISTS list_header;  
DROP TABLE IF EXISTS list_item; 
      
      
CREATE TABLE list_header (
    id SERIAL PRIMARY KEY,
    description VARCHAR,
    starred_list BOOLEAN
);


CREATE TABLE list_item (
    id SERIAL PRIMARY KEY,
    list_id INT REFERENCES list_header ON DELETE CASCADE,
    description VARCHAR,
    completed BOOLEAN,
    priority int );

