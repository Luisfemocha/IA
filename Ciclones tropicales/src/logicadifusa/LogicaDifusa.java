package logicadifusa;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class LogicaDifusa {
	
	static double poblacion = 1.392503;
	static double proximidad_mar = 0;
	static double velocidad = 162;
	
	public static void main () throws Exception {
		
		String file = "src/logicadifusa/FIS_Ciclon.fcl";
		FIS fis = FIS.load(file, true);
		
		fis.setVariable("poblacion", Double.parseDouble(Interfaz.campo1.getText()));
		fis.setVariable("proximidad_mar", Double.parseDouble(Interfaz.campo2.getText()));
		fis.setVariable("velocidad", Double.parseDouble(Interfaz.campo3.getText()));
		
		fis.evaluate();
		
        JFuzzyChart.get().chart(fis.getFunctionBlock("ciclon"));

        double x = fis.getVariable("danos").getLatestDefuzzifiedValue();
        System.err.println("Para los valores de salida el grado de pertenencia es: " + x);
        
        for (Rule r : fis.getFunctionBlock("ciclon").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }
	}
}
