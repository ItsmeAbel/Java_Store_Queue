package lab4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Store extends JFrame implements ActionListener {
	
	
	//Variabler
	private JButton addP, toQ1, toQ2, toXit, toQXit1, toQXit2;
	private JPanel p, g, g1, g2, g3, k, k1, k2;
	private JTextField skriva1, skriva2;
	private JLabel namnet, varorna, Q, choosePerson, namn, seeQ1, seeQ2;
	private JList<Person> list, Qlist1, Qlist2;
	//private JList qlist;
	//lista som ska hålla objekt av typen Person, dvs kunderna.
	private DefaultListModel <Person> DLM, Q1, Q2;
	
	private Kassako queue1, queue2;
	private String[] b = {"addP", "toQ1", "toQ2", "toXit", "toQXit1", "toQXit2"};
	//minsta- och orginalstorlek på rutan
	private int X = 600;
	private int Y = 500;
	//antalet kunder
	private int pCount = 0;
	
	private int intCheck;
	
	public Store() {
		super("Affär");
		//sätter storlek och minsta storlek på rutan
		this.setSize(X, Y);
		this.setMinimumSize(new Dimension(X, Y));
		//skapar paneler inne i rutan för placering
		panel();
		//skapar innehållet i panel g1, det som logger till en ny person
		skapaNy();
		//skapar innehållet i panel g2, det som väljer vad som honder med vald person
		skickaBort();
		//skapar innehållet i panel g3, dor en person väljs for användning
		chooseP();
		
		queue1();
		
		queue2();
		
		this.setVisible(true);
	}
	
	public void skapaNy() {
		//skapar textfält för namn och varor input
		skriva1 = new JTextField(7);
		skriva2 = new JTextField(7);
		
		//skapar en knapp samt för den att gora det i b[0] i ActionPerformed
		addP = new JButton("Lägg till");
		addP.addActionListener(this);
		addP.setActionCommand(b[0]);
		
		namnet = new JLabel("Namn");
		namnet.setLabelFor(skriva1);
		varorna = new JLabel("Antal Varor");
		varorna.setLabelFor(skriva2);
		
		g1.setLayout(new FlowLayout());
		g1.add(namnet);
		g1.add(skriva1);
		g1.add(varorna);
		g1.add(skriva2);
		g1.add(addP);
	}
	
	public void skickaBort() {
		g2.setLayout(new FlowLayout());
		Q = new JLabel("Skicka Till:");
		Q.setLabelFor(toQ1);
		namn = new JLabel("");
		toQ1 = new JButton("Kö 1");
		toQ2 = new JButton("Kö 2");
		toXit =new JButton("Utgång");
		
		toQ1.addActionListener(this);
		toQ2.addActionListener(this);
		toXit.addActionListener(this);
		toQ1.setActionCommand(b[1]);
		toQ2.setActionCommand(b[2]);
		toXit.setActionCommand(b[3]);

		g2.add(Q);
		g2.add(toQ1);
		g2.add(toQ2);
		g2.add(toXit);
		g2.add(namn);

	}
	
	public void chooseP() {
		g3.setLayout(new FlowLayout());
		choosePerson = new JLabel("Välj Person:");
		choosePerson.setLabelFor(list);
		
		DLM = new DefaultListModel<Person>();
		list = new JList<Person>(DLM);
				
		JScrollPane pane = new JScrollPane(list);
		list.setVisibleRowCount(7);
		list.setFixedCellWidth(75);
		
		g3.add(choosePerson);
		g3.add(pane);
		
	}
	
	public void panel() {
		p = new JPanel();
		p.setBackground(java.awt.Color.LIGHT_GRAY);
		this.add(p);
		
		g = new JPanel();
		g.setPreferredSize(new Dimension(X/6,Y));
		g.setLayout(new GridLayout(3,1));
		this.add(g, BorderLayout.WEST);
		
		g1 = new JPanel();
		g2 = new JPanel();
		g3 = new JPanel();
		g.add(g1);
		g.add(g2);
		g.add(g3);		
		
		g1.setBackground(java.awt.Color.GRAY.brighter());
		g2.setBackground(java.awt.Color.GRAY.brighter());
		g3.setBackground(java.awt.Color.GRAY.brighter());
		g.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		k = new JPanel();
		k.setLayout(new GridLayout(1,2));
		this.add(k, BorderLayout.CENTER);
		
		
		k1 = new JPanel();
		k2 = new JPanel();
		k.add(k1);
		k.add(k2);
		k1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		k2.setBorder(BorderFactory.createLineBorder(Color.black, 1));		
		
	}
	
	public void queue1() {
		k1.setLayout(new FlowLayout());
		queue1 = new Kassako();
		seeQ1 = new JLabel("         Kö 1          ");
		seeQ1.setLabelFor(list);
	
		Qlist1 = new JList<Person>(queue1.getQ());

		JScrollPane Qpane1 = new JScrollPane(Qlist1);
		Qlist1.setVisibleRowCount(22);
		Qlist1.setFixedCellWidth(180);
		
		toQXit1 = new JButton("Utgång Kö 1");
		toQXit1.addActionListener(this);
		toQXit1.setActionCommand(b[4]);
		
		k1.add(seeQ1);
		k1.add(Qpane1);
		k1.add(toQXit1);
		
			
	}
	
	public void queue2() { 
		k2.setLayout(new FlowLayout());
		queue2 = new Kassako();
		seeQ2 = new JLabel("         Kö 2          ");
		seeQ2.setLabelFor(list);
	
		Qlist2 = new JList<Person>(queue2.getQ());

		JScrollPane Qpane2 = new JScrollPane(Qlist2);
		Qlist2.setVisibleRowCount(22);
		Qlist2.setFixedCellWidth(180);
		
		toQXit2 = new JButton("Utgång Ko 2");
		toQXit2.addActionListener(this);
		toQXit2.setActionCommand(b[5]);
		
		k2.add(seeQ2);
		k2.add(Qpane2);
		k2.add(toQXit2);
	}
	
	
	
	public static void main(String[] args) {
		Store s = new Store();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(b[0].equals(arg0.getActionCommand())) {
			addP();
			
		}else if(b[1].equals(arg0.getActionCommand())) {
			toQ1();
			
		} else if(b[2].equals(arg0.getActionCommand())) {
			toQ2();
			
		}else if(b[3].equals(arg0.getActionCommand())) {
			toXit();
		
		}else if(b[4].equals(arg0.getActionCommand())) {
			toQXit1();
			
		}else if(b[5].equals(arg0.getActionCommand())) {
			toQXit2();
				
		}
	}
	
	public void toQXit1() {
		if(queue1.isEmpty()) {
			System.out.println("ingen i kön");
		}else {
			System.out.println(queue1.getQ().elementAt(0) + " lämnade affären");
			queue1.remove();
		}
	}
	
	public void toQXit2() {
		if(queue2.isEmpty()) {
			System.out.println("ingen i kön");
		}else {
			System.out.println(queue2.getQ().elementAt(0) + " lämnade affären");
			queue2.remove();
		}
	}
	
	public void toXit() {
		
		if(list.isSelectionEmpty()) {
			System.out.println("Ingen Person Vald");
		}else {
			for(int i = list.getSelectedIndex() +1; i<pCount ; i++) {
				DLM.getElementAt(i).setIndx(DLM.getElementAt(i).getIndx()-1);
			}
			pCount--;
			System.out.println(DLM.getElementAt(list.getSelectedIndex()).getName() +" Till Utgång");
			DLM.removeElementAt(list.getSelectedIndex());
		}
	}
	
	public void toQ1() {
		
		if(list.isSelectionEmpty()) {
			System.out.println("Ingen Person Vald");
		}else {
			for(int i = list.getSelectedIndex() +1; i<pCount ; i++) {
				DLM.getElementAt(i).setIndx(DLM.getElementAt(i).getIndx()-1);
			}
			pCount--;
			System.out.println(DLM.getElementAt(list.getSelectedIndex()).getName() +" Till Kö 1");
			queue1.add(DLM.getElementAt(list.getSelectedIndex()));
			DLM.removeElementAt(list.getSelectedIndex());
			queue1.showQ();
		}
	}
	
public void toQ2() {
		
		if(list.isSelectionEmpty()) {
			System.out.println("Ingen Person Vald");
		}else {
			for(int i = list.getSelectedIndex() +1; i<pCount ; i++) {
				DLM.getElementAt(i).setIndx(DLM.getElementAt(i).getIndx()-1);
			}
			pCount--;
			System.out.println(DLM.getElementAt(list.getSelectedIndex()).getName() +" Till Kö 2");
			queue2.add(DLM.getElementAt(list.getSelectedIndex()));
			DLM.removeElementAt(list.getSelectedIndex());
			queue2.showQ();
		}
	}
	
	public void addP() {
		//addP
		if(skriva1.getText().isEmpty() == false) {
			skriva1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			if(skriva2.getText().isEmpty() == false) {
				try{
					intCheck = Integer.parseInt(skriva2.getText());
					DLM.add(pCount, new Person(skriva1.getText().toString(), intCheck, pCount) );
					pCount++;
					System.out.println("Person Tillagd: " + skriva1.getText());
					System.out.println("Antal Varor: " + skriva2.getText());
					skriva1.setText("");
					skriva2.setText("");
					skriva2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
				}catch(Exception e) {
					System.out.println("Skriv antal varor i siffror!??!");
					skriva2.setText("");
					skriva2.setBorder(BorderFactory.createLineBorder(Color.red, 1));
					skriva2.requestFocus();
				}
				
			}else {
				System.out.println("Skriv in antalet varor");
				skriva2.setBorder(BorderFactory.createLineBorder(Color.red, 1));
				skriva2.requestFocus();
			}
		}else {
			System.out.println("Skriv in ett namn");
			skriva1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			skriva1.requestFocus();
		}
	}

	

}
