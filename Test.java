import org.junit.Assert;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test(){
        Solution c = new Solution();
        double result = c.calculation(c.houzhui(c.postfix("-5+8*8")));
        //�ö���
        //��������ֵ��Ȼ�������ʵֵ����������������жϷ���ֵ�Բ���
        Assert.assertEquals(59, result,0);
        //����̨��ɫ�Ļ�����˵������ʧ�ܣ�ȫ�̵Ļ����Ϳ���ͨ����
    }

}
