package com.example.mvc_task;

import com.example.mvc_task.views.BigPersonEditor;
import com.example.mvc_task.views.ChildrenView;
import com.example.mvc_task.views.PersonEditor;
import com.example.mvc_task.enums.Gender;
import com.example.mvc_task.models.BigPerson;
import com.example.mvc_task.models.Person;
import com.vaadin.Application;
import com.vaadin.ui.*;

public class Mvc_taskApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Mvc_task Application");
		Label label = new Label("Hello Vaadin user");
		
		Person person = new Person();
		person.setId(0);
		person.setName("Ali");
		person.setAge(19);
		person.setGender(Gender.Male);
		
		BigPerson bigPerson = new BigPerson();
		bigPerson.setId(0);
		bigPerson.setName("Ali");
		bigPerson.setAge(19);
		bigPerson.setGender(Gender.Male);
		
		PersonEditor editor1 = new PersonEditor(person);
		PersonEditor editor2 = new PersonEditor(person);
		
		BigPersonEditor editor3 = new BigPersonEditor(bigPerson);
		HorizontalLayout hl = new HorizontalLayout();
		
//		hl.addComponent(editor1);
//		hl.addComponent(editor2);
		hl.addComponent(editor3);
		
		hl.setSpacing(true);
		
		mainWindow.addComponent(hl);
		setMainWindow(mainWindow);
	}

}
