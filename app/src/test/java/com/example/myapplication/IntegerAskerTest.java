package com.example.myapplication;

import junit.framework.TestCase;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IntegerAskerTest extends TestCase {

    public void testAsk() {
        IntegerAsker a = mock(IntegerAsker.class);
        a.ask(anyString());
        verify(a, times(1)).ask(anyString());
    }
}