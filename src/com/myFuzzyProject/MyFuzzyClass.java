package com.myFuzzyProject;

import net.sourceforge.jFuzzyLogic.FIS;  
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class MyFuzzyClass extends JPanel implements ActionListener{
	
	JLabel lbl_temperatura,lbl_pesodelacarga,lbl_durezaagua,lbl_tiempo,lbl_suciedadagua,lbl_velocidad, lbl_TITULO ;
	JTextField txt_temperatura,txt_pesodelacarga,txt_durezaagua,txt_tiempo,txt_suciedadagua,txt_velocidad;
	JButton btn1,btn2;
	JMenuBar mb;
	JMenu menu1;
	JMenuItem mi1,mi2,mi3;
	
	public static float tmp;
	public static float t;
	public static float v;
	public static float pc;
	public static float s;
	public static float d; 
	public static int i=1;
	
	
	
	public MyFuzzyClass (){
		
		
		
		setLayout(null);
		/*mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Opciones");
        
        mi1=new JMenuItem("Guardar graficas");
        mi1.addActionListener(this);*/
       
        lbl_TITULO = new JLabel("SISTEMA DIFUSO DE UNA LAVADORA");
		lbl_temperatura = new JLabel("TEMPERATURA (1C° A 60C°): ");
		lbl_pesodelacarga = new JLabel("PESO DE LA CARGA (1KG A 15KG: ");
		lbl_durezaagua = new JLabel("DUREZA DEL AGUA (1mg/l a 180mg/l): ");
		lbl_tiempo = new JLabel("TIEMPO (15min a 30min) : ");
		lbl_suciedadagua = new JLabel("SUCIEDAD AGUA (0 a 1): ");
		lbl_velocidad= new JLabel("VELOCIDAD (500rpm a 1400rpm: ");
		
		txt_temperatura = new JTextField(7);
		txt_pesodelacarga = new JTextField(7);
		txt_durezaagua = new JTextField(7);
		txt_tiempo = new JTextField(7);
		txt_suciedadagua = new JTextField(7);
		txt_velocidad = new JTextField(7);
		
		btn2 = new JButton("Ingresar Datos");
		btn1 = new JButton("Borrar Datos");
		
		

		this.add(lbl_TITULO);
		this.add(lbl_temperatura);
		this.add(txt_temperatura);
	    this.add(lbl_pesodelacarga);
	    this.add(txt_pesodelacarga);	
	    this.add(lbl_durezaagua);
	    this.add(txt_durezaagua);
	    this.add(lbl_tiempo);
	    this.add(txt_tiempo);
	    this.add(lbl_suciedadagua);
	    this.add(txt_suciedadagua);
	    this.add(lbl_velocidad);
	    this.add(txt_velocidad);
	    this.add(btn1);
	    this.add(btn2);
	    //this.add(menu1);
	    //this.add(mi1);
	    
	    
	   
	   // mi1.setBounds(300,0,900,30);
	    // menu1.setBounds(0,0,90,30);
	    lbl_TITULO.setBounds(20,0,300,30);
	    
	    lbl_temperatura.setBounds(20,60,250,30);
	    txt_temperatura.setBounds(280,60,50,30);
	    
	    lbl_pesodelacarga.setBounds(20,90,250,30);
	    txt_pesodelacarga.setBounds(280,90,50,30);
	    
	    lbl_durezaagua.setBounds(20,120,260,30);
	    txt_durezaagua.setBounds(280,120,50,30);
	    
	    lbl_velocidad.setBounds(20,150,250,30);
	    txt_velocidad.setBounds(280,150,50,30);
	    
	    lbl_suciedadagua.setBounds(20,180,250,30);
	    txt_suciedadagua.setBounds(280,180,50,30);
	    
	    lbl_tiempo.setBounds(20,210,250,30);
	    txt_tiempo.setBounds(280,210,50,30);
	    
	    btn1.setBounds(20,260,150,30);
	    btn2.setBounds(180,260,150,30);
	    btn1.addActionListener(this);
	    btn2.addActionListener(this);
	    
	}
	


	/*private void setJMenuBar(JMenuBar mi1) {
		 mi1.setBounds(300,0,900,30);
	}*/



	@Override
	public void actionPerformed(ActionEvent e) {
	    tmp  = Float.parseFloat(txt_temperatura.getText());
	    d  = Float.parseFloat(txt_durezaagua.getText());
	    pc  = Float.parseFloat(txt_pesodelacarga.getText());
	    v  = Float.parseFloat(txt_velocidad.getText());
	    t  = Float.parseFloat(txt_tiempo.getText());
	    s  = Float.parseFloat(txt_suciedadagua.getText());
		// TODO Auto-generated method stub
		if (e.getSource()==btn2) {
		if(txt_temperatura.getText().length()!=0&& txt_durezaagua.getText().length()!=0&& txt_pesodelacarga.getText().length()!=0&& txt_velocidad.getText().length()!=0&& txt_tiempo.getText().length()!=0&& txt_suciedadagua.getText().length()!=0)
			{	
			if((tmp>=1&&tmp<=60)&&(d>=1&&d<=180)&&(pc>=1&&pc<=15)&&(v>=500&&v<=1400)&&(t>=15&&t<=30)&&(s>=0&&s<=1)){
			 difuso();
		    }
			else
			{
				JOptionPane.showMessageDialog(null,"Valor fuera de rango");
			}
			}
		else
		{
			JOptionPane.showMessageDialog(null,"Verifique Los Campos estan Vacios");
		}
		}
		
		if (e.getSource()==btn1) {
			 txt_temperatura.setText("");
				txt_durezaagua.setText("");
				txt_pesodelacarga.setText("");
				txt_velocidad.setText("");
				txt_tiempo.setText("");
				txt_suciedadagua.setText("");
		}
	}
	
	
	public void difuso(){
		String filename = "tipper.fcl";
		FIS fis = FIS.load(filename, true);

		
		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Show ruleset
	    FunctionBlock functionBlock = fis.getFunctionBlock(null);
	    JFuzzyChart.get().chart(functionBlock);	
	    //functionBlock.chart();

	    

	    
	    // Set inputs
	    functionBlock.setVariable("temperatura", tmp);
	    functionBlock.setVariable("dureza", d);
	    functionBlock.setVariable("carga", pc);
	    functionBlock.setVariable("velocidad", v);
	    functionBlock.setVariable("tiempo", t);
	    functionBlock.setVariable("suciedad", s);
	    
	    // Evaluate
	    functionBlock.evaluate();

	    // Show output variable's chart
	    //functionBlock.getVariable("tip").chartDefuzzifier(true);
	    Variable detergente = functionBlock.getVariable("detergente");
	    JFuzzyChart.get().chart(detergente, detergente.getDefuzzifier(), true);

	    // Print ruleSet
	    System.out.println(functionBlock);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		JFrame f = new JFrame();
		MyFuzzyClass p = new MyFuzzyClass();
		f.add(p);
		f.setVisible(true);
		//f.setSize(900,620);
		f.setBounds(0,0,350,350);
		f.setVisible(true);
		f.setResizable(true);

	}
}