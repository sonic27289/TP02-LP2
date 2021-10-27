import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;

public class InterfaceG implements ActionListener {
    
    private JFrame tela = new JFrame();
	private JLabel label = new JLabel("Nome: ");
	private JLabel label1 = new JLabel("Idade: ");
	private JLabel label2 = new JLabel("Endereço: ");
	private JTextField texto = new JTextField(10);
	private JTextField texto1 = new JTextField(10);
	private JTextField texto2 = new JTextField(10);
	private JButton button = new JButton();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private List<Aluno> alunos = new ArrayList<Aluno>();

    // Criação da Interface Gráfica e suas modificações

    InterfaceG(){
        tela.setSize(400,180);
		tela.setLocation(200,200);
		tela.setTitle("Cadastrar Aluno");
		tela.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel.add(panel1);
		panel1.setLayout(new GridLayout(3,2,10,10));
		panel1.add(label);
		panel1.add(texto);
		panel1.add(label1);
		panel1.add(texto1);
		panel1.add(label2);
		panel1.add(texto2);
		panel.add(panel2);
		button.setText("Ok");
		button.addActionListener(this);
		button1.setText("Limpar");
		button1.addActionListener(this);
		button2.setText("Mostrar");
		button2.addActionListener(this);
		button3.setText("Sair");
		button3.addActionListener(this);
		panel2.add(button);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		tela.setVisible(true);
    }
    // Função para Limpar todas as labels
    public void clean() {
        texto.setText("");
        texto1.setText("");
        texto2.setText("");
    }
    // Função para os buttons 
    public void actionPerformed(ActionEvent e){
        String x = e.getActionCommand();
        if("Ok".equals(x)){
            alunos.add(new Aluno(texto2.getText(), Integer.parseInt(texto1.getText()), texto.getText()));
            clean();
        }
        if("Limpar".equals(x)){
            clean();
        }
        if("Mostrar".equals(x)){
            String mensagem = "";
            for (Aluno usuario : alunos) {
                mensagem +="Resultado";
                mensagem += "\n";
                mensagem += "ID: " + usuario.getUuid() + "";
				mensagem += "\n";
                mensagem += "Nome: " + usuario.getNome() + "";
                mensagem += "\n";
            }
            JOptionPane.showMessageDialog(null, mensagem);
        }
        if("Sair".equals(x)){
            tela.dispose();
        }    
    }
    public static void main(String[]args){
        InterfaceG tela = new InterfaceG();  
    }
}