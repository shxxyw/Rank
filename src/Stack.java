//测试堆积法排序
/*
 * 时间复杂度nlogn
 * 空间复杂度1
 */
import java.io.*;
public class Stack {
	public static void main(String[] args) {
		int i,size,data[]= {0,5,6,4,8,3,2,7,1};//原始数组内容 0不参加排序
		size=9;
		System.out.print("原始数组： ");
		for(i=1;i<size;i++)
			System.out.print("["+data[i]+"] ");
		heap(data,size);
		System.out.print("\n排序结果： ");
		for(i=1;i<size;i++)
			System.out.print("["+data[i]+"] ");
		System.out.println();
	}
	
	public static void heap(int data[],int size) {
		int i,j,tmp;
		for(i=(size/2);i>0;i--)//建立堆积树节点 取一半是为了防止由于树跟比子树大从而出现子树的子树存在较大情况而引起的忽略
			ad_heap(data,i,size-1);
		System.out.print("\n堆积内容：");//println是输出完换行  ;\n堆积内容： 是换行再输出
		for(i=1;i<size;i++)//原始堆积树内容
			System.out.print("["+data[i]+"] ");
		System.out.println();
		
		//堆积排序过程
		for(i=size-2;i>0;i--) {
			tmp=data[i+1];//头尾节点交换
			data[i+1]=data[1];
			data[1]=tmp;
			ad_heap(data,1,i);//处理剩余节点
			System.out.print("\n处理过程： ");
			for(j=1;j<size;j++)
				System.out.print("["+data[j]+"] ");
			
		}
	}
	
	//对data 数组 i位置在size范围内，以i为树根，找寻其子树与树跟的大小进行排序
	public static void ad_heap(int data[],int i,int size) {
		int j,tmp,post;
		j=2*i;
		tmp=data[i];
		post=0;
		while(j<=size && post==0) {
			
			if(j<size) {
				if(data[j]<data[j+1])//找出最大节点
					j++;
			}
		
			//树跟与子树比较
			if(tmp>=data[j]) {
				post=1;//若树根较大，结束比较过程
			}else {
				data[j/2]=data[j];//若树跟较小则继续比较
				j=2*j;
			}
		}
		data[j/2]=tmp;
	}
}
