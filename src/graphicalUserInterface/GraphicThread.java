/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicalUserInterface;


/**
 *
 * @author Wind Raider Zero
 */
public class GraphicThread extends Thread{
    GraphicPanel gPanel;
    String chartTitle;
    String seriesName;
    
    public GraphicThread(String chartTitle,String seriesName){
        gPanel = new GraphicPanel(chartTitle,seriesName);
        this.chartTitle=chartTitle;
        this.seriesName=seriesName;
    }
    
    @Override
    public void run(){
        while(true){
            gPanel=null;
            System.gc();
            gPanel = new GraphicPanel(chartTitle,seriesName);
            int i=0;
            while(i<10){
                try{
                    Thread.sleep(1000);
                    i++;
                }catch(InterruptedException ie){
                    break;
                }
            }
        }
    }
}
