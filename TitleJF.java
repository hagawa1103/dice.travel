package scene;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TitleJF extends  JFrame implements ActionListener {
	
	JPanel cardPanel;
    CardLayout layout;
    private String travel01 = "旅1";
    private String travel02 = "旅2";
    private String travel03 = "旅3";
    private String diceRoll = "サイコロを振る";
    private String exit = "次へ";
    private String title = "タイトルに戻る";

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TitleJF frame = new TitleJF();
        frame.setTitle("タイトルに画面");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
	
	public TitleJF() {
		// 旅1
        JPanel panel01 = new JPanel();
        panel01.setBorder(new EmptyBorder(200, 400, 300, 400));
        String travelName = "[水曜どうでしょう サイコロの旅]";
        JLabel label = new JLabel(travelName);
        label.setFont(new Font("", Font.PLAIN, 28));
        JButton btn01 = new JButton(travel01);
        btn01.addActionListener(this);
        btn01.setActionCommand(travel01);
        panel01.add(label);
        panel01.add(btn01);

        // サイコロを振る
        JPanel panel03 = new JPanel();
        //panel02.setBackground(Color.DARK_GRAY);
        panel03.setBorder(new EmptyBorder(200, 400, 300, 400));
        
        String messeage4 = "[〇投目]";
        String messeage5 = "（現在地○○";
        String messeage6 = "↑のボタンでサイコロを振ってね";
        
        JLabel label4 = new JLabel(messeage4);
        label4 .setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label5 = new JLabel(messeage5);
        
        JLabel label6 = new JLabel(messeage6);
        label6.setFont(new Font("", Font.PLAIN, 20));
        
      //DB画面表配置枠
        /*JPanel panel04 = new JPanel();
        panel04.setBackground(Color.BLUE);
        panel04.setPreferredSize(new Dimension(200, 100));*/
        
        JButton btn02 = new JButton(diceRoll);
        panel03.add(label4);
        panel03.add(label5);
        panel03.add(btn02);
        panel03.add(label6);

        // 次への画面
        JPanel panel05 = new JPanel();
        panel05.setBackground(Color.LIGHT_GRAY);
        panel05.setBorder(new EmptyBorder(100, 400, 300, 400));
        
        String messeage7 = "出た目は";
        String messeage8 = "行き先は";
        String messeage9 = "交通手段は";
        String messeage10 = "↑次へを押してね";
        
        JLabel label7 = new JLabel(messeage7);
        label7.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label8 = new JLabel(messeage8);
        label8.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label9 = new JLabel(messeage9);
        label9.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label10 = new JLabel(messeage10);
        //DB画面配置デザインテスト用
        JPanel panel06 = new JPanel();
        panel06.setBackground(Color.BLUE);
        panel06.setPreferredSize(new Dimension(200, 100));

        
        JButton btn03 = new JButton(exit);
        panel05.add(label7);
        panel05.add(label8);
        panel05.add(label9);
        panel05.add(panel06);
        panel05.add(btn03);
        panel05.add(label10);
        
        //タイトルに戻る画面
        JPanel panel07 = new JPanel();
        panel07.setBackground(Color.LIGHT_GRAY);
        panel07.setBorder(new EmptyBorder(200, 400, 300, 400));
        String messeage11 = "長旅お疲れ様でした";
        String messeage12 = "本編が気になる方は是非DVD・BDが出ているので是非見てくだい";
        JLabel label11 = new JLabel(messeage11);
        label11.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label12 = new JLabel(messeage12);
        
        JButton btn04 = new JButton(title);
        panel06.add(label11);
        panel06.add(label12);
        panel06.add(btn04);

        // CardLayout用パネル
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(panel01, travel01);
        cardPanel.add(panel03, diceRoll);
        cardPanel.add(panel05, exit);
        cardPanel.add(panel07, title);
        // カード移動用ボタン
        JButton firstButton = new JButton(travel01);
        firstButton.addActionListener(this);
        firstButton.setActionCommand(travel01);

        JButton secondButton = new JButton(diceRoll);
        secondButton.addActionListener(this);
        secondButton.setActionCommand(diceRoll);

        JButton thirdButton = new JButton(exit);
        thirdButton.addActionListener(this);
        thirdButton.setActionCommand(exit);
        
        JButton forceButton = new JButton(title);
        forceButton.addActionListener(this);
        forceButton.setActionCommand(title);

        JPanel btnPanel = new JPanel();
        btnPanel.add(firstButton);
        btnPanel.add(secondButton);
        btnPanel.add(thirdButton);
        btnPanel.add(forceButton);

        // cardPanelとカード移動用ボタンをJFrameに配置
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        contentPane.add(btnPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
        if (cmd.equals(title)){
		  layout.first(cardPanel);
		}else if (cmd.equals(travel01)){
		  layout.next(cardPanel);
		}else if (cmd.equals(exit)){
		  layout.next(cardPanel);
		}else if (cmd.equals(diceRoll)){
		  layout.next(cardPanel);
		}
        //layout.show(cardPanel, cmd);
	}
	
	
		
	

}
