import java.io.*;
//��������ʵ�ֲ��룬���ٲ�����ɵĸ��Ӷ�
public class insert_for_order {
	 int data[]=new int [6];
	 int   size=6;
	public static void main(String[] args) {
		insert_for_order test = new insert_for_order();
		test.inputarr();
		System.out.print("�������ԭʼ�����ǣ�");
		test.showdata();
		test.insert();
	}
	
	 void  inputarr() {
		int i;
		for(i=0;i<size;i++) {
			try {
				System.out.print("�������"+(i+1)+"��Ԫ��");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				data[i]=Integer.parseInt(br.readLine());
			}catch(Exception e) {}
		}
	}
	
	 void showdata() {
		 int i;
		 for(i=0;i<size;i++)
			 System.out.print(data[i]+" ");
		 System.out.println();
	 }
	 
	 void insert() {
		 int i;//ɨ�����
		 int j;//���Զ�λ�Ƚϵ�Ԫ��
		 int tmp;//�ݴ�����
		 for(i=1;i<size;i++) {//ɨ��ѭ������size-1
			 tmp=data[i];
			 j=i-1;
			 
			 while(j>=0 && tmp<data[j]) {//�ڶ�Ԫ��С�ڵ�һ��Ԫ��
				 data[j+1]=data[j];//����Ԫ��������һ��λ��
				 j--;
			 }
			 data[j+1]=tmp;//��СԪ�طŵ�һ��Ԫ��
			 System.out.print("��"+i+"��ɨ�裺");
			 showdata();
		 }
	 }
}
