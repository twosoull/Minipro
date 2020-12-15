package com.javaex.miniproject.repractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// 설계
		// 1. DB.txt를 담기위한 PhoneVo 클래스 제작 (일반적인 필드,생성자,g/s 형태로 먼저만들기)
		// 2. PhoneVo의 객체화 후에 순서로 보관하기 위해 list를 만들어줌
		// 3. Main 메소드의 가독성과 코드 재사용성, 그리고 list 관리를 위해 PVList
		// 클래스를 생성해서 list에 관련된 함수들을 메소드형태로 배치해줌
		// 4. 메인코드 작성
		
		
		PVList plist = new PVList();
		Scanner sc = new Scanner(System.in);
		boolean whPower = true;

		//인풋
		InputStream is = new FileInputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String user = "";
		while (true) {
			if ((user = br.readLine()) == null) {
				break;
			}
			String[] pArray = user.split(",");
			PhoneVo phonevo = new PhoneVo(pArray[0], pArray[1], pArray[2]);
			plist.addList(phonevo);
		}

		br.close();


		System.out.println("**********************************");
		System.out.println("*     전화번호 관리 프로그램     *");
		System.out.println("**********************************");

		while (whPower) {
			//반복문 안쪽 배치이유는 번호를 빠져나올 때마다
			//새로운 파일을 만들어 생성과 삭제를 만든다.
			
			OutputStream os = new FileOutputStream("C:\\javaStudy\\Io\\PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

			for (int i = 0; i < plist.plist.size(); i++) {
				bw.write(plist.plist.get(i).toString());
				bw.newLine();
				bw.flush();
			}
			bw.close();
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호:");

			// 1,2,3 수로 배치되는 반복문을 위해 switch case문으로 작성 (다른 반복문과 if를 사용해도 좋음)
			int swPower = sc.nextInt();
			switch (swPower) {

			case 1:
				System.out.println("<1.리스트>");
				plist.showInfo();

				break;
			case 2:
				System.out.println("<2.등록>");
				String enter = sc.nextLine();
				System.out.print(">이름:");
				String name = sc.nextLine();
				System.out.print(">휴대전화:");
				String hp = sc.nextLine();
				System.out.print(">회사전화:");
				String company = sc.nextLine();
				plist.resisterList(new PhoneVo(name, hp, company));

				break;
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호 :");
				int number = sc.nextInt();
				plist.removeList(number);

				break;
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름:");
				String a = sc.nextLine();
				String schName = sc.nextLine();
				plist.search(schName);
				
				break;

			case 5:
				System.out.println();
				System.out.println("**********************************");
				System.out.println("*            감사합니다          *");
				System.out.println("**********************************");

				whPower = false;
				break;

			}

		}
	}
}
