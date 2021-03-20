package com.cxd.venus.auth.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/14 21:14
 * @Version 1.0
 **/
public class Permission {

    /**
     * int 转换成32进制
     * @param num
     * @return
     */
    public static String int2Bin(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("00000000000000000000000000000000");
        String binStr = Integer.toBinaryString(num);
        return stringBuilder.substring(0, 32-binStr.length()).concat(binStr);
    }

    /**
     * 获取某个bit
     *
     * @param bin
     * @param bitNum
     * @return
     */
    public static int getBit(int bin, int bitNum) {
        String binStr = Integer.toString(bin, 2);
        if (bin < 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(binStr);
        char bit = sb.reverse().charAt(bitNum);
        return bit == '0' ? 0 : 1;
    }

    /**
     * 给某个数字某个bit赋值
     * @param privilege_old
     * @param bitNum
     * @param num
     * @return
     */
    public static int setBit(int privilege_old, int bitNum, int num) {
        if (num != 0 && num != 1) {
            return privilege_old;
        }
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(privilege_old));
        if (stringBuilder.length() < bitNum) {

        }
        stringBuilder.reverse().replace(bitNum,bitNum+1, String.valueOf(num));
        return Integer.parseUnsignedInt(stringBuilder.reverse().toString(), 2);
    }

    /**
     * 给某个bit赋值
     *
     * @param privilege_old
     * @param action
     * @param able
     * @return
     */
    public static int setPermission(int privilege_old, ACTION action, int able) {
        int privilege_new = privilege_old;
        switch (action) {
            // bit0
            case AUTH:
                privilege_new = setBit(privilege_old, 0, able);
                break;

            //bit1
            case ADD_ACCOUNT:
                privilege_new = setBit(privilege_old, 1, able);
                break;

            //bit2
            case UPDATE_ACCOUNT:
                privilege_new = setBit(privilege_old, 2, able);
                break;

            //bit3
            case DEL_ACCOUNT:
                privilege_new = setBit(privilege_old, 3, able);
                break;

            //bit4
            case DESTROY_ACCOUNT:
                privilege_new = setBit(privilege_old, 4, able);
                break;

            //bit5
            case ADD_TENANT:
                privilege_new = setBit(privilege_old, 5, able);
                break;

            //bit6
            case UPDATE_TENANT:
                privilege_new = setBit(privilege_old, 6, able);
                break;

            //bit7
            case DEL_TENANT:
                privilege_new = setBit(privilege_old, 7, able);
                break;

            //bit8
            case DESTROY_TENANT:
                privilege_new = setBit(privilege_old, 8, able);
                break;

            default:
                privilege_new = privilege_old;
        }
        return privilege_new;
    }

    public static boolean getPermission(int privilege, ACTION action) {
        //TODO
        int result = 0;
        switch (action) {
            // bit0
            case AUTH:
                result = getBit(privilege, 0);
                break;

            //bit1
            case ADD_ACCOUNT:
                result = getBit(privilege, 1);
                break;

            //bit2
            case UPDATE_ACCOUNT:
                result = getBit(privilege, 2);
                break;

            //bit3
            case DEL_ACCOUNT:
                result = getBit(privilege, 3);
                break;

            //bit4
            case DESTROY_ACCOUNT:
                result = getBit(privilege, 4);
                break;

            //bit5
            case ADD_TENANT:
                result = getBit(privilege, 5);
                break;

            //bit6
            case UPDATE_TENANT:
                result = getBit(privilege, 6);
                break;

            //bit7
            case DEL_TENANT:
                result = getBit(privilege, 7);
                break;

            //bit8
            case DESTROY_TENANT:
                result = getBit(privilege, 8);
                break;

            default:
                result = 0;

        }

        return result == 0 ? false : true;

    }
}
