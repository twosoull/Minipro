package com.javaex.miniproject.repractice;

import java.util.ArrayList;
import java.util.List;

public class PVList {
	// field
	List<PhoneVo> plist = new ArrayList<PhoneVo>();

	// constructor
	public PVList() {
	
	}

	// method g/s
	public List<PhoneVo> getPlist() {
		return plist;
	}

	public void setPlist(List<PhoneVo> plist) {
		this.plist = plist;
	}

	// method
	public void addList(PhoneVo p) {
		plist.add(p);

	}

	public void resisterList(PhoneVo p) {
		plist.add(p);
	}

	public void removeList(int a) {
		plist.remove(a - 1);
		System.out.println("[삭제되었습니다.]");
	}

	public void search(String name) {
		int count = 0;
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getName().indexOf(name) != -1) {
				System.out.println(show(i));
				count++;
			}
		}
		if(count==0){
			System.out.println("정보가 없습니다");
		}
	}

	public void showInfo() {
		for (int i = 0; i < plist.size(); i++) {
			System.out.println(show(i));
			
		}
	
		System.out.println();
	}

	public String show(int i) {

		return  (plist.indexOf(plist.get(i))+1)+".   " + plist.get(i).getName() + "   " + plist.get(i).getHp() + "   " + plist.get(i).getCompany();
	}
}
