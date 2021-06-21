import org.junit.Assert;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test(){
        Solution c = new Solution();
        double result = c.calculation(c.houzhui(c.postfix("-5+8*8")));
        //用断言
        //给出期望值，然后给出真实值，用这个方法可以判断返回值对不对
        Assert.assertEquals(59, result,0);
        //控制台红色的话，就说明断言失败，全绿的话，就可以通过。
    }

}
