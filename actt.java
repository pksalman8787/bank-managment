import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.*;
/*<applet code="actt" width=600 height=500>
</applet>*/
public class actt extends Applet implements ItemListener,ActionListener
{	Label name_lb,dob_lb,nat_lb,gender,addr_lb,acc_lb,mob_lb,secq_lb,l1,l2,l3,completed_lb;
	TextField name_tx,dob_tx,nat_tx,gen_tx,addr_tx,acc_tx,mob_tx,secq_tx,l1_txt,l2_txt,l3_txt;
	Button total_lb,main_save_button,main_edit_button;
	static String bal_str;
	Image edit_img,save_img;
	boolean sh2draw;
	int i=0,dep_bal,y;
	Choice choice_lan;
	static int balance=34600;
    public void init()
 	  {	
		setLayout(null);	
		choice_lan = new Choice();
		choice_lan.add("PROFILE");
		choice_lan.add("WITHDRAW");
		choice_lan.add("DEPOSIT");
		choice_lan.add("VIEW BALANCE");
		save_img = getImage(getDocumentBase(),"save.png"); 
		edit_img = getImage(getDocumentBase(),"edit.png");
		mainchoice();		
		choice_lan.addItemListener(this);
		add(choice_lan);
		choice_lan.setBounds(480,20,100,30);
  }
	public void mainchoice()
		
{		sh2draw=true;
		repaint();		
		name_lb=new Label("NAME:",Label.CENTER);gender=new Label("GENDER:",Label.CENTER);
		dob_lb=new Label("Date of Birth:",Label.LEFT);acc_lb=new Label("ACCOUNT NO.:",Label.CENTER);
		nat_lb=new Label("NATIONALITY:",Label.CENTER);mob_lb=new Label("Mobile No.:",Label.CENTER);
		addr_lb=new Label("ADDRESS:",Label.CENTER);secq_lb=new Label("Security Question:",Label.CENTER);
		main_save_button=new Button("save");
		main_edit_button=new Button("edit");
		main_edit_button.addActionListener(this);
		main_save_button.addActionListener(this);
		add(main_save_button);add(main_edit_button);
		main_edit_button.setBounds(425,420,50,20);main_save_button.setBounds(510,420,50,20);
		name_tx=new TextField(20);dob_tx=new TextField(20);gen_tx=new TextField(20);
		nat_tx=new TextField(20);secq_tx=new TextField(20);acc_tx=new TextField(20);
		addr_tx=new TextField(20);mob_tx=new TextField(20);		
		add(name_lb);add(name_tx);
		add(acc_lb);add(acc_tx);
		add(dob_lb);add(dob_tx);
		add(nat_lb);add(nat_tx);
		add(gender);add(gen_tx);
		add(mob_lb);add(mob_tx);
		add(addr_lb);add(addr_tx);	
		add(secq_lb);add(secq_tx);
		bal_str = Integer.toString(balance);
		name_lb.setBounds(13,170,60,30);name_tx.setBounds(125,173,140,25);acc_lb.setBounds(298,170,100,30);acc_tx.setBounds(440,173,140,25);
		dob_lb.setBounds(20,230,100,30);dob_tx.setBounds(125,233,140,25);nat_lb.setBounds(295,230,100,30);nat_tx.setBounds(440,233,140,25);
		gender.setBounds(19,300,60,30);gen_tx.setBounds(125,303,140,25);mob_lb.setBounds(288,300,100,30);mob_tx.setBounds(440,303,140,25);	
		addr_lb.setBounds(20,350,60,30);addr_tx.setBounds(125,353,140,25);secq_lb.setBounds(300,350,120,30);secq_tx.setBounds(440,353,140,25);
	default_text();
}
	  public void paint(Graphics g)
    {	
	if(sh2draw==true){
	 g.drawImage(edit_img,405,422, this); 
       	g.drawImage(save_img,490,422,this);	
	}
}
     public void itemStateChanged(ItemEvent ie)
        {
	int b;
	String di;
	String s=choice_lan.getSelectedItem(); 
	if(i==0){
	remm();
	l1=new Label("",Label.CENTER);l2=new Label("",Label.CENTER);l3=new Label("",Label.CENTER);
	l1_txt=new TextField(20);l2_txt=new TextField(20);l3_txt= new TextField(20);}
	else if(i==2){
	remove(completed_lb);remove(total_lb);}
	switch(s)
	{
	case "WITHDRAW":
	remm2(2);
	setLayout(null);
	completed_lb=new Label("",Label.CENTER);
	add(completed_lb);
	y=2;
	total_lb =new Button("deposit");	
	set();
	add(l2);add(l2_txt);add(l3);add(l3_txt);add(total_lb);
	l2.setText("AVAILABLE BALANCE:");l3.setText("AMOUNT:");
	l2.setBounds(62,192,130,30);l2_txt.setBounds(215,192,140,25);
	l2_txt.setEditable(false);
	completed_lb.setBounds(215,400,160,25);
	l2_txt.setText(bal_str);
	l3.setBounds(62,282,60,30);l3_txt.setBounds(215,282,140,25);total_lb.setBounds(250,333,70,30);
	total_lb.addActionListener(this);
	i=2;
	break;
	case "DEPOSIT":
	setLayout(null);
	y=1;
	completed_lb=new Label("",Label.CENTER);
	add(completed_lb);
	set();
	total_lb =new Button("deposit");	
	add(l1);add(l1_txt);add(l2);add(l2_txt);add(l3);add(l3_txt);add(total_lb);
	l1.setText("USER:");l2.setText("AVAILABLE BALANCE:");l3.setText("AMOUNT:");
	l1.setBounds(53,172,60,30);l1_txt.setBounds(215,173,140,25);
	l2.setBounds(62,232,130,30);l2_txt.setBounds(215,233,140,25);
	l2_txt.setEditable(false);
	completed_lb.setBounds(215,400,160,25);
	l2_txt.setText(bal_str);
	l3.setBounds(62,302,60,30);l3_txt.setBounds(215,303,140,25);total_lb.setBounds(250,353,70,30);
	total_lb.addActionListener(this);
	i=2;
	break;
	case "VIEW BALANCE":
	setLayout(null);
	remm2(0);
	add(l2);add(l2_txt);
	l2.setText("AVAILABLE BALANCE");
	l2.setBounds(62,25,130,30);l2_txt.setBounds(215,25,140,25);
	l2_txt.setText(bal_str);
	l2_txt.setEditable(false);
	i=1;
	break;
	case "PROFILE":
	setLayout(null);
	remm2(1);
	mainchoice();
	i=0;
	break;
}
}
	public void remm()
{	setLayout(null);
	remove(main_edit_button);remove(main_save_button);
	remove(name_lb);remove(name_tx);
	remove(acc_lb);remove(acc_tx);
	remove(dob_lb);remove(dob_tx);
	remove(nat_lb);remove(nat_tx);
	remove(gender);remove(gen_tx);
	remove(mob_lb);remove(mob_tx);
	remove(addr_lb);remove(addr_tx);	
	remove(secq_lb);remove(secq_tx);
	sh2draw=false;
	repaint();
}
	public void remm2(int z)
{	setLayout(null);
	if(z!=2){	
	if(z==1)
	remove(l2);remove(l2_txt);
	remove(l3);remove(l3_txt);}
	remove(l1);remove(l1_txt);
}
public void actionPerformed(ActionEvent ae)
	{
	String str = ae.getActionCommand();
	 if(str.equals("deposit"))
	{
	if((l3_txt.getText().equals("") || l1_txt.getText().equals("")) && y==1)
	{
	completed_lb.setText("enter details!!!!");
	completed_lb.setForeground(Color.red);
	try{
	Thread.sleep(1000);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
	completed_lb.setText(""); 
	}else
	{
	String dep_bal_str=l3_txt.getText();
	dep_bal=Integer.parseInt(dep_bal_str);
 	if(dep_bal<=balance)
	{
	balance=balance-dep_bal;
	bal_str = Integer.toString(balance);
	l2_txt.setText(bal_str);
	try{
	Thread.sleep(500);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
	completed_lb.setText("transaction completed!!!");
	completed_lb.setForeground(Color.red);
	try{
	Thread.sleep(1000);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
  	completed_lb.setText("");  }
	else{
	completed_lb.setText("insufficient balance!!!");
	completed_lb.setForeground(Color.red);
	try{
	Thread.sleep(1000);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
	completed_lb.setText("");
	}  
	}
	}   
	else if(str.equals("edit"))
	{	
	main_edit(true);
	}
	else if(str.equals("save"))
	{
	main_edit(false);
	}
}
	public void default_text()
	{
	name_tx.setText(" rahul");dob_tx.setText(" 04-03-1992");nat_tx.setText(" indian");
	gen_tx.setText(" male");
	addr_tx.setText(" no.12");acc_tx.setText(" 12345");mob_tx.setText(" 231423");
	secq_tx.setText(" pet name_lb?");
	main_edit(false);
	}
	public void main_edit(boolean l){
	name_tx.setEditable(l);dob_tx.setEditable(l);nat_tx.setEditable(l);
	addr_tx.setEditable(l);acc_tx.setEditable(l);mob_tx.setEditable(l);
	gen_tx.setEditable(l);secq_tx.setEditable(l);
	}
	public void set()
{
l1_txt.setText("");;l3_txt.setText("");
}
}
