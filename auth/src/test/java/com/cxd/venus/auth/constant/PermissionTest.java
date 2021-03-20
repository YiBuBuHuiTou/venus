package com.cxd.venus.auth.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionTest {

    @Test
    void int2Bin() {
        assertEquals("00000000000000000000000011111111",Permission.int2Bin(0xFF));
        assertEquals("00000000000000111100000011111111",Permission.int2Bin(0x3C0FF));
        assertEquals("11111111000000000000000011111111",Permission.int2Bin(0xFF0000FF));
    }

    @Test
    void getBit() {
        assertEquals(1,Permission.getBit(0x400, 10));
        assertEquals(0,Permission.getBit(0x400, 8));
        assertEquals(0,Permission.getBit(0x400, 9));
        assertEquals(1,Permission.getBit(0x12A55, 6));
    }

    @Test
    void setBit() {
        assertEquals(0xFF, Permission.setBit(0xDF, 5,1));
        assertEquals(0x9F, Permission.setBit(0xDF, 6,0));
    }

    @Test
    void setPermission() {
        assertEquals(1, Permission.setPermission(0x00,ACTION.AUTH,1));
        assertEquals(0, Permission.setPermission(0x08,ACTION.DEL_ACCOUNT,0));
    }

    @Test
    void getPermission() {
        assertEquals(false,Permission.getPermission(0x1EF, ACTION.DESTROY_ACCOUNT));
        assertEquals(true,Permission.getPermission(0x1EF, ACTION.DEL_TENANT));
    }
}