package com.mockitotest.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mockitotest.data.api.TodoService;
import com.mockitotest.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {
    
   

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() { 
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
        assertEquals("Learn Spring MVC", filteredTodos.get(0));
        assertEquals("Learn Spring", filteredTodos.get(1));
    }
}
