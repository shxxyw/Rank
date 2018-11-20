
public class TestMerge {
	
public static void main(String[] args) {
	int [] data = {4,2,1,6,3,6,0,-5,1,1};
	int i;
	mergeSort(data,0,data.length-1);
	
	for(i=0;i<10;i++)
		System.out.print(data[i]+" ");
}

public static void mergeSort(int [] array,int start,int end) {
	//��·�鲢
	if(start<end) {
		int mid = (start+end)/2;
		mergeSort(array,start,mid);
		mergeSort(array,mid+1,end);
		merge(array,start,mid,mid+1,end);
	}
	
	 /*��·�鲢
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
	int i,j;//�ֱ�Ϊ��1�ͱ�2���α�
	i=start1;
	j=start2;
	int k=0;
	int [] temp = new int[end2-start1+1];//����һ����ʱ����Ϊ�������б���֮�͵�����
	while (i<=end1 && j<=end2) {//ѭ�����������б��н�СԪ�ط�������
		if(array[i]>array[j]) {
			temp[k++]=array[j++];
		}else {
			temp[k++]=array[i++];
		}
	}
	//��ʣ��Ԫ�ط�����ʱ����
	while(i<=end1) {
		temp[k++]=array[i++];
	}
	while(j<=end2) {
		temp[k++]=array[j++];
	}	
	
	k=start1;
	for(int element:temp) {//����ʱ����Ԫ�ظ�ֵ��ԭ��������
		array[k++]=element;
	}
}

}
