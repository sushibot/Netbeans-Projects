package comporg;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;

import java.io.*;
import java.util.Scanner;

public class Macro1Viewer extends JFrame {//gui output class
	
	private class LineNumberView extends JPanel implements DocumentListener {
		private JTextComponent component;
		private FontMetrics fontMetrics;
		
		public LineNumberView(JTextComponent component) {
			this.component = component;
			this.fontMetrics = component.getFontMetrics(component.getFont());
			component.getDocument().addDocumentListener(this);
			this.setPreferredSize(new Dimension(30, HEIGHT));
			this.setFont(new Font("Calibri", Font.PLAIN, component.getFont().getSize() - 2));
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			String text = component.getText();
			for(int i = 1; i <= text.length() - text.replace("\n", "").length() + 1; i++)
				g.drawString("" + i, (3-(i+"").length())*fontMetrics.charWidth('0'), i * fontMetrics.getHeight() - 3);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			update();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			update();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			update();
		}
		
		private void update() {
			this.setPreferredSize(new Dimension(30, component.getSize().height + 100));
			this.repaint();
		}
		
	}
	
	private JTextArea text;
	private JTextArea output;
	private JTextArea register;
	private JTextArea memory;
	private JScrollPane memoryScroll;
	private JButton compile;
	private JButton step;
	private JButton stepUntilHalt;
	private JButton open;
	private JButton stepIn;
	private File fp;
	
	private Macro1 macro1; //model
	
