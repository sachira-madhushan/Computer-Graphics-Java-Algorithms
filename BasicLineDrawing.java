import java.applet.*;
import java.awt.*;
import java.util.*;

public class BasicLineDrawing extends Applet{

	int maxX,maxY,centerX,centerY;

	void initgr(){
		Dimension d;
		d= getSize();
		maxX=d.width-1;
		maxY=d.height-1;
		centerX=maxX/2;
		centerY=maxY/2;
	}

	public void drawLine(Graphics g,int x1,int y1,int x2,int y2){
		float dx,dy,x,y;
		float m;
		y1=-1*y1;
		y2=-1*y2;
		dx=x2-x1;
		dy=y2-y1;
		m=dx/dy;
		x=x1;
		y=y1;
		g.fillOval(centerX+(int)x,centerY+(int)y,5,5);
		for(int i=(int)x+1;x<x2;i++){
			y=y+m;
			x=i;
			g.fillOval(centerX+(int)x,centerY+(int)y,5,5);
		}
	}

	public void paint(Graphics g){
		initgr();
		drawLine(g,2,3,200,500);
	}

	
}

/*<applet code="BasicLineDrawing.class" width="1000" height="1000"></applet>*/
