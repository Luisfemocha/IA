package logicadifusa;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class LogicaDifusa {
	
	final static double poblacion = 18;
	final static double proximidad_mar = 6;
	final static double velocidad = 29;
	
	public static void main (String[] args) throws Exception {
		
		String file = "src/logicadifusa/FIS_Ciclon.fcl";
		FIS fis = FIS.load(file, true);
		
		fis.setVariable("poblacion", poblacion);
		fis.setVariable("proximidad_mar", proximidad_mar);
		fis.setVariable("velocidad", velocidad);
		
		fis.evaluate();
		
        JFuzzyChart.get().chart(fis.getFunctionBlock("ciclon"));

        double x = fis.getVariable("danos").getLatestDefuzzifiedValue();
        System.err.println("Para los valores de salida el grado de pertenencia es: " + x);
        
        for (Rule r : fis.getFunctionBlock("ciclon").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }
	}
}
