package Projeto_Semaforo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Semaforo extends JFrame {
	private static int controlsemaforo = 0;
	private static ExecutorService executor;
	private static Runnable vermelho;
	private static Runnable amarelo;
	private static Runnable verde;
	private static Color colorvermelho = null;
	private static Color coloramarelo = null;
	private static Color colorverde = null;
	private static Semaforo instance;

	public Semaforo() {
		instance = this;
		setTitle("Semaforo");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawRect(250, 150, 100, 220);
		g.drawRect(285, 370, 30, 100);
		g.drawOval(270, 160, 60, 60);
		g.drawOval(270, 230, 60, 60);
		g.drawOval(270, 300, 60, 60);
		g.setColor(colorvermelho);
		g.fillOval(270, 160, 60, 60);
		g.setColor(coloramarelo);
		g.fillOval(270, 230, 60, 60);
		g.setColor(colorverde);
		g.fillOval(270, 300, 60, 60);
	}
	
	private static void ChangeCollor() {
		if (controlsemaforo == 1) {
			colorvermelho = Color.red;
			instance.repaint();
		} 
		else if (controlsemaforo != 1) {
			colorvermelho = Color.white;
			instance.repaint();
		}
		if (controlsemaforo == 2) {
			coloramarelo = Color.yellow;
			instance.repaint();
		}
		else if (controlsemaforo != 2) {
			coloramarelo = Color.white;
			instance.repaint();
		}
		if (controlsemaforo == 3) {
			colorverde = Color.green;
			instance.repaint();
		}
		else if (controlsemaforo != 3) {
			colorverde = Color.white;
			instance.repaint();
		}
	}
	
	
	public static synchronized void main(String[] args) {
		new Semaforo();

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		executor = Executors.newFixedThreadPool(3);

		vermelho = () -> {
			while (true) {			
				controlsemaforo = 1;
				ChangeCollor();
				await(cyclicBarrier);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		amarelo = () -> {
			while (true) {
				controlsemaforo = 2;
				ChangeCollor();
				await(cyclicBarrier);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		verde = () -> {
			while (true) {
				controlsemaforo = 3;
				ChangeCollor();
				await(cyclicBarrier);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		restart();
	}

	private static void await(CyclicBarrier cyclicBarrier) {
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	private static void restart() {
		executor.submit(vermelho);
		executor.submit(amarelo);
		executor.submit(verde);
	}
}
