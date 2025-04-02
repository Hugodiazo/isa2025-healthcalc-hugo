package healthcalc.GUI;

import healthcalc.GUI.view.HealthCalcView;
import healthcalc.GUI.controller.HealthCalcController;

public class Main {
    public static void main(String[] args) {
        HealthCalcView view = new HealthCalcView();
        new HealthCalcController(view);
        view.setVisible(true);
    }
}