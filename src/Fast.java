import java.io.*;
import java.util.*;
public class Fast {
	int process = 0;
	int size;
	int data[]=new int[100];
	
	public static void main(String args[]) {
		Fast test = new Fast();
		System.out.print("�����������С��100���£��� ");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			test.size=Integer.parseInt(br.readLine());
		}catch(Exception e) {}
		test.inputarr();
		System.out.print("ԭʼ�����ǣ� ");
		test.showdata();
		test.quick(test.data, test.size, 0, test.size-1);
		System.out.println("�������� ");
		test.showdata();
	}
	
	void inputarr() {
		//�����������
		Random rand = new Random();
		int i;
		for(i=0;i<size;i++)
			data[i]=(Math.abs(rand.nextInt(99)))+1;
	}
	
	void showdata() {
		int i;
		for(i=0;i<size;i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	void quick(int d[],int size,int lf,int rg) {
		int i,j,tmp;
		int lf_idx;
		int rg_idx;
		int t;
		//1:��һ����ֵΪd[lf]
		if(lf<rg) {
			lf_idx=lf+1;
			rg_idx=rg;
			
			//����
			while(true) {
				System.out.print("[�������"+(process++)+"]=>");
				for(t=0;t<size;t++)
					System.out.print("["+d[t]+"] ");
				System.out.println();
				
				for(i=lf+1;i<=rg;i++) {//2:���������ҳ�һ����ֵ����d[lf]��
					if(d[i]>=d[lf]) {
						lf_idx=i;
						break;
					}
					lf_idx++;
				}
				
				for(j=rg;j>=lf+1;j--) {//3:���������ҳ�һ����ֵС�ڵ�d[lf]
					if(d[j]<=d[lf]) {
						rg_idx=j;
						break;
					}
					rg_idx--;
				}
				
				if(lf_idx<rg_idx) {//4:
					tmp=d[lf_idx];
					d[lf_idx]=d[rg_idx];
					d[rg_idx]=tmp;//Ȼ������������
				}else {
					break;//����������������while
				}
			}
			
			//����
			if(lf_idx>=rg_idx) {//��lf_idx���ڵ���rg_idx
				tmp=d[lf];
				d[lf]=d[rg_idx];
				d[rg_idx]=tmp;
				//��rg_idxΪ��׼��ֳ���������
				quick(d,size,lf,rg_idx-1);//�õݹ鷽ʽ�ֱ�Ϊ������������
				quick(d,size,rg_idx+1,rg);//ֱ���������
			}
		}
	}
}
