import java.io.*;
public class Rank_of_Shell {
	int data[] = new int[8];
	int size=8;
	
	public static void main(String[] args) {
		Rank_of_Shell test = new Rank_of_Shell();
		test.inputarr();
		System.out.print("�������ԭʼ�����ǣ�");
		test.showdata();
		test.shell();
	}
	
	void inputarr() {
		int i=0;
		for(i=0;i<size;i++) {
			System.out.print("�������"+(i+1)+"��Ԫ��");
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				data[i]=Integer.parseInt(br.readLine());
			}catch(Exception e) {}
		}
		System.out.println();
	}
	
	void showdata() {
		int i=0;
		for(i=0;i<size;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	void shell() {
		int i;//iΪɨ�����
		int j;//��j���Ƚ϶�λԪ��
		int k=1;//��ӡ����
		int tmp;//�ݴ�����
		int jmp;//�趨���λ����
		jmp=size/2;
		while(jmp !=0) {
			for(i=jmp;i<size;i++) {
				tmp=data[i];
				j=i-jmp;
				while(j>=0 && tmp<data[j]) {//��������
					data[j+jmp]=data[j];
					j=j-jmp;
				}
				data[jmp+j]=tmp;
			}
			System.out.print("��"+(k++)+"������");
			showdata();
			jmp=jmp/2;//����ѭ����
		}
	}
}
