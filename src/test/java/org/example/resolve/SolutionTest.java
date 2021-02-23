package org.example.resolve;


import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void solution1(){
        Solution s = new Solution();
        String ret = s.solution1(new int[]{9});
        assertEquals(ret,"w x y z");
        ret = s.solution1(new int[]{2,3});
        assertEquals(ret,"ad ae af bd be bf cd ce cf");
        ret = s.solution1(new int[]{});
        assertEquals(ret,"");
        ret = s.solution1(new int[]{0,1});
        assertEquals(ret,"");
    }

    @Test
    public void solution2(){
        Solution s = new Solution();
        String ret = s.solution2(new int[]{99});
        assertEquals(ret,"ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz");
        ret = s.solution2(new int[]{10});
        assertEquals(ret,"");
    }
}