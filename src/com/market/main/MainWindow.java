package com.market.main;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	static JPanel mMenuPanel, mPagePanel;
	
	public MainWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	private void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((screenSize.width - 1000) / 2, (screenSize.height - 750) / 2);
		mMenuPanel = new JPanel();
		mMenuPanel.setBounds(0, 20, width, 130);
		menuIntroduction();
		add(mMenuPanel);
		
		mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, width, height);
		add(mPagePanel);
	}
	
	private void menuIntroduction() {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		JButton btn1 = new JButton("고객 정보 확인하기", new ImageIcon("./images/1.png"));
		btn1.setBounds(0, 0, 100, 50);
		btn1.setFont(ft);
		mMenuPanel.add(btn1);
		
		JButton btn2 = new JButton("장바구니 상품 목록 보기", new ImageIcon("./images/2.png"));
		btn2.setBounds(0, 0, 100, 30);
		btn2.setFont(ft);
		mMenuPanel.add(btn2);
		
		JButton btn3 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
		btn3.setBounds(0, 0, 100, 30);
		btn3.setFont(ft);
		mMenuPanel.add(btn3);
		
		JButton btn4 = new JButton("장바구니 항목 추가하기", new ImageIcon("./images/4.png"));
		btn4.setFont(ft);
		mMenuPanel.add(btn4);
		
		JButton btn5 = new JButton("장바구니의 항목 수량 줄이기", new ImageIcon("./images/5.png"));
		btn5.setFont(ft);
		mMenuPanel.add(btn5);
		
		JButton btn6 = new JButton("장바구니의 항목 삭제하기", new ImageIcon("./images/6.png"));
		btn6.setFont(ft);
		mMenuPanel.add(btn6);
		
		JButton btn7 = new JButton("주문하기", new ImageIcon("./images/7.png"));
		btn7.setFont(ft);
		mMenuPanel.add(btn7);
		
		JButton btn8 = new JButton("종료", new ImageIcon("./images/8.png"));
		btn8.setFont(ft);
		mMenuPanel.add(btn8);
		
		JButton btn9 = new JButton("관리자", new ImageIcon("./images/9.png"));
		btn9.setFont(ft);
		mMenuPanel.add(btn9);
	}
	
	public static void main(String[] argc) {
		new MainWindow("도서 쇼핑몰", 0, 0, 1000, 750);
	}
}