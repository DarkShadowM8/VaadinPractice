package com.example.mvc_task.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.example.mvc_task.enums.Gender;

public class Person {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	
	/*
	 * 	PropertyChangeSupport is used to make the changes in editor or whereever it is used 
	 * 	by using it's firepropertyChange method. whenever there's a change in bean properties
	 * 	it will update the views
	 */
	private PropertyChangeSupport pcs;
	
	public Person(){
		pcs = new PropertyChangeSupport(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("Id updated!!");
		int oldId = this.id;
		this.id = id;
		pcs.firePropertyChange("setId", oldId, id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		pcs.firePropertyChange("setName", oldName, name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		int oldAge = this.age;
		this.age = age;
		pcs.firePropertyChange("setAge", oldAge, age);
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		Gender oldGender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange("setGender", oldGender, gender);
	}
	public void setGender(String gender) {
		if (gender.equals("Male"))
			setGender(Gender.Male);
		else if (gender.equals("Female"))
			setGender(Gender.Female);
		else
			setGender(Gender.Other);
	}
	public PropertyChangeSupport getPCS() {
		return this.pcs;
	}
	
	/*
	 * 	addPropertyChangeListener method is to add a listner
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
	
	/*
	 * 	removePropertyChangeListener method is to remove a listner
	 */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    		pcs.removePropertyChangeListener(listener);
    }
}