	public Macro1Viewer() {
		macro1 = new Macro1();
		
		//fp = new File("test2.assm");
		this.setTitle("title");
		this.setSize(710, 580);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**
		 * Panel setup
		 */
		JPanel main = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		main.setPreferredSize(new Dimension(500, 550));
		//main.setBackground(Color.yellow);
		
		JPanel option = new JPanel(new FlowLayout(FlowLayout.LEFT));
		option.setPreferredSize(new Dimension(800, 30));
		//option.setBackground(Color.yellow);
		
		JPanel registerPane = new JPanel();
		registerPane.setPreferredSize(new Dimension(200, 380));
		//registerPane.setBackground(Color.blue);
		
		JPanel codePane = new JPanel();
		codePane.setPreferredSize(new Dimension(300, 380));
		//codePane.setBackground(Color.blue);
		
		JPanel outputPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		outputPane.setPreferredSize(new Dimension(500, 140));
		//outputPane.setBackground(Color.blue);
		
		JPanel memoryPane = new JPanel();
		memoryPane.setPreferredSize(new Dimension(200, 550));
		//memoryPane.setBackground(Color.yellow);
		
		
		/**
		 * Option Panel Config
		 */
		open = new JButton("Open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					open();
				} catch(Exception e) {
					output.setText(e.getMessage());
				}
			}
		});
		
		
		compile = new JButton("Compile");
		compile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doCompile();
			}
		});
		
		stepIn = new JButton("Step Into");
		stepIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!doCompile()) return;
				step.setEnabled(true);
				stepUntilHalt.setEnabled(true);
				stepIn.setEnabled(false);
				macro1.load(new File(fp.getAbsolutePath() + ".m1").getAbsoluteFile());
				register.setText(macro1.registerDump());
				memory.setText(macro1.memoryDump());
			}
		});
		
		step = new JButton("Step");
		step.setEnabled(false);
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					macro1.step();
				} catch(Exception e) {
					output.setText("Runtime Error\n" + e.getMessage() + "\nProgram Terminated");
					step.setEnabled(false);
					stepUntilHalt.setEnabled(false);
					stepIn.setEnabled(true);
				}
				if(macro1.isHalt()) {
					step.setEnabled(false);
					stepUntilHalt.setEnabled(false);
					stepIn.setEnabled(true);
					output.setText("halt");
				}
				register.setText(macro1.registerDump());
				memory.setText(macro1.memoryDump());
			}
		});
		
		stepUntilHalt = new JButton("Step Until Halt");
		stepUntilHalt.setEnabled(false);
		stepUntilHalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					macro1.stepUtilHalt();
				} catch(Exception e) {
					output.setText("Runtime Error\n" + e.getMessage() + "\nProgram Terminated");
				}
				if(macro1.isHalt()) output.setText("halt");
				step.setEnabled(false);
				stepUntilHalt.setEnabled(false);
				stepIn.setEnabled(true);
				register.setText(macro1.registerDump());
				memory.setText(macro1.memoryDump());
			}
		});
		
		
		/**
		 * Input Panel Config
		 */
		text = new JTextArea();
		text.setEditable(true);
		text.setLineWrap(false);
		text.setFont(new Font("monospaced", Font.PLAIN, 12));
		
		JScrollPane scroll = new JScrollPane(text, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setRowHeaderView(new LineNumberView(text));
		scroll.setPreferredSize(new Dimension(280, 350));
		
		JLabel code = new JLabel("Code");
		code.setPreferredSize(new Dimension(280, 20));
		
		
		/**
		 * Output Panel Config
		 */
		output = new JTextArea();
		output.setEditable(false);
		output.setLineWrap(false);
		JScrollPane outputScroll = new JScrollPane(output, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		outputScroll.setPreferredSize(new Dimension(480, 100));
		
		JLabel outputLabel = new JLabel("Outputs");
		outputLabel.setHorizontalAlignment(SwingConstants.LEFT);
		outputLabel.setPreferredSize(new Dimension(400, 20));
		
		/**
		 * Register Panel Config
		 */
		register = new JTextArea();
		register.setEditable(false);
		register.setLineWrap(false);
		register.setFont(new Font("monospaced", Font.PLAIN, 12));
		JScrollPane registerScroll = new JScrollPane(register, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		registerScroll.setPreferredSize(new Dimension(180, 350));
		
		JLabel registerLabel = new JLabel("Register");
		registerLabel.setPreferredSize(new Dimension(180, 20));
		
		/**
		 * Memory Panel Config
		 */
		memory = new JTextArea();
		memory.setEditable(false);
		memory.setLineWrap(false);
		memory.setFont(new Font("monospaced", Font.PLAIN, 12));
		DefaultCaret caret = (DefaultCaret)memory.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		memoryScroll = new JScrollPane(memory, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		memoryScroll.setPreferredSize(new Dimension(180, 470));
		
		JLabel memoryLabel = new JLabel("Memory");
		memoryLabel.setPreferredSize(new Dimension(180, 20));
		
		registerPane.add(registerLabel);
		registerPane.add(registerScroll);
		
		codePane.add(code);
		codePane.add(scroll);
		
		outputPane.add(outputLabel);
		outputPane.add(outputScroll);
		
		memoryPane.add(memoryLabel);
		memoryPane.add(memoryScroll);
		
		option.add(open);
		option.add(compile);
		option.add(stepIn);
		option.add(step);
		option.add(stepUntilHalt);
		
		main.setBorder(new EmptyBorder(0,0,0,0));
		main.add(codePane);
		main.add(registerPane);
		main.add(outputPane);
		
		this.add(option);
		this.add(main);
		//this.add(registerPane);
		this.add(memoryPane);
		this.setVisible(true);
	}
	
	private boolean doCompile() {
		try {
			if(!save()) return false;
			if(Compiler.compile(fp)) output.setText("compile success\n");
			else output.setText("compile failed\n");
			return true;
		} catch(Exception e) {
			output.setText("compile failed\n");
			output.append(e.getMessage());
		}
		return false;
	}
	
	private boolean open() throws IOException {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("assm files", "assm");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			fp = fc.getSelectedFile().getAbsoluteFile();
			Scanner in = new Scanner(fp);
			text.setText("");
			while(in.hasNext()) 
				text.append(in.nextLine() + "\n");
			in.close();
			return true;
		}
		return false;
	}
	
	private boolean save() throws IOException {
		if(fp == null) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("assm files", "assm");
			fc.setFileFilter(filter);
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				fp = new File(fc.getSelectedFile()+ ".assm").getAbsoluteFile();
			} else {
				return false;
			}
		}
		FileWriter fw = new FileWriter(fp, false);
		fw.write(text.getText());
		fw.close();
		return true;
	}
}
