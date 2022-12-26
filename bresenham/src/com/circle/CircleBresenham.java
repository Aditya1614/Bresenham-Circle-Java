package com.circle;

import java.awt.*;
import javax.swing.*;

public class CircleBresenham extends JPanel {

    public void eightPlot(int x, int y, int xOffset, int yOffset, Graphics g){
        
        // untuk pixel (x, y)
        // Quadrant 
        int xPlot = Math.round(xOffset + x);
        int yPlot = Math.round(yOffset + y);
        g.drawLine(xPlot, yPlot, xPlot, yPlot);
                
        xPlot = Math.round(xOffset + x );
        yPlot = Math.round(yOffset - y);
        g.drawLine(xPlot, yPlot, xPlot, yPlot);
        
        xPlot = Math.round(xOffset + x );
        yPlot = Math.round(yOffset - y);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        xPlot = Math.round(xOffset - x);
        yPlot = Math.round(yOffset - y);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        
        // untuk pixel (y, x)
        // Quadrant 
        xPlot = Math.round(xOffset - x);
        yPlot = Math.round(yOffset + y);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        xPlot = Math.round(xOffset + y);
        yPlot = Math.round(yOffset + x);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        xPlot = Math.round(xOffset + y );
        yPlot = Math.round(yOffset - x);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        xPlot = Math.round(xOffset - y);
        yPlot = Math.round(yOffset - x);
        g.drawLine(xPlot,yPlot,xPlot,yPlot);
        
        xPlot = Math.round(xOffset - y);
        yPlot = Math.round(yOffset + x);
        g.drawLine(xPlot, yPlot, xPlot, yPlot);
                
    } // eightPlot
    
    public void bresenhamCircle(int x0, int y0, int radius, Graphics g){
        
        int x = 0;
        int y = radius;
        
        // jika hasil nilai di > 0, maka akan menampilkan pixel plot 'P'
        int di = 3 - 2 * radius;

        // membuat sebuah titik pd koordinat yang ditentukan
        eightPlot(x, y, x0, y0, g);
        
        
        // lakukan perulangan selama x < y
        while(x < y) {
                        
            // jika di  'kurang dari' 0 atau jika pixel plot 'S' yg dipilih
            if (di < 0) {
                di += 4 * x + 6;    // maka tampilkan persamaan (8)
                g.setColor(Color.RED);
            } else {    // selain itu
                di += 4 * (x-y) + 10;   // maka tampilkan persamaan (9)
                g.setColor(Color.BLUE);
                y--;
            }
            
            eightPlot(x, y, x0, y0, g);
            x++;
        }
        
    }//bresenhamCircle
    
    public void paintComponent(Graphics g) {
        bresenhamCircle(100, 80, 50, g);
    } // paintComponent

    public static void main(String[] args) {
        // instansiasi object frame dan class CircleBresenham
        JFrame frame = new JFrame("Circle Bresenham Algorithm");
        CircleBresenham panelBresenham = new CircleBresenham();
        
        frame.add(panelBresenham);// menambah panel pd frame
      
        frame.setSize(215, 200); // set ukuran lebar dan tinggi frame
      
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // set button close berfungsi ketika diklik
      
        frame.setLocationRelativeTo(null);  // atur tampilan agar berada di tengah pd layar
      
        frame.setVisible(true); // menampilkan frame
    }
    
}