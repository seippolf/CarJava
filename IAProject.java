public class IAProject {
    /*
    Sources:
        https://www.turbobygarrett.com/turbobygarrett/choosing_turbo
    
    
    Wa = HP * (A/F) * (BSFC/60)
    
        Wa: Airflowactual
        HP: Horsepower Target (flywheel)
        A/F: Air/Fuel Ratio
        BSFC/60: Brake Specific Fuel Consumption per hour --> per minute 
            ^This is measured on a dynamometer
    
    MAPreq = (Wa * R * (460 + Tm)) / (VE * (N/2) * Vd)
    
        MAPreq: Manifold Absolute Pressure required to reach Horsepower target
        Wa: Airflowactual
        R = Gas Constant = 639.6
        Tm = Intake Manifold Temperature (degrees F)
        VE = Volumetric Efficiency
        N = Engine Speed (RPM)
        Vd = Volumetric displacement (In Cubic Inches)
    
    */
    public static double airflowActual(double hpTarget, double afRatio, double bsFuelConsumption) {
        double hp = hpTarget;
        double af = afRatio;
        double bsfc = bsFuelConsumption;
        double wa = hp * af * (bsfc/60);
        return wa;
        
    }
    public static double manifoldPressure(double wActual, double imTemperature, double volEfficiency, double engineSpeed, double engineDisplacement) {
        double wa = wActual;
        double r = 639.6; //Gas constant
        double tm = imTemperature;
        double ve = volEfficiency;
        double n = engineSpeed;
        double vd = engineDisplacement;
        double mp  = (wa * r * (460 + tm)) / (ve * (n/2) * vd);
        return mp;
        
    }
    public static void main(String[] args) {
        System.out.println("Airflowactual: " + airflowActual(425,22,0.38));
        System.out.println("Manifold pressure requirements: " + manifoldPressure(airflowActual(425,22,0.38),130,0.98,3300,400));
        
    }
    public static void compressorMap() {
    
    }
}
