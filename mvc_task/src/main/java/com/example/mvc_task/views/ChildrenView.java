package com.example.mvc_task.views;

import com.example.mvc_task.models.Person;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ChildrenView extends VerticalLayout{
	
	private TextField id;
	private TextField name;
	private TextField age;
	private TextField gender;
	private Person person;
	private TextField parentName;
	private HorizontalLayout hl;
	
	public ChildrenView(Person person, String name) {
		this.person = person;
		initUI(name);
	}
	private void initUI(String parent) {
		id = new TextField("ID");	
		id.setValue(person.getId());
		id.setReadOnly(true);
		
		name = new TextField("Name");
		name.setValue(person.getName());
		name.setReadOnly(true);
		
		age = new TextField("Age");
		age.setValue(person.getAge());
		age.setReadOnly(true);
		
		gender = new TextField("Gender");
		gender.setValue(person.getGender());
		gender.setReadOnly(true);
		
		parentName = new TextField("Parent Name");
		parentName.setValue(parent);
		parentName.setReadOnly(true);
		
		hl = new HorizontalLayout();
		
		hl.addComponent(id);
		hl.addComponent(name);
		hl.addComponent(age);
		hl.addComponent(gender);
		hl.addComponent(parentName);
		addComponent(hl);
	}
}
