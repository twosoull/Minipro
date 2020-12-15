package com.javaex.add.method;

import java.util.ArrayList;
import java.util.List;

public class Plist {
	//field
	List<Person> list = new ArrayList<Person>();
	
	//constructor
	public List<Person> getList() {
		return list;
	}
	
	public void setList(List<Person> list) {
		this.list = list;
	}

	// method
	public void add(Person p) {
		
		list.add(p);
	}
	
	public void readList() {
		for (int i = 0; i < list.size(); i++) {

			System.out.println((list.indexOf(list.get(i)) + 1) + ".   " + list.get(i).toString());

		}
	}

	public void searchList(String searchName) {
		for (int i = 0; i < list.size(); i++) {
			try {
				int a = list.get(i).getName().indexOf(searchName);
				if (a != -1) {
					System.out.println((list.indexOf(list.get(i)) + 1) + ".   " + list.get(i).toString());
				}
			} catch (Exception e) {

				continue;
			}

		}
	}

	public void removeList(int a) {
		list.remove(a - 1);
	}


}
