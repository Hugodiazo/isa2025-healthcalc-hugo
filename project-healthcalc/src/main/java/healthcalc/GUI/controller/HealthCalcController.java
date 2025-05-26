package healthcalc.GUI.controller;

import healthcalc.GUI.view.HealthCalcView;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthCalcController {

    private final HealthCalcView view;
    private final HealthCalc model;

    public HealthCalcController(HealthCalcView view) {
        this.view = view;
        this.model = HealthCalcImpl.getInstance();


        this.view.getBtnPesoIdeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPesoIdeal();
            }
        });

        this.view.getBtnBMR().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBMR();
            }
        });
    }

    private void calcularPesoIdeal() {
        try {
            int altura = Integer.parseInt(view.getTxtAltura().getText());
            char genero = view.getGeneroSeleccionado().equalsIgnoreCase("masculino") ? 'M' : 'F';

            float resultado = model.calculateIdealWeight(altura, genero);
            view.setResultado(String.format("%.2f kg", resultado));
            view.setMensaje("");
        } catch (Exception ex) {
            view.setMensaje(ex.getMessage());
        }
    }

    private void calcularBMR() {
        try {
            float peso = Float.parseFloat(view.getTxtPeso().getText());
            int altura = Integer.parseInt(view.getTxtAltura().getText());
            int edad = Integer.parseInt(view.getTxtEdad().getText());
            char genero = view.getGeneroSeleccionado().equalsIgnoreCase("masculino") ? 'M' : 'F';

            float resultado = model.calculateBMR(peso, altura, edad, genero);
            view.setResultado(String.format("%.2f kcal", resultado));
            view.setMensaje("");
        } catch (Exception ex) {
            view.setMensaje(ex.getMessage());
        }
    }
}