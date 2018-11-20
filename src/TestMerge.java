
public class TestMerge {
	
public static void main(String[] args) {
	int [] data = {4,2,1,6,3,6,0,-5,1,1};
	int i;
	mergeSort(data,0,data.length-1);
	
	for(i=0;i<10;i++)
		System.out.print(data[i]+" ");
}

public static void mergeSort(int [] array,int start,int end) {
	//二路归并
	if(start<end) {
		int mid = (start+end)/2;
		mergeSort(array,start,mid);
		mergeSort(array,mid+1,end);
		merge(array,start,mid,mid+1,end);
	}
	
	 /*多路归并
	 int mid = (start+end)/4;
	 mergeSort(array,start,1*mid);
	 mergeSort(array,1*mid+1,2*mid);
	 mergeSort(array,2*mid+1,3*mid);
	 mergeSort(array,3*mid+1,end);
	 merge(array,start,1*mid,1*mid+1,2*mid);
	 merge(array,2*mid+1,3*mid,3*mid+1,end);
	 merge(array,start,2*mid,2*mid+1,end);
	 */
}

public static void merge(int []array,int start1,int end1,int start2,int end2) {
	int i,j;//分别为表1和表2的游标
	i=start1;
	j=start2;
	int k=0;
	int [] temp = new int[end2-start1+1];//建立一个临时长度为两个子列表长度之和的数组
	while (i<=end1 && j<=end2) {//循环将两个子列表中较小元素放入数组
		if(array[i]>array[j]) {
			temp[k++]=array[j++];
		}else {
			temp[k++]=array[i++];
		}
	}
	//把剩下元素放入临时数组
	while(i<=end1) {
		temp[k++]=array[i++];
	}
	while(j<=end2) {
		temp[k++]=array[j++];
	}	
	
	k=start1;
	for(int element:temp) {//把临时数组元素赋值给原来的数组
		array[k++]=element;
	}
}

}
