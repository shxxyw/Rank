//���Զѻ�������
/*
 * ʱ�临�Ӷ�nlogn
 * �ռ临�Ӷ�1
 */
import java.io.*;
public class Stack {
	public static void main(String[] args) {
		int i,size,data[]= {0,5,6,4,8,3,2,7,1};//ԭʼ�������� 0���μ�����
		size=9;
		System.out.print("ԭʼ���飺 ");
		for(i=1;i<size;i++)
			System.out.print("["+data[i]+"] ");
		heap(data,size);
		System.out.print("\n�������� ");
		for(i=1;i<size;i++)
			System.out.print("["+data[i]+"] ");
		System.out.println();
	}
	
	public static void heap(int data[],int size) {
		int i,j,tmp;
		for(i=(size/2);i>0;i--)//�����ѻ����ڵ� ȡһ����Ϊ�˷�ֹ����������������Ӷ������������������ڽϴ����������ĺ���
			ad_heap(data,i,size-1);
		System.out.print("\n�ѻ����ݣ�");//println������껻��  ;\n�ѻ����ݣ� �ǻ��������
		for(i=1;i<size;i++)//ԭʼ�ѻ�������
			System.out.print("["+data[i]+"] ");
		System.out.println();
		
		//�ѻ��������
		for(i=size-2;i>0;i--) {
			tmp=data[i+1];//ͷβ�ڵ㽻��
			data[i+1]=data[1];
			data[1]=tmp;
			ad_heap(data,1,i);//����ʣ��ڵ�
			System.out.print("\n������̣� ");
			for(j=1;j<size;j++)
				System.out.print("["+data[j]+"] ");
			
		}
	}
	
	//��data ���� iλ����size��Χ�ڣ���iΪ��������Ѱ�������������Ĵ�С��������
	public static void ad_heap(int data[],int i,int size) {
		int j,tmp,post;
		j=2*i;
		tmp=data[i];
		post=0;
		while(j<=size && post==0) {
			
			if(j<size) {
				if(data[j]<data[j+1])//�ҳ����ڵ�
					j++;
			}
		
			//�����������Ƚ�
			if(tmp>=data[j]) {
				post=1;//�������ϴ󣬽����ȽϹ���
			}else {
				data[j/2]=data[j];//��������С������Ƚ�
				j=2*j;
			}
		}
		data[j/2]=tmp;
	}
}
