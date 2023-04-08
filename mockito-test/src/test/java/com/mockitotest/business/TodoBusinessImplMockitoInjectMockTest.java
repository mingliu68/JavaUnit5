package com.mockitotest.business;

import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;


import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.mockitotest.data.api.TodoService;



// @RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

    // major difference between runner and rule is that you can only have
    // one runner, but you can have multiple rules
    // that's why it's preferred @Rule over @RunWith

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;
    // essentially this is the same as writting 
    // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;
    // essentially this is the same as writting 
    // ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);



    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() { 

        // TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        
        assertEquals(2, filteredTodos.size());
        assertEquals("Learn Spring MVC", filteredTodos.get(0));
        assertEquals("Learn Spring", filteredTodos.get(1));
    }

    // BDD => Behavior-Driven Development 
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() { 

        // Given
        // TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        
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
        // TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

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
        // ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        // Define argument captor on specific method call
        // Capture the argument

        // Given
        // TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

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
        // ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        // Define argument captor on specific method call
        // Capture the argument

        // Given
        // TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn to Rock", "Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
    

        // Then
        // verifying calls on mocks is actually getting called
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }
}
