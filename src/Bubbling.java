
public class Bubbling {
	public static void main(String[] args) {
		int i,j,tmp;
		int data[]= {6,5,9,7,2,8};//原始数据
		
		System.out.println("冒泡排序");
		System.out.println("原始数据为：");
		for(i=0;i<6;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		for(i=5;i>0;i--) {//扫描次数
			for(j=0;j<i;j++) {//比较交换次数
				if(data[j]>data[j+1]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
				}		
			}
			//把各次的结果输出
			System.out.println("第"+(6-i)+"次排序后的结果是：");
			for(j=0;j<6;j++) {
				System.out.print(data[j]+" ");
			}
			System.out.println();
		}
	}
}
