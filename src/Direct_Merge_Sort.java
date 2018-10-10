/**
 * 测试外部排序中的直接合并排序法
 * @author shxxy
 *	        因为外部排序数据量大内存一次不能够完成排序，故将其分为多个内存可处理的小组，在小组中使用内部排序方法先排好序
 *	然后使用直接合并法排序对每一个小块进行两两合并，不断合并，最后得出结果
 */
import java.io.*;

public class Direct_Merge_Sort {
	public static void main(String[] args) throws Exception {
		String filep="data.txt";//eclipse中的默认目录是C:\Users\shxxy\Desktop\code\Rank其下一级目录
		String filep1="data1.txt";
		String filep2="data2.txt";
		//声明文件指针  每一个指针对应相关文件
		File fp = new File(filep);
		File fp1 = new File(filep1);
		File fp2 = new File(filep2);
		
		BufferedReader pfile = new BufferedReader(new FileReader(fp));
		BufferedReader pfile1 = new BufferedReader(new FileReader(fp1));
		BufferedReader pfile2 = new BufferedReader(new FileReader(fp2));
		
		//判断文件情况
		if(!fp.exists())
			System.out.println("开启主文件失败");
		else if(!fp1.exists())
			System.out.println("开启数据文件1失败");//开启文件成功时候指针会返回FILE文件
		else if(!fp2.exists())
			System.out.println("开启数据文件2失败");//开启文件失败返回NULL
		else {
			System.out.print("数据排序中。。。。。。\n");
			merge(fp,fp1,fp2);
			System.out.print("数据处理完成！！\n");
		}
		
		System.out.print("data1.txt 数据内容为： \n");
		char str;
		int str1;
		while (true) {
			str1=pfile1.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		System.out.print("data2.txt 数据内容为： \n");
		while (true) {
			str1=pfile2.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		System.out.print("排序后data.txt 数据内容为： \n");
		while (true) {
			str1=pfile.read();
			str=(char) str1;
			if(str1==-1)
				break;
			System.out.print("["+str+"]");
		}
		System.out.println();
		
		//关闭文件
		pfile.close();
		pfile1.close();
		pfile2.close();
		
	}
	
	public static void merge(File p,File p1,File p2)throws Exception{
		char str1,str2;
		int n1,n2;//声明变量n1，n2暂存数据文件data1及data2内的元素值
		
		BufferedWriter pfile = new BufferedWriter(new FileWriter(p));
		BufferedReader pfile1 = new BufferedReader(new FileReader(p1));
		BufferedReader pfile2 = new BufferedReader(new FileReader(p2));	
		
		n1=pfile1.read();
		n2=pfile2.read();
		
		//判断是否已经到达文件尾
		while(n1!=-1 && n2!=-1) {
			if(n1<=n2) {
				str1 = (char) n1;
				pfile.write(str1);//如果n1比较小，则把n1存到fp里
				n1=pfile1.read();//接着读下一个n1
			}else {
				str2 = (char) n2;
				pfile.write(str2);
				n2=pfile2.read();
			}
		}
		
		//对于剩余下来的一些字段的处理
		if(n2 != -1) {
			while (true) {
				if(n2==-1)
					break;
				str2=(char) n2;
				pfile.write(str2);
				n2=pfile2.read();
			}
		}
		if(n1 != -1) {
			while(true) {
				if (n1 ==-1)
					break;
				str1= (char) n1;
				pfile.write(str1);
				n1=pfile2.read();
			}
		}
		
		pfile.close();
		pfile1.close();
		pfile2.close();
	}
}
