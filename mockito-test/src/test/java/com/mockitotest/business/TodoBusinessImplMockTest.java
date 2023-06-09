package com.mockitotest.business;

import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD() { 

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");


        // Then
        // verifying calls on mocks is actually getting called

        // verify(todoServiceMock).deleteTodo("Learn to Dance");
        then(todoServiceMock).should().deleteTodo("Learn to Dance");


        // verify the call is never called
        // verify(todoServiceMock, never()).deleteTodo("Learn Spring");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");

        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() { 

        // Declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        // Define argument captor on specific method call
        // Capture the argument

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
        
        // Then
        // verifying calls on mocks is actually getting called
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture_multiple() { 

        // Declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        // Define argument captor on specific method call
        // Capture the argument

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn to Rock", "Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
    

        // Then
        // verifying calls on mocks is actually getting called
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }
}