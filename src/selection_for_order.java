
public class selection_for_order {
	static int data[]= {9,7,5,3,4,6};
	public static void main(String[] args) {
		System.out.print("ԭʼ����Ϊ��");
		showdata();
		select();
	}
	static void showdata() {
		int i;
		for(i=0;i<6;i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	static void select() {
		int i,j,tmp,k;
		for(i=0;i<5;i++) {//���������
			tmp=data[i];
			k=i;
			for(j=i+1;j<6;j++) {//Ѱ����Сֵ		
				if(tmp>data[j]) {
	            tmp=data[j];
	            k=j;//��¼������λ��
				}
			}
			data[k]=data[i];
			data[i]=tmp;
			
			//��ӡÿ��������Ľ��
			System.out.print("��"+(i+1)+"������Ľ����");
			for(int m=0;m<6;m++) 
				System.out.print(data[m]+" ");
			System.out.println();
			
		}
	}
}
