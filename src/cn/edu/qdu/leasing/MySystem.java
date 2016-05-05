package cn.edu.qdu.leasing;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MySystem {
	private int[] leaseDays;
	private Set<Integer> numPlate=new HashSet<>();;
	
	public void showTitle() {
		System.out.println("\t***************************");
		System.out.println("\t*** 欢迎进入汽车租赁系统   ***");
		System.out.println("\t***************************\n");
	}

	public int askNumOfRent(Scanner input) {
		System.out.print("请输入您要租赁车辆总数：");
		int numOfRent = input.nextInt();
		return numOfRent;
	}
	
	public Moto[] rentMoto(Scanner input,int numOfRent){
		Moto[] motos=new Moto[numOfRent];
		String[] type={"奔驰","宝马","别克"};
		this.leaseDays=new int[numOfRent];
		for (int i = 0; i < motos.length; i++) {
			System.out.println("\n租赁车型:");
			System.out.println("\t1.轿车");
			System.out.println("\t2.客车");
			System.out.print("请输入您要租赁第"+(i+1)+"辆车的车型（对应的编号）：");
			int selectCode=input.nextInt();
			switch (selectCode) {
			case 1:
				System.out.println("\n*********  轿车     *********");
				System.out.println("编号\t类型 ");
				System.out.println("1.\t奔驰");
				System.out.println("2.\t宝马");
				System.out.println("3.\t别克");
				System.out.print("\n请输入您要租赁的轿车类型（相应的编号）：");
				selectCode=input.nextInt();
				motos[i]=new Car(type[selectCode-1],getNumberPlate());
				break;
			case 2:
				System.out.println("\n*********  客车     *********");
				System.out.println("编号\t类型 ");
				System.out.println("1.\t<=16座");
				System.out.println("2.\t>16座");
				System.out.print("\n请输入您要租赁的轿车类型（相应的编号）：");
				selectCode=input.nextInt();
				motos[i]=new Bus(selectCode==1?13:19,getNumberPlate());
				break;
			}
			System.out.print("\n请输入租赁天数（>0）：");
			leaseDays[i]=input.nextInt();
		}
		return motos;
	}
	public void showRentList(Moto[] motos){
		double totalPrice=0;
		System.out.println("\n***************************");
		System.out.println("编号\t车型\t\t车牌号\t日租金\t天数\t租金");
		for (int i = 0; i < motos.length; i++) {
			System.out.print(i+1+"\t");
			double rentPrice=motos[i].totalRental(leaseDays[i]);
			totalPrice+=rentPrice;
			if(motos[i] instanceof Car){
				Car car=(Car)motos[i];
				System.out.println("轿车（"+car.getType()+"）\t"+car.getNumPlate()+"\t"+car.getDailyRental()+"\t"+leaseDays[i]+"\t"+rentPrice);
			}else{
				Bus bus=(Bus)motos[i];
				System.out.println("客车（"+bus.getSeatsCount()+"座）\t"+bus.getNumPlate()+"\t"+bus.getDailyRental()+"\t"+leaseDays[i]+"\t"+rentPrice);
			}
		}
		System.out.println("---------------------------");
		System.out.println("总计：\t\t\t"+totalPrice);
	}
	
	private String getNumberPlate(){
		String result=null;
		int numberPlate=0;
		int size=0;
		Random rd=new Random();
		do {
			numberPlate=rd.nextInt(1000);
			numPlate.add(numberPlate);
		} while (size==numPlate.size());
		if (numberPlate/10==0) {
			result="00"+numberPlate;
		}else if(numberPlate/100==0){
			result="0"+numberPlate;
		}else{
		result=""+numberPlate;
		}
		return "B"+result;
	}
	
	public static void main(String[] args) {
		MySystem ms=new MySystem();
		ms.showTitle();
		Scanner input=new Scanner(System.in);
		int numOfRent=ms.askNumOfRent(input);
		Moto[] motos=ms.rentMoto(input,numOfRent);
		ms.showRentList(motos);
		input.close();
	}

}
