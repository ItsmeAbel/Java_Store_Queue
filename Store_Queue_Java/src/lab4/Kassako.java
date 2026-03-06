package lab4;

import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class Kassako {

	private Queue<Person> q;
	private DefaultListModel<Person> Q;

	public Kassako() {
		q = new LinkedList<Person>();
		Q = new DefaultListModel<Person>();
	}

	public DefaultListModel<Person> getQ() {
		return Q;

	}

	public void add(Person p) {
		q.add(p);
		Q.addElement(p);
	}

	public void remove() {
		Q.removeElement(q.element());
		q.remove();

	}

	public void peek() {
		q.element();
	}

	public void showQ() {
		System.out.println(q);
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}
}
