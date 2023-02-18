import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

    public static void main(String[] args) {
       LoginTest loginTest = new LoginTest();
//       loginTest.loginWithValidData();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Verifica preturi !");
        JButton btn = new JButton("DO IT !");
        frame.setSize(500,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        label.setBounds(100,100,150,25);
        panel.add(label);
        btn.setBounds(200,100,80,25);
        btn.addActionListener((ActionListener) new Main());
        panel.add(btn);
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginTest loginTest = new LoginTest();

        System.out.println("click");
        loginTest.loginWithValidData();
    }
}
