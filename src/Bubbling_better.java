
public class Bubbling_better {
	public static void main(String[] args) {
		int i,j,tmp;
		int data[]= {6,5,9,7,2,8};//ԭʼ����
		
		System.out.println("ð������");
		System.out.println("ԭʼ����Ϊ��");
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		data=BubbleSort(data,5);
		
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
	}
	public static int[] BubbleSort(int[] data,int n) {
		int i=n,tmp;
		while(i>0) {//�Ľ��㷨�������˵�һ�αȽ�֮��û�������ıȽϣ�����Ϊ���������
			int lastExchangeIndex=0;
			for(int j=0;j<i;j++) {
				if(data[j+1]<data[j]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
					lastExchangeIndex=j;
				}
			}
			i=lastExchangeIndex;
		}
		return  data;
	}
}
