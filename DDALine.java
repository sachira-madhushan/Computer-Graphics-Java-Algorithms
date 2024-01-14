import java.util.*;
import java.applet.*;
import java.awt.*;

public class DDALine extends Applet{
	int maxX,maxY,centerX,centerY;
	void initgr(){
		Dimension d;
		d=getSize();
		maxX=d.width-1;
		maxY=d.height-1;
		centerX=maxX/2;
		centerY=maxY/2;
	}

	public void drawLine(Graphics g,int x1,int y1,int x2,int y2){
		float x,y,step,xend,dx,dy,xinc,yinc;
		dx=x2-x1;
		dy=y2-y1;
		if(Math.abs(dx)>Math.abs(dy)){
			step=dx;
		}else{
			step=dy;
		}
		
		xinc=dx/step;
		yinc=dy/step;
		if(x2<x1){
			int temp=x1;
			x1=x2;
			x2=temp;

			temp=y1;
			y1=y2;
			y2=temp;
		}

		x=x1;
		y=y1;

		g.fillOval((int)x,(int)y,5,5);
		for(int i=1;i<step;i++){
			x=x+xinc;
			y=y+yinc;
			g.fillOval((int)x,(int)y,5,5);
		}

	}

	public void paint(Graphics g){
		initgr();
		drawLine(g,centerX,centerY,centerX+100,centerY+100);
	}
}

/*<applet code="DDALine.class" width="1000" height="1000"></applet>*/