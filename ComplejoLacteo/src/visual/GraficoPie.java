package visual;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import logico.Principal;
import java.awt.BorderLayout;

public class GraficoPie extends JPanel implements Runnable{

	/**
	 * Create the panel.
	 */
	private static boolean update;
	private DefaultPieDataset data;
	public GraficoPie(boolean updatePrincipal) {
		GraficoPie.update = updatePrincipal;
		this.setBounds(10, 22, 410, 269);
		data = new DefaultPieDataset();
		data.setValue("Queso Esférico", Principal.getInstance().cantidadQuesos()[0]);
		data.setValue("Queso Cilíndrico", Principal.getInstance().cantidadQuesos()[1]);
		data.setValue("Queso C. Hueco", Principal.getInstance().cantidadQuesos()[2]);
		// Creando el Grafico
		JFreeChart chart = ChartFactory.createPieChart(
				"", 
				data, 
				true, 
				true, 
				false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setBackgroundPaint(Color.WHITE);;
		plot.setSectionPaint("Queso Esférico", new Color(11, 55, 99));
		plot.setSectionPaint("Queso Cilíndrico", new Color(19,98,176));
		plot.setSectionPaint("Queso C. Hueco", new Color(28,140,252));
		setLayout(new BorderLayout(0, 0));

		// Crear el Panel del Grafico con ChartPanel
		ChartPanel chartPanel = new ChartPanel(chart);
		this.add(chartPanel);
	}

	@Override
	public void run() {
		//this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setVisible(true);
		while(update) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.setValue("Queso Esférico", Principal.getInstance().cantidadQuesos()[0]);
			data.setValue("Queso Cilíndrico", Principal.getInstance().cantidadQuesos()[1]);
			data.setValue("Queso C. Hueco", Principal.getInstance().cantidadQuesos()[2]);
		}
	}

}
