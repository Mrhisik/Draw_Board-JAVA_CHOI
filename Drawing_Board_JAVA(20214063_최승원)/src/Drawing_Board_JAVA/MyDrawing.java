package Drawing_Board_JAVA;
import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyDrawing extends JFrame {
	JPanel p1, p2;
	int x, y;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
	Drawing_Board can;
	Point_Size ps;
	Font myFont = new Font("Serif", Font.BOLD, 20);
	int r1, r2, r3;
	Color c = new Color(r1,r2,r3);
	JLabel label1, label2;
	BufferedImage bi = new BufferedImage(1000, 980, BufferedImage.TYPE_INT_RGB);
	
	public  MyDrawing() {
		
		setTitle("Drawing Board(20214063_최승원)");
		p1 = new JPanel();
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		ImageIcon img1 = new ImageIcon("up.png");
		b1 = new JButton(img1);
		b1.setSize(50, 30);
		b1.setLocation(20,10);
		
		ImageIcon img2 = new ImageIcon("down.png");
		b2 = new JButton(img2);
		b2.setSize(50, 30);
		b2.setLocation(20, 50);
		
		ImageIcon img4 = new ImageIcon("erase_all.jpg");//포크레인 사진을
		b3 = new JButton(img4);                           //버튼에 삽입
		b3.setSize(80, 50);
		b3.setLocation(270, 20);
		
		ImageIcon img3 = new ImageIcon("eraser.jfif");//지우개 사진을
		b12 = new JButton(img3);                        //버튼에 삽입 
		b12.setSize(80, 50);                            
		b12.setLocation(370, 20);
		//버튼의 색상을 변경해 어떤 버튼이 어떤 색상으로 변경하는지 표시
		b4 = new JButton("");
		b4.setSize(30, 30);
		b4.setLocation(670, 10);
		b4.setBackground(Color.BLACK);
		
		b5 = new JButton("");
		b5.setSize(30, 30);
		b5.setLocation(710, 10);
		b5.setBackground(Color.RED);
		
		b6 = new JButton("");
		b6.setSize(30, 30);
		b6.setLocation(750, 10);
		b6.setBackground(Color.ORANGE);
		
		b7 = new JButton("");
		b7.setSize(30, 30);
		b7.setLocation(790, 10);
		b7.setBackground(Color.YELLOW);
		
		b8 = new JButton("");
		b8.setSize(30, 30);
		b8.setLocation(830, 10);
		b8.setBackground(Color.GREEN);
		
		b9 = new JButton("");
		b9.setSize(30, 30);
		b9.setLocation(870, 10);
		b9.setBackground(Color.CYAN);
		
		b10 = new JButton("");
		b10.setSize(30, 30);
		b10.setLocation(910, 10);
		b10.setBackground(Color.BLUE);
	
		b11 = new JButton("");
		b11.setSize(30, 30);	
		b11.setLocation(950, 10);
		Color c1 = new Color(139,0,255);
		b11.setBackground(c1);
		b13 = new JButton("파일 저장하기");
		b13.setSize(120, 30);
		b13.setLocation(500, 30);
		can = new Drawing_Board();
		ps = new Point_Size();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b10);
		p1.add(b11);
		p1.add(b12);
		p1.add(b13);
		label1 = new JLabel("현재 굵기");
		label1.setFont(myFont);
		label1.setBounds(100, 10, 100, 40);
		ps.setSize(50,50);
		ps.setLocation(200, 20);
		p1.add(ps);
		p1.add(label1);
		p1.setPreferredSize(new Dimension(1000, 100));

		add(p1,"North");
		p2 = new JPanel(){
			public Insets getInsets(){
				return new Insets(20,20,20,20);		
			}//-------------
		};
		p2.setBackground(Color.darkGray);
		add(p2,"South");
		
		can.setSize(800,800);
		can.setBackground(Color.white);
		p2.add(can);
		
		drawing d = new drawing();
		b1.addActionListener(d);
		b2.addActionListener(d);
		b3.addActionListener(d);
		b4.addActionListener(d);
		b5.addActionListener(d);
		b6.addActionListener(d);
		b7.addActionListener(d);
		b8.addActionListener(d);
		b9.addActionListener(d);
		b10.addActionListener(d);
		b11.addActionListener(d);
		b12.addActionListener(d);
		b13.addActionListener(d);
		can.addMouseMotionListener(d);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});	
	}
	class drawing extends MouseMotionAdapter implements ActionListener {
		public void mouseDragged(MouseEvent e) {
			can.x = e.getX();
			can.y = e.getY();
			can.repaint();			
		}
		public void actionPerformed(ActionEvent e){
			Object o=e.getSource();
			can.flag=0;//flag를 0으로 주어 그리기가 기본작업이 되게 한다.
			if(o==b4){
				can.cr=Color.black;
			}else if(o==b5){
				can.cr=Color.red;
			}else if(o==b6){
				can.cr=Color.orange;
			}else if(o==b7){
				can.cr = Color.yellow;
			}else if(o==b8){
				can.cr = Color.green;
			}else if(o==b9){
				can.cr = Color.cyan;
			}else if(o==b10){
				can.cr = Color.blue;
			}else if(o==b11){
				Color c = new Color(139,0,255);
				can.cr = c;
			}else if(o==b2){
				if(can.w >3){//3이하로는 작아지지 않게
					can.w--;
					can.h--;
					ps.w--;
					ps.h--;
					ps.repaint();
				}
			}else if(o==b1){
				if(can.w < 50) { //40을 초과하지 않게
					can.w++;
					can.h++;
					ps.w++;
					ps.h++;
					ps.repaint();
				}
			}else if(o==b12){
				can.cr=can.getBackground(); //배경색을 칠해서 지우기
			}else if(o==b3){
				can.flag=1;
				can.repaint();
			}else if(o == b13) { //파일 저장을 구현하려 했으나 실패
				try { ImageIO.write(bi, "PNG", new File("d:\\yourImageName.PNG")); }
	               catch (IOException e1) { e1.printStackTrace(); }  
			}			
		}	
	}
	public static void main(String[] args) {
		MyDrawing f = new MyDrawing();
		f.setSize(1000, 980);
		
		f.setVisible(true);
	}
}
class Point_Size extends Canvas{
	int w = 7, h = 7;
	public void paint(Graphics g) {
		Drawing_Board db = new Drawing_Board();
		g.fillOval(0, 0, w, h);
		
	}
}

class Drawing_Board extends Canvas
{
	int x=-13, y=-13, w=7, h=7;
	Color cr=Color.black;
	int flag=0;
	public void paint(Graphics g){
		if(flag==0){ 
			//1. 그리기		
			g.setColor(cr);
			g.fillOval(x, y, w, h);
		}else if(flag==1){
			//2. 모두 지우기
			g.clearRect(0,0,800,800);
		}	
	}
	public void update(Graphics g){
		
		paint(g);
	}
}
