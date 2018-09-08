
public class Bubbling_better {
	public static void main(String[] args) {
		int i,j,tmp;
		int data[]= {6,5,9,7,2,8};//原始数据
		
		System.out.println("冒泡排序");
		System.out.println("原始数据为：");
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		data=BubbleSort(data,5);
		
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
	}
	public static int[] BubbleSort(int[] data,int n) {
		int i=n,tmp;
		while(i>0) {//改进算法，若除了第一次比较之外没有其他的比较，则认为排序已完成
			int lastExchangeIndex=0;
			for(int j=0;j<i;j++) {
				if(data[j+1]<data[j]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
					lastExchangeIndex=j;
				}
			}
			i=lastExchangeIndex;
		}
		return  data;
	}
}
