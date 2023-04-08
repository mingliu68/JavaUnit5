package com.mockitotest.data.api;

import java.util.List;

// create TodoServiceStub
    // a STUB is a sample implementation of the Dependency
        // A stub is a small piece of code that takes the place 
        // of another component during testing.
// test TodoBusinessImpl using TodoServiceStub

public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void deleteTodo(String todo);

}
