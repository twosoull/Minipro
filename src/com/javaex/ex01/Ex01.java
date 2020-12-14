package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		boolean power = true;

		Scanner sc = new Scanner(System.in);

		List<Person> list = new ArrayList<Person>();
		// Input
		InputStream is = new FileInputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		while (true) {
			String info = br.readLine();

			if (info == null) {
				break;
			}
			String[] infoArray = info.split(",");
			Person p1 = new Person(infoArray[0], infoArray[1], infoArray[2]);
			list.add(p1);
		}
		System.out.println("*************************************");
		System.out.println("*       전화번호 관리 프로그램      *");
		System.out.println("************************************* ");
		while (power) {

			// 정보의 카운트
			int number = 1;
			// Output
			OutputStream os = new FileOutputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
				bw.newLine();
				bw.flush();
			}
			bw.close();
			// Output end
			// 잘못된 메뉴번호

			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5. 종료");
			System.out.println("-------------------------------------");
			System.out.print(">메뉴번호:");
			int selectNumber = sc.nextInt();

			switch (selectNumber) {
			case 1:

				System.out.println("<1.리스트>");

				for (int i = 0; i < list.size(); i++) {
					System.out.print(number + ".    ");
					list.get(i).draw();
					number++;
				}
				br.close();
				// Input end

				break;
			case 2:
				System.out.println("2.등록");
				System.out.print(">이름:");
				String na = sc.nextLine();
				String name = sc.nextLine();
				System.out.print(">휴대전화:");
				String hp = sc.nextLine();
				System.out.print(">회사전화:");
				String company = sc.nextLine();

				Person p2 = new Person(name, hp, company);
				list.add(p2);

				System.out.println("[등록되었습니다.]");

				break;
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호 :");
				int removePersonInfo = sc.nextInt();
				list.remove(removePersonInfo - 1);
				System.out.println("[삭제되었습니다.]");
				break;
			case 4:
				System.out.println("검색입니다");
				System.out.print(">이름 :");
				String searchName = sc.nextLine();

				for (int i = 0; i < list.size(); i++) {
					try {
						int a = list.get(i).getName().indexOf(searchName);
						if (a > 0) {
							list.get(i).draw();
						}
					} catch (Exception e) {
						continue;
					}

				}
				System.out.println("??");
				break;
			case 5:
				System.out.println("종료입니다");
				power = false;
				break;
			default:
				System.out.println("[다시입력해주세요]");

			}
		}
	}
}
