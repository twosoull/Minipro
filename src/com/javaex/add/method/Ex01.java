package com.javaex.add.method;

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
		Plist plist = new Plist();
		
		// Input
		InputStream is = new FileInputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		// end Input

		String info = "";

		// 불러온 파일 리스트에 넣기
		while (true) {

			if ((info = br.readLine()) != null) {
				String[] infoArray = info.split(",");
				Person p1 = new Person(infoArray[0], infoArray[1], infoArray[2]);
				plist.add(p1);
			} else {
				break;
			}
		}
		// 불러온 파일 리스트에 넣기 end

		System.out.println("*************************************");
		System.out.println("*       전화번호 관리 프로그램      *");
		System.out.println("************************************* ");
		while (power) {
			
			// Output

			OutputStream os = new FileOutputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (Person p : plist.list) {
				bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
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
				
				// 리스트 읽기
				plist.readList();
				//end 리스트 일기 
		
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
				
				// 등록 후 리스트에 넣기
				plist.add(p2);
				// end 등록 후 리스트에 넣기

				System.out.println("[등록되었습니다.]");
				break;
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호 :");
				int removePersonInfo = sc.nextInt();
				
				// 삭제
				plist.removeList(removePersonInfo);
				// end 삭제
				
				System.out.println("[삭제되었습니다.]");
				break;
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름 :");
				String ss = sc.nextLine();
				String searchName = sc.nextLine();

				// 검색하기
				plist.searchList(searchName);
				// end 검색
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
