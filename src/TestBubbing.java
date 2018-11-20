import java.io.*;


public class TestBubbing {
public static void main(String[] args) throws IOException {
	int data[] = new int[10];
	int i;
	String line;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader (isr);
	for(i=0;i<10;i++) {
		if((line=br.readLine())!=null)
			data[i]=Integer.parseInt(line);
	}
	
	Bubbling_better_program(data);//传一个数组给方法是传一个数组的引用，在方法中改变数组原数组也变了
	
	for(i=0;i<10;i++) {
		System.out.print(data[i]+" ");
	}
}

public static void Bubbling_better_program (int [] source) {
	int Length = source.length;
	int i,j,Tag=0,temp;
	for(i=0;i<Length;i++) {
		for(j=i;j<Length-1;j++) {
			Tag=0;
			if(source[j]>source[j+1]) {
				Tag++;
				temp=source[j];
				source[j]=source[j+1];
				source[j+1]=temp;
			}
		}
		if(Tag==0)
			break;
	}
	
}
}
