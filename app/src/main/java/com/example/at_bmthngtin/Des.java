package com.example.at_bmthngtin;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

public class Des {

    int[] IP = {58, 50, 42, 34, 26, 18,
            10, 2, 60, 52, 44, 36, 28, 20,
            12, 4, 62, 54, 46, 38,
            30, 22, 14, 6, 64, 56,
            48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17,
            9, 1, 59, 51, 43, 35, 27,
            19, 11, 3, 61, 53, 45,
            37, 29, 21, 13, 5, 63, 55,
            47, 39, 31, 23, 15, 7};

    int[] IP1 = {40, 8, 48, 16, 56, 24, 64,
            32, 39, 7, 47, 15, 55,
            23, 63, 31, 38, 6, 46,
            14, 54, 22, 62, 30, 37,
            5, 45, 13, 53, 21, 61,
            29, 36, 4, 44, 12, 52,
            20, 60, 28, 35, 3, 43,
            11, 51, 19, 59, 27, 34,
            2, 42, 10, 50, 18, 58,
            26, 33, 1, 41, 9, 49,
            17, 57, 25};

    int[] PC1 = {57, 49, 41, 33, 25,
            17, 9, 1, 58, 50, 42, 34, 26,
            18, 10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36, 63,
            55, 47, 39, 31, 23, 15, 7, 62,
            54, 46, 38, 30, 22, 14, 6, 61,
            53, 45, 37, 29, 21, 13, 5, 28,
            20, 12, 4};

    int[] PC2 = {14, 17, 11, 24, 1, 5, 3,
            28, 15, 6, 21, 10, 23, 19, 12,
            4, 26, 8, 16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55, 30, 40,
            51, 45, 33, 48, 44, 49, 39, 56,
            34, 53, 46, 42, 50, 36, 29, 32};

    int[] EP = {32, 1, 2, 3, 4, 5, 4,
            5, 6, 7, 8, 9, 8, 9, 10,
            11, 12, 13, 12, 13, 14, 15,
            16, 17, 16, 17, 18, 19, 20,
            21, 20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29, 28,
            29, 30, 31, 32, 1};

    int[] P = {16, 7, 20, 21, 29, 12, 28,
            17, 1, 15, 23, 26, 5, 18,
            31, 10, 2, 8, 24, 14, 32,
            27, 3, 9, 19, 13, 30, 6,
            22, 11, 4, 25};

    int[][][] sbox = {
            {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}},

            {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                    {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                    {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                    {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}},
            {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}},
            {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}},
            {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}},
            {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}},
            {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}},
            {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}
    };
    int[] sBit = {1, 1, 2, 2, 2, 2, 2, 2,
            1, 2, 2, 2, 2, 2, 2, 1};

    @RequiresApi(api = Build.VERSION_CODES.O)
    String hextoBin(String input) { // Chuy???n hexa sang nh??? ph??n
        int n = input.length() * 4;
        input = Long.toBinaryString(
                Long.parseUnsignedLong(input, 16));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String binToHex(String input) { // chuy???n nh??? ph??n sang hexa
        int n = (int) input.length() / 4;
        input = Long.toHexString(
                Long.parseUnsignedLong(input, 2));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String permutation(int[] pc, String input) { // th???c hi???n h??a v??? PC1 || PC2
        String output = "";
        input = hextoBin(input); // chuy???n sang nh??? ph??n
        for (int i = 0; i < pc.length; i++)
            output += input.charAt(pc[i] - 1); //th???c hi???n ho??n v???
        output = binToHex(output); // chuy???n v??? hexa
        return output;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String xor(String a, String b) { // Th???c hi???n ph??p XOR 0&0 = 0 ; 0&1 = 1
        long t_a = Long.parseUnsignedLong(a, 16);
        long t_b = Long.parseUnsignedLong(b, 16);
        t_a = t_a ^ t_b;
        a = Long.toHexString(t_a);
        while (a.length() < b.length())
            a = "0" + a;
        return a;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String leftCircularShift(String input, int numBits) { // d???ch v??ng tr??i
        int n = input.length() * 4;
        int perm[] = new int[n];
        for (int i = 0; i < n - 1; i++)
            perm[i] = (i + 2);
        perm[n - 1] = 1; // m??ng perm ch???a v??? tr?? khi d???ch tr??i 1 bit
        while (numBits-- > 0)
            input = permutation(perm, input);
        return input;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] getKeys(String key) { //16 v??ng l???p t???o 16 K
        String keys[] = new String[16];
        key = permutation(PC1, key); // th???c hi???n ho??n v??? pc1
        for (int i = 0; i < 16; i++) {
            key = leftCircularShift(key.substring(0, 7), sBit[i]) + leftCircularShift(key.substring(7, 14), sBit[i]); // th???c hi???n d???ch v??ng tr??i sBit[i] bit
            keys[i] = permutation(PC2, key); // th???c hi???n h??a v???n PC2 v???i CiDi -> Ki
        }
        return keys;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String sBox(String input) { // th???c hi???n tra b???ng S-box
        String output = "";
        input = hextoBin(input);
        for (int i = 0; i < 48; i += 6) {
            String temp = input.substring(i, i + 6);
            int num = i / 6;
            int row = Integer.parseInt(
                    temp.charAt(0) + "" + temp.charAt(5), 2);
            int col = Integer.parseInt(
                    temp.substring(1, 5), 2);
            output += Integer.toHexString(
                    sbox[num][row][col]);
        }
        return output;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String round(String input, String key, int num) {
        // fk
        String left = input.substring(0, 8);
        String temp = input.substring(8, 16);
        String right = temp;
        temp = permutation(EP, temp); // Th???c hi???n ho??n v??? m??? r???ng E(R(i))
        temp = xor(temp, key); // th???c hi???n ph??p Xor E(R(i)) v???i K(i+1)
        temp = sBox(temp); // Th???c hi???n th??? S-Box
        temp = permutation(P, temp); // Th???c hi???n ho??n v??? P
        left = xor(left, temp); // th???c hi???n ph??p Xor L(i) v???i f(R(i) Xor K(i+1)) tr??? v??? R(i+1)
        // TODO 16 v??ng l???p L&R
//        System.out.println("Round "
//                + (num + 1) + " "
//                + right.toUpperCase()
//                + " " + left.toUpperCase() + " "
//                + key.toUpperCase());
        return right + left; // L(i+1) = R(i), R(i+1) = L(i) Xor f(R(i) Xor K(i+1))
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String encrypt(String M, String key) { // m?? h??a
        int i;
        String keys[] = getKeys(key); // l???y v??? 16 kh??a K
        M = permutation(IP, M); // th???c hi???n ho??n v??? IP  ?????i v???i M
        // TODO M?? h??a
        for (i = 0; i < 16; i++) {
            M = round(M, keys[i], i); // th???c hi???n 16 v??ng l???p t??m L16 v?? R16
        }
        M = M.substring(8, 16) + M.substring(0, 8); // ?????o ch??? R16 v?? L16
        M = permutation(IP1, M); // Th???c hi???n ho??n v??? IP1 tr??? v??? b???n m?? ???????c m?? h??a C
        return M;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String decrypt(String C, String key) {   // Gi???i m?? th???c hi???n l???i 1 l???n m?? h??a v???i ?????u v??a l?? b???n m?? C
        int i;
        String keys[] = getKeys(key);
        C = permutation(IP, C);
        // TODO Gi???i m??
        for (i = 15; i > -1; i--) {
            C = round(C, keys[i], 15 - i);
        }
        C = C.substring(8, 16)
                + C.substring(0, 8);
        C = permutation(IP1, C);
        return C;
    }



}

