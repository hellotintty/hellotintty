package fourthweek;
/*
 * 相容关系的聚类算法
 */

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;

public class Main {
	public static void main(String[] arge) {
		CreatObjects cob=new CreatObjects();
		cob.setName();
		ArrayList<Object> objects=new ArrayList<Object>();
		objects=cob.importObjects();
		Scanner in=new Scanner(System.in);
		CreatD d=new CreatD();
		int[][] D1=d.importD();
		System.out.println("根据你的输入，关系度量D如下图");
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(D1[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.print("请输入阈值α：");
		int temp1=in.nextInt();
		System.out.print("请输入阈值β：");
		int temp2=in.nextInt();
		Compclustering compclustering=new Compclustering(D1, objects, temp1, temp2);
		ArrayList<ArrayList> list=new ArrayList<ArrayList>();
		list=compclustering.complete();
		System.out.print("SC:");
		System.out.print("{");
		for(int i=0;i<list.size();i++) {
			System.out.print("{ ");
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j).toString()+" ");
			}
			System.out.print("}");
		}
		System.out.print("}");
	}
}
