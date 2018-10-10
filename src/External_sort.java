/**
 * �����ⲿ����(��С��������)
 * @author shxxy
 * Ŀ�ģ����������ϲ�����
 * �����ļ�����datafile.txt
 * �ϲ����ļ�����sortdata.txt
 */

import java.io.*;
public class External_sort {
	public static void main(String[] args) throws Exception {
		String filep = "datafile.txt";
		String filep1 = "sort1.txt";
		String filep2 = "sort2.txt";
		String filepa = "sortdata.txt";
		
		File fp = new File(filep);
		File fp1 = new File(filep1);
		File fp2 = new File(filep2);
		File fpa = new File(filepa);
		
		if(!fp.exists())
			System.out.print("���������ļ�ʧ��\n");
		else if(!fp1.exists())
			System.out.println("�����ָ��ļ�1ʧ��");
		else if(!fp2.exists())
			System.out.println("�����ָ��ļ�2ʧ��");
		else if(!fpa.exists())
			System.out.println("�����ϲ��ļ�ʧ��");
		else {
			System.out.print("�ļ��ָ��С���������\n");
			
			me(fp,fp1,fp2,fpa);
			
			System.out.println("���������С�������");
			System.out.println("���ݴ�����ɣ���");
		}
		
		System.out.print("ԭʼ�ļ�datafile.txt��������Ϊ��\n");
		showdata(fp);
		System.out.print("\n�ָ��ļ�sort1.txt��������Ϊ��\n");
		showdata(fp1);
		System.out.print("\n�ָ��ļ�sort2.txt��������Ϊ��\n");
		showdata(fp2);
		System.out.print("\n�����sortdata.txt��������Ϊ��\n");
		showdata(fpa);
	}
	
	//��ȡ����ʾ�ļ�
	public static void showdata(File p) throws Exception {
		char str;
		int str1;
		BufferedReader pfile = new BufferedReader(new FileReader(p));
		while (true) {
			str1=pfile.read();
			str=(char)str1;
			if(str1 == -1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
	}
	
	//�ָ��
	public static void me (File p,File p1,File p2,File pa)throws Exception{
		char str1,str2;
		 int n1=0,n2,n;
		 BufferedReader pfile3 = new BufferedReader(new FileReader(p));
		 BufferedWriter pfile1 = new BufferedWriter(new FileWriter(p1));
		 BufferedWriter pfile2 = new BufferedWriter(new FileWriter(p2));
		 BufferedWriter pfilea = new BufferedWriter(new FileWriter(pa));
		 
		 while(true) {//ͳ�Ƴ���
			 n2 = pfile3.read();
			 if(n2==-1)
				 break;
			 n1++;
		
		 }
		 pfile3.close();
		 BufferedReader pfile = new BufferedReader(new FileReader(p));
		 //�԰����
		 for(n2=0;n2<(n1/2);n2++) {
			 str1=(char)pfile.read();
			 pfile1.write(str1);
		 }
		 pfile1.close();
		 
		 bubble(p1,n2);
		 
		 while(true) {
			 n=pfile.read();
			 str2=(char)n;
			 if(n==-1)
				 break;
			 pfile2.write(str2);
		 }
		 pfile2.close();
		 bubble(p2,n1/2);
		 pfilea.close();
		 merge(pa,p1,p2);
		 pfile.close();
	}
	
	public static void bubble(File p1,int size) throws Exception{
		char str1;
		int data[]=new int[100];
		int i,j,tmp,flag,ii;
		BufferedReader pfile = new BufferedReader(new FileReader(p1));
		for(i=0;i<size;i++) {//�������ļ���ȡ������
			ii=pfile.read();
			if(ii==-1)
				break;
			data[i]=ii;						
		}
		pfile.close();//�ر��ļ�
		
		
		//������ð������
		for(i=size-1;i>0;i--) {//������j+1��Ӧ�ľ������һ����size-1
			flag=0;
			for(j=0;j<i;j++) {
				if(data[j+1]<data[j]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
					flag++;
				}
			}
			if(flag==0)
				break;
		}
		
		//д���ļ�
		BufferedWriter pfile1 = new BufferedWriter(new FileWriter(p1));
		for(i=0;i<size;i++) {
			str1=(char)data[i];
			pfile1.write(str1);
		}
		pfile1.close();
	}
	
//	�ļ��ϲ�����
	public static void merge(File p,File p1,File p2)throws Exception{
		char str1,str2;
		int n1,n2;//��������n1��n2�ݴ�data1��data2�е�Ԫ��ֵ
		
		BufferedWriter dataOutput = new BufferedWriter(new FileWriter(p));
		BufferedReader pfile1 = new BufferedReader(new FileReader(p1));
		BufferedReader pfile2 = new BufferedReader(new FileReader(p2));
		
		n1=pfile1.read();
		n2=pfile2.read();
		while(n1 !=-1 && n2!= -1) {//�ж������Ƿ񵽴�ĩβ
			if(n1 <= n2) {
				str1=(char)n1;
				dataOutput.write(str1);
				n1=pfile1.read();
			}else {
				str2=(char) n2;
				dataOutput.write(str2);
				n2=pfile2.read();
			}
		}
		
		if(n2 != -1) {
			while(true) {
				if(n2 == -1)
					break;
				str2=(char)n2;
				dataOutput.write(str2);
				n2=pfile2.read();
			}
		}
		if(n1 != -1) {
			while(true) {
				if(n1 == -1)
					break;
				str1=(char) n1;
				dataOutput.write(str1);
				n1=pfile1.read();
			}
		}
		
		dataOutput.close();
		pfile1.close();
		pfile2.close();
	}
}
