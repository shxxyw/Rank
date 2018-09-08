import java.io.*;
//利用链表实现插入，减少插入造成的复杂度
public class insert_for_order {
	 int data[]=new int [6];
	 int   size=6;
	public static void main(String[] args) {
		insert_for_order test = new insert_for_order();
		test.inputarr();
		System.out.print("您输入的原始数组是：");
		test.showdata();
		test.insert();
	}
	
	 void  inputarr() {
		int i;
		for(i=0;i<size;i++) {
			try {
				System.out.print("请输入第"+(i+1)+"个元素");
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
		 int i;//扫描次数
		 int j;//用以定位比较的元素
		 int tmp;//暂存数据
		 for(i=1;i<size;i++) {//扫描循环次数size-1
			 tmp=data[i];
			 j=i-1;
			 
			 while(j>=0 && tmp<data[j]) {//第二元素小于第一个元素
				 data[j+1]=data[j];//所有元素往后推一个位置
				 j--;
			 }
			 data[j+1]=tmp;//最小元素放第一个元素
			 System.out.print("第"+i+"次扫描：");
			 showdata();
		 }
	 }
}
