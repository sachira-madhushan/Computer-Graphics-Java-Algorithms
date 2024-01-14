import java.applet.*;
import java.awt.*;
import java.util.*;

public class bresenhams extends Applet{
	int centerX, centerY, dGrid = 1, maxX, maxY;
    
void initgr() {
	Dimension d;	// get the window size and compute minimum, maximum and center
	d = getSize();
	maxX = d.width - 1; 
	maxY = d.height - 1;
	centerX = maxX/2; centerY = maxY/2;
   	}
	
void drawLine(Graphics g, int x0, int y0, int x1, int y1) { // Bresenhams Algorithm 
    int dx, dy, p, x, y;
 	dx=x1-x0;
	dy=y1-y0;
 	x=x0;
	y=y0;
 
	if(Math.abs(dx)>Math.abs(dy)){
		p=2*dy-dx;
 
		while(x<x1)
		{
			if(p>=0)
			{
				g.fillOval((int)x,(int)y,5,5);
				y=y+1;
				p=p+2*dy-2*dx;
			}
			else
			{
				g.fillOval((int)x,(int)y,5,5);
				p=p+2*dy;
			}
			x=x+1;
		}
	}

else{
		p=2*dx-dy;
 
		while(Math.abs(y)<Math.abs(y1))
		{
			if(p>=0)
			{
				g.fillOval((int)x,(int)y,5,5);
				x=x+1;
				p=p+2*dx-2*dy;
			}
			else
			{
				g.fillOval((int)x,(int)y,5,5);
				p=p+2*dx;
			}
			y=y+1;
		}
	}
}
	
	public void paint(Graphics g){
		initgr();
		drawLine(g, centerX, centerY, centerX+100, centerY);
		drawLine(g, centerX, centerY, centerX, centerY+100);
		drawLine(g, centerX+100, centerY, centerX+100, centerY+100);
		drawLine(g, centerX, centerY+100, centerX+100, centerY+100);
		drawLine(g, centerX, centerY, centerX+100, centerY+100);
		
		//drawLine(g, centerX, centerY-240, centerX+240, centerY+100);
		//drawLine(g, centerX, centerY-240, centerX-240, centerY+100);
		//drawLine(g, centerX-240, centerY+100, centerX+240, centerY+100);
		
		//drawLine(g, 100, 100, 500, 1000);
		//drawLine(g, 500, 500, 1500, 800);
		
	}	

}

/*<applet code="bresenhams.class" width="1000" height="1000">
 </applet>

 */