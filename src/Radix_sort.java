/*
 * ���Ի�������
 * LSD���λ����
 * ��С��������
 */
import java.io.*;
import java.util.*;

public class Radix_sort {
	int size;
	int data[]=new int[100];
	
	public static void main(String args[]) {
		Radix_sort test = new Radix_sort();
		
		System.out.println("�����������С��100���£��� ");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			test.size=Integer.parseInt(br.readLine());
		}catch(Exception e) {}
		
		test.inputarr();
		System.out.print("�������ԭʼ�����ǣ�\n");
		test.showdata();
		
		test.radix();
	}
	
	//����λ�����趨���룬�������
	void inputarr() {
		Random rand = new Random();
		int i;
		for(i=0;i<size;i++)
			data[i]=(Math.abs(rand.nextInt(999)))+1;//�趨dataֵ���Ϊ��λ��999
	}
	
	//�������
	void showdata() {
		int i;
		for(i=0;i<size;i++)
			System.out.print(data[i]+" ");
			System.out.print("\n");
	}
	
	//��������
	void radix() {
		int i,j,k,n,m;
		for(n=1;n<=100;n=n*10) {//nΪ�������ɸ�λ����ʼ����
			//�趨�ݴ����飬[0~9λ��][���ݸ���]���������ݾ�Ϊ0
			int tmp[][]=new int [10][100];
			for(i=0;i<size;i++) {//�Ƚ���������
				m=(data[i]/n)%10;//mΪnλ����ֵ����36ȡʮλ����36/10��%10=3
				tmp[m][i]=data[i];//��data[i]��ֵ�ݴ���tmp��
			}
			k=0;
			
			for(i=0;i<10;i++) {
				for(j=0;j<size;j++) {
					if(tmp[i][j] != 0) {// �����趨ֵ��Ϊ0�����ڲ�Ϊ0�߼�Ϊ
						//data�ݴ���tmp���ֵ����tmp���ֵ�Ż���data[]��
						data[k]=tmp[i][j];
						k++;
					}
				}
			}
			System.out.print("����"+n+"λ������� ");
			showdata();
		}
	}
}
