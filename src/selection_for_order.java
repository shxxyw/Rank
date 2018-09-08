
public class selection_for_order {
	static int data[]= {9,7,5,3,4,6};
	public static void main(String[] args) {
		System.out.print("原始数据为：");
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
		for(i=0;i<5;i++) {//做五次排序
			tmp=data[i];
			k=i;
			for(j=i+1;j<6;j++) {//寻找最小值		
				if(tmp>data[j]) {
	            tmp=data[j];
	            k=j;//记录交换的位置
				}
			}
			data[k]=data[i];
			data[i]=tmp;
			
			//打印每次排序完的结果
			System.out.print("第"+(i+1)+"次排序的结果：");
			for(int m=0;m<6;m++) 
				System.out.print(data[m]+" ");
			System.out.println();
			
		}
	}
}
