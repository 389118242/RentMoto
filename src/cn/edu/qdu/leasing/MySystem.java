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
		System.out.println("\t*** ��ӭ������������ϵͳ   ***");
		System.out.println("\t***************************\n");
	}

	public int askNumOfRent(Scanner input) {
		System.out.print("��������Ҫ���޳���������");
		int numOfRent = input.nextInt();
		return numOfRent;
	}
	
	public Moto[] rentMoto(Scanner input,int numOfRent){
		Moto[] motos=new Moto[numOfRent];
		String[] type={"����","����","���"};
		this.leaseDays=new int[numOfRent];
		for (int i = 0; i < motos.length; i++) {
			System.out.println("\n���޳���:");
			System.out.println("\t1.�γ�");
			System.out.println("\t2.�ͳ�");
			System.out.print("��������Ҫ���޵�"+(i+1)+"�����ĳ��ͣ���Ӧ�ı�ţ���");
			int selectCode=input.nextInt();
			switch (selectCode) {
			case 1:
				System.out.println("\n*********  �γ�     *********");
				System.out.println("���\t���� ");
				System.out.println("1.\t����");
				System.out.println("2.\t����");
				System.out.println("3.\t���");
				System.out.print("\n��������Ҫ���޵Ľγ����ͣ���Ӧ�ı�ţ���");
				selectCode=input.nextInt();
				motos[i]=new Car(type[selectCode-1],getNumberPlate());
				break;
			case 2:
				System.out.println("\n*********  �ͳ�     *********");
				System.out.println("���\t���� ");
				System.out.println("1.\t<=16��");
				System.out.println("2.\t>16��");
				System.out.print("\n��������Ҫ���޵Ľγ����ͣ���Ӧ�ı�ţ���");
				selectCode=input.nextInt();
				motos[i]=new Bus(selectCode==1?13:19,getNumberPlate());
				break;
			}
			System.out.print("\n����������������>0����");
			leaseDays[i]=input.nextInt();
		}
		return motos;
	}
	public void showRentList(Moto[] motos){
		double totalPrice=0;
		System.out.println("\n***************************");
		System.out.println("���\t����\t\t���ƺ�\t�����\t����\t���");
		for (int i = 0; i < motos.length; i++) {
			System.out.print(i+1+"\t");
			double rentPrice=motos[i].totalRental(leaseDays[i]);
			totalPrice+=rentPrice;
			if(motos[i] instanceof Car){
				Car car=(Car)motos[i];
				System.out.println("�γ���"+car.getType()+"��\t"+car.getNumPlate()+"\t"+car.getDailyRental()+"\t"+leaseDays[i]+"\t"+rentPrice);
			}else{
				Bus bus=(Bus)motos[i];
				System.out.println("�ͳ���"+bus.getSeatsCount()+"����\t"+bus.getNumPlate()+"\t"+bus.getDailyRental()+"\t"+leaseDays[i]+"\t"+rentPrice);
			}
		}
		System.out.println("---------------------------");
		System.out.println("�ܼƣ�\t\t\t"+totalPrice);
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
