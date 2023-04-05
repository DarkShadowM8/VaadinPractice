package com.example.mvc_task.views;

import java.beans.PropertyChangeEvent;

import com.example.mvc_task.models.BigPerson;
import com.example.mvc_task.models.Person;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class BigPersonEditor extends PersonEditor{


	private Button add;
	private Button remove;
	private BigPerson bigPerson;
	HorizontalLayout hl,hl2 = new HorizontalLayout();
	
	public BigPersonEditor(BigPerson bPerson) {
		super(new Person());
		this.bigPerson = bPerson;
		initUI();
	}

	private void initUI() {
		
		bigPerson.addPropertyChangeListener(this);
		
		add = new Button("Add");
		add.setImmediate(true);
		update(add);
		
		remove = new Button("Remove");
		remove.setImmediate(true);
		
		
		hl = new HorizontalLayout();
		hl.addComponent(add);
		hl.addComponent(remove);

		hl.setSpacing(true);
		
		addComponent(hl);
	}
	private void update(final Button fieldName){
		fieldName.addListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
            	if(fieldName.getCaption().equals("Add")) {
            		bigPerson.setChildern(getPerson());
            	}
            		
            	else if(fieldName.getCaption().equals("Remove"))
            		bigPerson.getChilderns().remove(getPerson());
            	
			}
		});
    }
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		if (evt.getPropertyName().equals("ChildrenAdded")) {
			addComponent( new ChildrenView(getPerson(), bigPerson.getName()));
		}
		
		super.propertyChange(evt);
	}
}
