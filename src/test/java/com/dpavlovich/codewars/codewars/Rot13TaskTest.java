package com.dpavlovich.codewars.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Rot13TaskTest {

    @Test
    public void test() {
//        <rlY %!*9_gD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo>
//        <rlY %!*9_MD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo>
//        `rlY %!*9_gD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo`
        Assertions.assertEquals("<rlY %!*9_MD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo>", Rot13Task.rot13("`eyL %!*9_ZQ1A)ü9VijD3F)mifP3t^wQ3Sq6dcCqqRAoB0iPRIy951n7Q@jD93)Cppkstb`"));
    }

    @Test
    public void test2() {
        char a = 'A';
        for (int i = 0; i < 60; i++) {
            System.out.println(a + " : " + ((int) a));
            a++;
        }
    }

    @Test
    public void test3() {
//        <rlY %!*9_gD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo>
//        <rlY %!*9_MD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo>
//        `rlY %!*9_gD1N)ü9IvwQ3S)zvsC3g^jD3Fd6qpPddENbO0vCEVl951a7D@wQ93)Pccxfgo`
        Assertions.assertEquals("N", Rot13Task.rot13("Z"));
    }

}