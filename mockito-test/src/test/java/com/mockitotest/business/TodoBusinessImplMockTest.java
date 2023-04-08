package com.mockitotest.business;

import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockitotest.data.api.TodoService;

// What is mocking?
// mocking is creating objects that simulate the behavior of real objects.
// unlike stubs, mocks can be dynamically created from code - at runtime. 
// mocks offer more functionality than stubbing.
// you can verify method calls and a lot of other things.


public class TodoBusinessImplMockTest {
    
    // @Test
    // public void testRetrieveTodosRelatedToSpring_withEmptyList() {

    //     TodoService todoServiceMock = mock(TodoService.class);
    //     List<String> todos = Arrays.asList();
    //     when(todoServiceMock.retrieveTodos("Empty")).thenReturn(todos);
    //     TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    //     List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Empty");
    //     assertEquals(0, filteredTodos.size());
    // }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() { 

        // mock function will create a mock object of a given class or interface
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);



        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        
        assertEquals(2, filteredTodos.size());
        assertEquals("Learn Spring MVC", filteredTodos.get(0));
        assertEquals("Learn Spring", filteredTodos.get(1));
    }

    // BDD => Behavior-Driven Development 
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() { 

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        
        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");


        // Then
        assertEquals(2, filteredTodos.size());
        assertEquals("Learn Spring MVC",filteredTodos.get(0));
        assertEquals("Learn Spring", filteredTodos.get(1));
    }
}