package domain;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    int x=0,y=0,angleX=1,angleY=1;
    int i=400,j=600, angleI=1,angleJ=1;


    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        
        //ciclo infinito
        while (true){
            
            
            this.moveCircle();
            this.moveRectangle();
            this.createImages();
            

            //pone en espera el flujo del programa
Thread.sleep(5);
        }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveCircle() {
      
        if(x+angleX<0){
            angleX=1;
        }else if(x+angleX>myDisplayer.getWidth()-50){
            angleX=-1;
        }else if(y+angleY<0){
            angleY=1;
        }else if(y+angleY>myDisplayer.getHeight()-50){
            angleY=-1;
        }
        
        x=x+angleX;
        y=y+angleY;
        
        getMyCircle().setRow(y);
        getMyCircle().setColumn(x);
        getMyRectangle().setRow(y);
        getMyRectangle().setColumn(x);
     }
    
    public void moveRectangle() {
      
        if(i+angleI<0){
            angleI=1;
        }else if(i+angleI>myDisplayer.getWidth()-50){
            angleI=-1;
        }else if(j+angleJ<0){
            angleJ=1;
        }else if(j+angleJ>myDisplayer.getHeight()-50){
            angleJ=-1;
        }
        
        i=i+angleI;
        j=j+angleJ;
        getMyRectangle().setRow(j);
        getMyRectangle().setColumn(i);
     }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public  domain.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(domain.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    

}
