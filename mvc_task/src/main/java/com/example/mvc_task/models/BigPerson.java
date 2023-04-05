package com.example.mvc_task.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class BigPerson extends Person{

	/*
	 * 	Atributes
	 */
	private List<Person> childerns = new ArrayList<Person>();


	public List<Person> getChilderns() {
		return childerns;
	}

	public void setChildern(Person perosn) {
		List<Person> oldList = this.childerns;
		this.childerns.add(perosn);
		System.out.println("invoking");

		PropertyChangeEvent event = new PropertyChangeEvent(this, "ChildrenAdded", null, childerns);
		super.getPCS().firePropertyChange(event);
		
//		super.getPCS().firePropertyChange("ChildernAdded", oldList, childerns);

	}
	public int getChildCount() {
		return childerns.size();
	}
	public Person getChildAt(int index) {
		try {
			Person person = childerns.get(index);
			return person;
		}
		catch (Exception e) {
			System.out.println("Child not found");
			return null;
		}
	}
	
	public void addChildAt(int index,Person person) {
		childerns.add(index, person);
	}
	
	public String removeChildAt(int index) {
		try {
			Person person = childerns.remove(index);
			return "Removed Successfully!!!";
		}
		catch (Exception e) {
			return "Child not found";
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.getPCS().addPropertyChangeListener(listener);
    }
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		super.getPCS().removePropertyChangeListener(listener);
}
}
