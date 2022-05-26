package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	
	
	//painel
		private JPanel jPanel = new JPanel(new GridBagLayout());//painel de componente
		
		//primeiro atributos descricao e label
		private JLabel descricaoHora1 = new JLabel("Nome");
		private JTextField mostraHora1 = new JTextField();
		
		
		//segundos atributos descricao e label
		private JLabel descricaoHora2 = new JLabel("Email");
		private JTextField mostraHora2 = new JTextField();
		
		//butoes 
		private JButton jButton1 = new JButton("Adicionar");
		private JButton jButton2 = new JButton("Stop");
		
		private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

		
		public TelaTimeThread() {//executa oque estiver dentro, no momento da abertura ou execu�ao 
			
			/** PRIMEIRA PARTE CONCLUIDA **/
			setTitle("Tela de Data e Hora com Thread");//titulo
			setSize(new Dimension(260, 260));//autura e largura 
			setLocationRelativeTo(null);//centralizando 
			setResizable(false);//nao permite aumentar e diminuir o tamanho da tela 
			
			
			GridBagConstraints gridBagConstraints = new GridBagConstraints();//controlador de posicionamento de componentes
			gridBagConstraints.gridx = 0;//largura
			gridBagConstraints.gridy = 0;//coluna
			gridBagConstraints.gridwidth = 2;//inicianado a largura com 2 para a descir�ao e o label
			gridBagConstraints.insets = new Insets(5, 10, 5, 5);//top,esquerda,butao,direita
			gridBagConstraints.anchor = GridBagConstraints.WEST;
		
			
			//primeiro componete descri�ao e label
			descricaoHora1.setPreferredSize(new Dimension(200, 25));
			jPanel.add(descricaoHora1, gridBagConstraints);
			
			mostraHora1.setPreferredSize(new Dimension(200, 25));
			gridBagConstraints.gridy ++; //andado uma possicao
			jPanel.add(mostraHora1, gridBagConstraints);
			
			
			//segundo componente de desacri�ao e label
			descricaoHora2.setPreferredSize(new Dimension(200, 25));
			gridBagConstraints.gridy ++;
			jPanel.add(descricaoHora2, gridBagConstraints);
			
			mostraHora2.setPreferredSize(new Dimension(200, 25));
			gridBagConstraints.gridy ++;
			jPanel.add(mostraHora2, gridBagConstraints);
			
			
			//para os botes fica na largura de 1
			gridBagConstraints.gridwidth = 1;
			
			//butoes
			jButton1.setPreferredSize(new Dimension(92, 25));
			gridBagConstraints.gridy ++;
			jPanel.add(jButton1, gridBagConstraints);
			
			jButton2.setPreferredSize(new Dimension(92, 25));
			gridBagConstraints.gridx ++;
			jPanel.add(jButton2, gridBagConstraints);
			
			
			//acao do butao start
			jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {//executa o click no butao
					
					if (fila == null) {//condicao para colocar a fila em start e stop 
						fila = new ImplementacaoFilaThread();
						fila.start();
					}
					
					for (int qtd = 0; qtd < 100; qtd++) { //simulado 100 envio em massa
					
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraHora1.getText());
					filaThread.setEmail(mostraHora2.getText() + " - " + qtd);
					
					fila.add(filaThread);
					}
				}
			});
			
			// acao do butao stop
			jButton2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {// executa o click no butao
				
					fila.stop();//stop na fila 
					fila = null;//matando objeto 
		
				}
			});
			
			fila.start(); 
			
			add(jPanel, BorderLayout.WEST);
			//sempre ser� o ultimo comando
			setVisible(true);// torna a tela visivel para o usuario 
			
		}

}
