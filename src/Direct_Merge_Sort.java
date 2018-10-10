/**
 * �����ⲿ�����е�ֱ�Ӻϲ�����
 * @author shxxy
 *	        ��Ϊ�ⲿ�������������ڴ�һ�β��ܹ�������򣬹ʽ����Ϊ����ڴ�ɴ����С�飬��С����ʹ���ڲ����򷽷����ź���
 *	Ȼ��ʹ��ֱ�Ӻϲ��������ÿһ��С����������ϲ������Ϻϲ������ó����
 */
import java.io.*;

public class Direct_Merge_Sort {
	public static void main(String[] args) throws Exception {
		String filep="data.txt";//eclipse�е�Ĭ��Ŀ¼��C:\Users\shxxy\Desktop\code\Rank����һ��Ŀ¼
		String filep1="data1.txt";
		String filep2="data2.txt";
		//�����ļ�ָ��  ÿһ��ָ���Ӧ����ļ�
		File fp = new File(filep);
		File fp1 = new File(filep1);
		File fp2 = new File(filep2);
		
		BufferedReader pfile = new BufferedReader(new FileReader(fp));
		BufferedReader pfile1 = new BufferedReader(new FileReader(fp1));
		BufferedReader pfile2 = new BufferedReader(new FileReader(fp2));
		
		//�ж��ļ����
		if(!fp.exists())
			System.out.println("�������ļ�ʧ��");
		else if(!fp1.exists())
			System.out.println("���������ļ�1ʧ��");//�����ļ��ɹ�ʱ��ָ��᷵��FILE�ļ�
		else if(!fp2.exists())
			System.out.println("���������ļ�2ʧ��");//�����ļ�ʧ�ܷ���NULL
		else {
			System.out.print("���������С�����������\n");
			merge(fp,fp1,fp2);
			System.out.print("���ݴ�����ɣ���\n");
		}
		
		System.out.print("data1.txt ��������Ϊ�� \n");
		char str;
		int str1;
		while (true) {
			str1=pfile1.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		System.out.print("data2.txt ��������Ϊ�� \n");
		while (true) {
			str1=pfile2.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		System.out.print("�����data.txt ��������Ϊ�� \n");
		while (true) {
			str1=pfile.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		//�ر��ļ�
		pfile.close();
		pfile1.close();
		pfile2.close();
		
	}
	
	public static void merge(File p,File p1,File p2)throws Exception{
		char str1,str2;
		int n1,n2;//��������n1��n2�ݴ������ļ�data1��data2�ڵ�Ԫ��ֵ
		
		BufferedWriter pfile = new BufferedWriter(new FileWriter(p));
		BufferedReader pfile1 = new BufferedReader(new FileReader(p1));
		BufferedReader pfile2 = new BufferedReader(new FileReader(p2));	
		
		n1=pfile1.read();
		n2=pfile2.read();
		
		//�ж��Ƿ��Ѿ������ļ�β
		while(n1!=-1 && n2!=-1) {
			if(n1<=n2) {
				str1 = (char) n1;
				pfile.write(str1);//���n1�Ƚ�С�����n1�浽fp��
				n1=pfile1.read();//���Ŷ���һ��n1
			}else {
				str2 = (char) n2;
				pfile.write(str2);
				n2=pfile2.read();
			}
		}
		
		//����ʣ��������һЩ�ֶεĴ���
		if(n2 != -1) {
			while (true) {
				if(n2==-1)
					break;
				str2=(char) n2;
				pfile.write(str2);
				n2=pfile2.read();
			}
		}
		if(n1 != -1) {
			while(true) {
				if (n1 ==-1)
					break;
				str1= (char) n1;
				pfile.write(str1);
				n1=pfile2.read();
			}
		}
		
		pfile.close();
		pfile1.close();
		pfile2.close();
	}
}
