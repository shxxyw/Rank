
public class Bubbling {
	public static void main(String[] args) {
		int i,j,tmp;
		int data[]= {6,5,9,7,2,8};//ԭʼ����
		
		System.out.println("ð������");
		System.out.println("ԭʼ����Ϊ��");
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		for(i=5;i>0;i--) {//ɨ�����
			for(j=0;j<i;j++) {//�ȽϽ�������
				if(data[j]>data[j+1]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
				}		
			}
			//�Ѹ��εĽ�����
			System.out.println("��"+(6-i)+"�������Ľ���ǣ�");
			for(j=0;j<6;j++) {
				System.out.print(data[j]+" ");
			}
			System.out.println();
		}
	}
}
