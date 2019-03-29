import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.*;
import java.applet.AppletStub;
/*<applet code="log" width=600 height=500>
<param name="appletToLoad" value="actt">
</applet>*/
public class log extends Applet implements ActionListener,ItemListener,Runnable, AppletStub
{	actt aaa=new actt();
	Color aColor;
	boolean sh_draw=true;	
	Label account,pin,msg;
    TextField ac_text,pin_text;
    Button log_btn,can_btn; 
    Image p1,p2,p3;
	String appletToLoad;
	Thread appletThread;
    public void init()
    {	 
	appletToLoad = getParameter("appletToLoad");
	p1 = getImage(getDocumentBase(),"p1.png"); 
	p2 = getImage(getDocumentBase(),"p2.png"); 
	setLayout(null);
        account=new Label("Enter Account No. : ",Label.CENTER);
        pin=new Label("PIN:",Label.CENTER);
        ac_text=new TextField(20);
        pin_text=new TextField(20);
        pin_text.setEchoChar('*');
        log_btn=new Button("login");
        can_btn=new Button("cancel");
	msg=new Label("",Label.CENTER);
        add(account);
        add(ac_text);
        add(pin);
        add(pin_text);
	add(msg);
        add(log_btn);
  	add(can_btn);
	Font myFont = new Font("Serif",Font.BOLD,12);
	account.setFont(myFont);
	pin.setFont(myFont);
	msg.setFont(myFont);
        account.setBounds(80,170,130,60);
        pin.setBounds(49,213,90,60);
        ac_text.setBounds(220,190,180,25);
        pin_text.setBounds(220,230,180,25);
        log_btn.setBounds(300,280,50,20);
        can_btn.setBounds(300,310,50,20);
	msg.setBounds(270,130,110,60);
	log_btn.addActionListener(this);
	
    }

	
 public void run() {
    try {
     	Class appletClass = Class.forName(appletToLoad);
      Applet realApplet = (Applet) appletClass.newInstance();
      realApplet.setStub(this);
      setLayout(new GridLayout(1, 1));      
	remove(account);remove(pin);remove(ac_text);remove(pin_text);remove(msg);remove(log_btn);remove(can_btn);	
	sh_draw=false;
	repaint();	
	add(realApplet);
    	realApplet.init();
	
    } catch (Exception e) {
      System.out.println(e);
    }
 validate();
  }
public void stop() {
    appletThread.stop();
    appletThread = null;
  }
  public void paint(Graphics g)
    {	
	if(sh_draw==true)
{
	 g.drawImage(p1,410,189, this); 
       	g.drawImage(p2,407,230,this);
	g.drawImage(p3,0,0,this);
    }
}
	public void actionPerformed(ActionEvent ae)
	{	
	if(pin_text.getText().equals("") || ac_text.getText().equals(""))
	{
	msg.setText("enter details");
		msg.setForeground(Color.red);
		try{
	Thread.sleep(1000);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
msg.setText("");    	
	}
	logc ch=new logc();
	boolean c=ch.check(ac_text.getText(),pin_text.getText());	
	if (c==true)
	{
	 appletThread = new Thread(this);
    appletThread.start();
	}
	else
{
		msg.setText("auth failed");
		msg.setForeground(Color.red);
		try{
	Thread.sleep(1000);
	} catch (InterruptedException ie) {
                ie.printStackTrace();
            }
msg.setText("");    	
}
	
		
	}
public void itemStateChanged(ItemEvent ie)
        {

        }
     public void appletResize(int width, int height) {
    resize(width, height);
  }
   

}

