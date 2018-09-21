import java.io.*;
import java.util.*;
public class Fast {
	int process = 0;
	int size;
	int data[]=new int[100];
	
	public static void main(String args[]) {
		Fast test = new Fast();
		System.out.print("请输入数组大小（100以下）： ");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			test.size=Integer.parseInt(br.readLine());
		}catch(Exception e) {}
		test.inputarr();
		System.out.print("原始数据是： ");
		test.showdata();
		test.quick(test.data, test.size, 0, test.size-1);
		System.out.println("排序结果： ");
		test.showdata();
	}
	
	void inputarr() {
		//以随机数输入
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
		//1:第一个键值为d[lf]
		if(lf<rg) {
			lf_idx=lf+1;
			rg_idx=rg;
			
			//排序
			while(true) {
				System.out.print("[处理过程"+(process++)+"]=>");
				for(t=0;t<size;t++)
					System.out.print("["+d[t]+"] ");
				System.out.println();
				
				for(i=lf+1;i<=rg;i++) {//2:由左向右找出一个键值大于d[lf]者
					if(d[i]>=d[lf]) {
						lf_idx=i;
						break;
					}
					lf_idx++;
				}
				
				for(j=rg;j>=lf+1;j--) {//3:由右向左找出一个键值小于的d[lf]
					if(d[j]<=d[lf]) {
						rg_idx=j;
						break;
					}
					rg_idx--;
				}
				
				if(lf_idx<rg_idx) {//4:
					tmp=d[lf_idx];
					d[lf_idx]=d[rg_idx];
					d[rg_idx]=tmp;//然后继续排序过程
				}else {
					break;//不满足则跳出排序while
				}
			}
			
			//整理
			if(lf_idx>=rg_idx) {//若lf_idx大于等于rg_idx
				tmp=d[lf];
				d[lf]=d[rg_idx];
				d[rg_idx]=tmp;
				//以rg_idx为基准点分成左右两半
				quick(d,size,lf,rg_idx-1);//用递归方式分别为左右两半排序
				quick(d,size,rg_idx+1,rg);//直到完成排序
			}
		}
	}
}
