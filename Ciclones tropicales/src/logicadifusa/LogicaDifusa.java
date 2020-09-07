package logicadifusa;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class LogicaDifusa {
	
	final static double area = 18;
	final static double personas = 6;
	final static double temperatura = 29;
	
	public static void main (String[] args) throws Exception {
		
		String file = "src/logicadifusa/FCL.fcl";
		FIS fis = FIS.load(file, true);
		
		fis.setVariable("area", area);
		fis.setVariable("personas", personas);
		fis.setVariable("temperatura", temperatura);
		
		fis.evaluate();
		
        JFuzzyChart.get().chart(fis.getFunctionBlock("potenciaAireAcondicionado"));

        double x = fis.getVariable("potencia").getLatestDefuzzifiedValue();
        System.err.println("Para los valores de salida el grado de pertenencia es: " + x);
        
        for (Rule r : fis.getFunctionBlock("potenciaAireAcondicionado").getFuzzyRuleBlock("Bloque1").getRules()) {
            System.out.println(r);
        }
	}
}
