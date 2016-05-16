/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicalUserInterface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.embed.swing.JFXPanel;


/**
 *
 * @author Wind Raider Zero
 */
public class GraphicCode {
    Scene scene;  
    private String chartTitle;
    private String seriesName;
    private LineChart<String,Number> lineChart;
    
    public void setChartTitle(String chartName){
        this.chartTitle = chartName;
    }
    
    public void setSeriesName(String name){
        this.seriesName = name;
    }
    
    public void refreshData(JFXPanel stage,int width,int height, String [][]data){
        this.refreshData(stage, width,height,data,"age (month)","z score");
    }
    
    public void refreshData(JFXPanel stage,int width,int height, String [][]data, String xLabel, String yLabel){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
        lineChart = new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle(chartTitle);
        lineChart.setCreateSymbols(false);                                
        XYChart.Series series1 = new XYChart.Series();
        
        series1.setName(seriesName);
        refreshData (series1,data);
        scene  = new Scene(lineChart,width,height);       
        lineChart.getData().addAll(series1);
        
        stage.setScene(scene);
        stage.setVisible(true);
    }
    
    private void refreshData(XYChart.Series series, String[][]dataXY){
        for (String[] dataXY1 : dataXY) {
            series.getData().add(new XYChart.Data(dataXY1[0], Double.parseDouble(dataXY1[1])));
        }
    }
    
    private XYChart.Series createSeries(String seriesName){
        XYChart.Series series = new XYChart.Series();
        series.setName(seriesName);
        
        return series;
    }
}
