import java.util.Arrays;
/*
 * ��β������˫��ð������
 * �����е����ֱ����޹��ɵ��ŷţ����ҵ���С�����֣������ŵ���һλ��Ȼ���ҵ��������ַŵ����һλ��
 * Ȼ�����ҵ��ڶ�С�����ַŵ��ڶ�λ�����ҵ��ڶ�������ַŵ������ڶ�λ���Դ����ƣ�ֱ���������
 */
public class TestCocktailSort {
	
	public static void main(String[] args) {
		int [] array = {5,6,1,7,3};
		cocktailSort(array);
	}
	
	public static int[] cocktailSort(int[] src)
	{
	    //����Сֵ�ŵ���β
	    for(int i = 0 ; i < src.length/2 ; i++)
	    {
	        for(int j = i ; j < src.length-i-1 ; j++)
	        {
	            if(src[j] < src[j+1])
	            {
	                int temp = src[j];
	                src[j] = src[j+1];
	                src[j+1] = temp;
	            }
	            System.out.println("����С"+Arrays.toString(src));
	        }
	        //�����ֵ�ŵ���ͷ
	        for(int j = src.length-1-(i+1); j > i ; j--)
	        {
	            if(src[j] > src[j-1])
	            {
	                int temp = src[j];
	                src[j] = src[j-1];
	                src[j-1] = temp;
	            }
	            System.out.println("������"+Arrays.toString(src));
	        }
	        System.out.println("��"+i+"����������"+Arrays.toString(src));
	    }
	    return src;
	}
}
