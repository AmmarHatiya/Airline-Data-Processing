package com.example.assignment2part3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class DoubleBarChart extends Application {

    // list of all airlines
    final static String Aer_Lingus = "Aer Lingus";
    final static String Aeroflot = "Aeroflot";
    final static String Aerolineas_Argentinas = "Aerolineas Argentinas";
    final static String Aeromexico = "Aeromexico";
    final static String Air_Canada = "Air Canada";
    final static String Air_France = "Air France";
    final static String Air_India = "Air India";
    final static String Air_New_Zealand = "Air New Zealand";
    final static String Alaska_Airlines = "Alaska Airlines";
    final static String Alitalia = "Alitalia";
    final static String All_Nippon_Airways = "All Nippon Airways";
    final static String American = "American";
    final static String Austrian_Airlines = "Austrian Airlines";
    final static String Avianca = "Avianca";
    final static String British_Airways = "British Airways";
    final static String Cathay_Pacific = "Cathay Pacific";
    final static String China_Airlines = "China Airlines";
    final static String Condor = "Condor";
    final static String COPA = "COPA";
    final static String Delta_Northwest = "Delta / Northwest";
    final static String Egyptair = "Egyptair";
    final static String El_Al = "El Al";
    final static String Ethiopian_Airlines = "Ethiopian Airlines";
    final static String Finnair = "Finnair";
    final static String Garuda_Indonesia = "Garuda Indonesia";
    final static String Gulf_Air = "Gulf Air";
    final static String Hawaiian_Airlines = "Hawaiian Airlines";
    final static String Iberia = "Iberia";
    final static String Japan_Airlines = "Japan Airlines";
    final static String Kenya_Airways = "Kenya Airways";
    final static String KLM= "KLM";
    final static String Korean_Air = "Korean Air";
    final static String LAN_Airlines = "LAN Airlines";
    final static String Lufthansa = "Lufthansa";
    final static String Malaysia_Airlines = "Malaysia Airlines";
    final static String Pakistan_International = "Pakistan International";
    final static String Philippine_Airlines = "Philippine Airlines";
    final static String Qantas = "Qantas";
    final static String Royal_Air_Maroc = "Royal Air Maroc";
    final static String SAS = "SAS";
    final static String Saudi_Arabian = "Saudi Arabian";
    final static String Singapore_Airlines = "Singapore Airlines";
    final static String South_African = "South African";
    final static String Southwest_Airlines = "Southwest Airlines";
    final static String Sri_Lankan_AirLanka = "Sri Lankan / AirLanka";
    final static String SWISS = "SWISS";
    final static String TACA = "TACA";
    final static String TAM = "TAM";
    final static String Air_Portugal = "Air Portugal";
    final static String Thai_Airways = "Thai Airways";
    final static String Turkish_Airlines = "Turkish Airlines";
    final static String United_Continental= "United / Continental";
    final static String US_Airways_America_West = "US Airways / America West";
    final static String Vietnam_Airlines = "Vietnam Airlines";
    final static String Virgin_Atlantic = "Virgin Atlantic";
    final static String Xiamen_Airlines= "Xiamen Airlines";

    @Override
    public void start(Stage stage) throws IOException {
        // set up the stage for the bar chart
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Airline accidents in different year intervals");
        xAxis.setLabel("Airline");
        yAxis.setLabel("Total number of fatal accidents");

        // add information for the barchart
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("1985-1999");
        series1.getData().add(new XYChart.Data(Aer_Lingus, 0));
        series1.getData().add(new XYChart.Data(Aeroflot, 14));
        series1.getData().add(new XYChart.Data(Aerolineas_Argentinas, 0));
        series1.getData().add(new XYChart.Data(Aeromexico, 1));
        series1.getData().add(new XYChart.Data(Air_Canada, 0));
        series1.getData().add(new XYChart.Data(Air_France, 4));
        series1.getData().add(new XYChart.Data(Air_India, 1));
        series1.getData().add(new XYChart.Data(Air_New_Zealand, 0));
        series1.getData().add(new XYChart.Data(Alaska_Airlines, 0));
        series1.getData().add(new XYChart.Data(Alitalia, 2));
        series1.getData().add(new XYChart.Data(All_Nippon_Airways, 1));
        series1.getData().add(new XYChart.Data(American, 5));
        series1.getData().add(new XYChart.Data(Austrian_Airlines, 0));
        series1.getData().add(new XYChart.Data(Avianca, 3));
        series1.getData().add(new XYChart.Data(British_Airways, 0));
        series1.getData().add(new XYChart.Data(Cathay_Pacific, 0));
        series1.getData().add(new XYChart.Data(China_Airlines, 6));
        series1.getData().add(new XYChart.Data(Condor, 1));
        series1.getData().add(new XYChart.Data(COPA, 1));
        series1.getData().add(new XYChart.Data(Delta_Northwest, 12));
        series1.getData().add(new XYChart.Data(Egyptair, 3));
        series1.getData().add(new XYChart.Data(El_Al, 1));
        series1.getData().add(new XYChart.Data(Ethiopian_Airlines, 5));
        series1.getData().add(new XYChart.Data(Finnair, 0));
        series1.getData().add(new XYChart.Data(Garuda_Indonesia, 3));
        series1.getData().add(new XYChart.Data(Gulf_Air, 0));
        series1.getData().add(new XYChart.Data(Hawaiian_Airlines, 0));
        series1.getData().add(new XYChart.Data(Iberia, 1));
        series1.getData().add(new XYChart.Data(Japan_Airlines, 1));
        series1.getData().add(new XYChart.Data(Kenya_Airways, 0));
        series1.getData().add(new XYChart.Data(KLM, 1));
        series1.getData().add(new XYChart.Data(Korean_Air, 5));
        series1.getData().add(new XYChart.Data(LAN_Airlines, 2));
        series1.getData().add(new XYChart.Data(Lufthansa, 1));
        series1.getData().add(new XYChart.Data(Malaysia_Airlines, 1));
        series1.getData().add(new XYChart.Data(Pakistan_International, 3));
        series1.getData().add(new XYChart.Data(Philippine_Airlines, 4));
        series1.getData().add(new XYChart.Data(Qantas, 0));
        series1.getData().add(new XYChart.Data(Royal_Air_Maroc, 3));
        series1.getData().add(new XYChart.Data(SAS, 0));
        series1.getData().add(new XYChart.Data(Saudi_Arabian, 2));
        series1.getData().add(new XYChart.Data(Singapore_Airlines, 2));
        series1.getData().add(new XYChart.Data(South_African, 1));
        series1.getData().add(new XYChart.Data(Southwest_Airlines, 0));
        series1.getData().add(new XYChart.Data(Sri_Lankan_AirLanka, 1));
        series1.getData().add(new XYChart.Data(SWISS, 1));
        series1.getData().add(new XYChart.Data(TACA, 1));
        series1.getData().add(new XYChart.Data(TAM, 3));
        series1.getData().add(new XYChart.Data(Air_Portugal, 0));
        series1.getData().add(new XYChart.Data(Thai_Airways, 4));
        series1.getData().add(new XYChart.Data(Turkish_Airlines, 3));
        series1.getData().add(new XYChart.Data(United_Continental, 8));
        series1.getData().add(new XYChart.Data(US_Airways_America_West, 7));
        series1.getData().add(new XYChart.Data(Vietnam_Airlines, 3));
        series1.getData().add(new XYChart.Data(Virgin_Atlantic, 0));
        series1.getData().add(new XYChart.Data(Xiamen_Airlines, 1));

        // create the double bar chart
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2000-2014");
        series2.getData().add(new XYChart.Data(Aer_Lingus, 0));
        series2.getData().add(new XYChart.Data(Aeroflot, 1));
        series2.getData().add(new XYChart.Data(Aerolineas_Argentinas, 0));
        series2.getData().add(new XYChart.Data(Aeromexico, 0));
        series2.getData().add(new XYChart.Data(Air_Canada, 0));
        series2.getData().add(new XYChart.Data(Air_France, 2));
        series2.getData().add(new XYChart.Data(Air_India, 1));
        series2.getData().add(new XYChart.Data(Air_New_Zealand, 1));
        series2.getData().add(new XYChart.Data(Alaska_Airlines, 1));
        series2.getData().add(new XYChart.Data(Alitalia, 0));
        series2.getData().add(new XYChart.Data(All_Nippon_Airways, 0));
        series2.getData().add(new XYChart.Data(American, 3));
        series2.getData().add(new XYChart.Data(Austrian_Airlines, 0));
        series2.getData().add(new XYChart.Data(Avianca, 0));
        series2.getData().add(new XYChart.Data(British_Airways, 0));
        series2.getData().add(new XYChart.Data(Cathay_Pacific, 0));
        series2.getData().add(new XYChart.Data(China_Airlines, 1));
        series2.getData().add(new XYChart.Data(Condor, 0));
        series2.getData().add(new XYChart.Data(COPA, 0));
        series2.getData().add(new XYChart.Data(Delta_Northwest, 2));
        series2.getData().add(new XYChart.Data(Egyptair, 1));
        series2.getData().add(new XYChart.Data(El_Al, 0));
        series2.getData().add(new XYChart.Data(Ethiopian_Airlines, 2));
        series2.getData().add(new XYChart.Data(Finnair, 0));
        series2.getData().add(new XYChart.Data(Garuda_Indonesia, 2));
        series2.getData().add(new XYChart.Data(Gulf_Air, 1));
        series2.getData().add(new XYChart.Data(Hawaiian_Airlines, 0));
        series2.getData().add(new XYChart.Data(Iberia, 0));
        series2.getData().add(new XYChart.Data(Japan_Airlines, 0));
        series2.getData().add(new XYChart.Data(Kenya_Airways, 2));
        series2.getData().add(new XYChart.Data(KLM, 0));
        series2.getData().add(new XYChart.Data(Korean_Air, 0));
        series2.getData().add(new XYChart.Data(LAN_Airlines, 0));
        series2.getData().add(new XYChart.Data(Lufthansa, 0));
        series2.getData().add(new XYChart.Data(Malaysia_Airlines, 2));
        series2.getData().add(new XYChart.Data(Pakistan_International, 2));
        series2.getData().add(new XYChart.Data(Philippine_Airlines, 1));
        series2.getData().add(new XYChart.Data(Qantas, 0));
        series2.getData().add(new XYChart.Data(Royal_Air_Maroc, 0));
        series2.getData().add(new XYChart.Data(SAS, 1));
        series2.getData().add(new XYChart.Data(Saudi_Arabian, 0));
        series2.getData().add(new XYChart.Data(Singapore_Airlines, 1));
        series2.getData().add(new XYChart.Data(South_African, 0));
        series2.getData().add(new XYChart.Data(Southwest_Airlines, 0));
        series2.getData().add(new XYChart.Data(Sri_Lankan_AirLanka, 0));
        series2.getData().add(new XYChart.Data(SWISS, 0));
        series2.getData().add(new XYChart.Data(TACA, 1));
        series2.getData().add(new XYChart.Data(TAM, 2));
        series2.getData().add(new XYChart.Data(Air_Portugal, 0));
        series2.getData().add(new XYChart.Data(Thai_Airways, 1));
        series2.getData().add(new XYChart.Data(Turkish_Airlines, 2));
        series2.getData().add(new XYChart.Data(United_Continental, 2));
        series2.getData().add(new XYChart.Data(US_Airways_America_West, 2));
        series2.getData().add(new XYChart.Data(Vietnam_Airlines, 0));
        series2.getData().add(new XYChart.Data(Virgin_Atlantic, 0));
        series2.getData().add(new XYChart.Data(Xiamen_Airlines, 0));

        // display the double bar chart
        Scene scene  = new Scene(bc,1000,1000);
        bc.getData().addAll(series1,series2);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}

