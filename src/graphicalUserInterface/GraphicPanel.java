/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicalUserInterface;

import javafx.embed.swing.JFXPanel;


/**
 *
 * @author Wind Raider Zero
 */
public class GraphicPanel extends javax.swing.JPanel{
    JFXPanel pane ;
    GraphicCode gPanel;
    public GraphicPanel(){
        String data[][] = {
            {"Jan","23"},
            {"Feb","14"},
            {"Mar","15"},
            {"Apr","24"},
            {"May","34"},
            {"Jun","36"},
            {"Jul","22"},
            {"Aug","45"},
            {"Sep","43"},
            {"Oct","17"},
            {"Nov","29"},
            {"Dec","25"}
        };
        
        gPanel = new GraphicCode();
        pane = new JFXPanel();
        gPanel.setChartTitle("Grafik monitoring Z Score");
        gPanel.setSeriesName("baby Z Score");
        gPanel.refreshData(pane,560,220,data);
        this.add(pane);
        pane.setVisible(true);
    }
    
    public GraphicPanel(String chartTitle,String seriesName){
        gPanel = new GraphicCode();
        pane = new JFXPanel();
        gPanel.setChartTitle("Grafik monitoring Z Score");
        gPanel.setSeriesName("baby Z Score");
    }
    
    public void refreshGraphic(String[][]data){
        gPanel.refreshData(pane,560,220,data);
        this.add(pane);
        pane.setVisible(true);
    }
    
    public void refreshGraphic(String[][]data,String chartTitle,String seriesName){
        this.refreshGraphic(data,chartTitle,seriesName,"age (month)","z score");
    }
    public void refreshGraphic(String[][]data,String chartTitle,String seriesName, String x, String y){
        gPanel.setChartTitle(chartTitle);
        gPanel.setSeriesName(seriesName);
        gPanel.refreshData(pane,560,220,data,x,y);
        this.add(pane);
        pane.setVisible(true);
    }
}
