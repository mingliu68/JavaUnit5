package com.mockitotest.business;

import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import java.util.List;

import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;


//


public class ListTest {

    @Test
    public void letsMockListSizeMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());

    }

    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);
        // when(listMock.get(0)).thenReturn("This is Mock Test");

        // Argument Matcher
        when(listMock.get(anyInt())).thenReturn("This is Mock Test");
        assertEquals("This is Mock Test", listMock.get(0));
        assertEquals("This is Mock Test", listMock.get(1));

    }

    @Test(expected=RuntimeException.class)
    public void letsMockListGet_ThrowException() {
        List listMock = mock(List.class);
        when((OngoingStubbing<Integer>) listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }
    
    // BDD 
    @Test
    public void letsMockListGet_usingBDD() {
        // Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("BBD Mock Test");

        // When
        String firstElement = listMock.get(0);
        String secondElement = listMock.get(1);

        // Then
        assertEquals("BBD Mock Test", firstElement);
        assertEquals("BBD Mock Test", secondElement);
    }
}
