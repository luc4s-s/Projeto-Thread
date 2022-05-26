package thread;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ImplementacaoFilaThread extends Thread{

	//metodo statico para acessar essa pilha fila 
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	
	public static void add(ObjetoFilaThread objetoFilaThread) {
		
		pilha_fila.add(objetoFilaThread);
	}
	
	@Override
	public void run() {
		
		System.out.println("fila rodando");
		
		
		
		while(true) {
			
		synchronized (pilha_fila) {//Bloqueando o acesso a essa lista para outro processo 
			
			java.util.Iterator iteracao = pilha_fila.iterator();//Interagindo com a lista
			
			while (iteracao.hasNext()) {//Enquanto tiver dados na lista vai processar
				
				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();//pegando o objeto atual
				
				//processar 20 mil notas FISCAL
				//Gera uma lista enorme de PDF
				//gera um envio em massa de E-MAIL
				
				//testando
				System.out.println("----------------------------");
				System.out.println(processar.getEmail());
				System.out.println(processar.getNome());
				
				iteracao.remove();//Terminou removendo o objeto
				
				try {
					Thread.sleep(1000);//Da um tempo para a carga de memoria
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		try {
			Thread.sleep(1000);//Dar um tempo para a limpesa de memopria 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
