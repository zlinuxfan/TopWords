package com.schkv.task.interview;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatusTest {
    private final Status status = new Status();
    private final Status status2 = new Status();

    @Test
    void increment() {
        Assertions.assertEquals(2, status.increment().getCounter());
    }

    @Test
    void getCounter() {
        Assertions.assertEquals(1, status.getCounter());
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(new Status(), new Status());
        Assertions.assertEquals(new Status().increment(), new Status().increment());
        Assertions.assertEquals(status.increment().increment(), status2.increment().increment());
    }
}