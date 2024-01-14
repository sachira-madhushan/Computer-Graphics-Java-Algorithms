import java.util.*;
import java.awt.*;
import java.applet.*;

public class BresenhamsCircle extends Applet{

	int maxX,maxY,centerX,centerY;
	void initgr(){
		Dimension d;
		d=getSize();
		maxX=d.width-1;
		maxY=d.height-1;
		centerX=maxX/2;
		centerY=maxY/2;
	}
	public void plotCircle(Graphics g,int h,int k,int x,int y){
		g.fillOval(x+h,y+k,5,5);
		g.fillOval(x+h,-y+k,5,5);
		g.fillOval(-x+h,y+k,5,5);
		g.fillOval(-x+h,-y+k,5,5);
		
		g.fillOval(y+h,x+k,5,5);
		g.fillOval(-y+h,x+k,5,5);
		g.fillOval(y+h,-x+k,5,5);
		g.fillOval(-y+h,-x+k,5,5);
	}

	public void drawCircle(Graphics g,int h ,int k,int r){

		int p=3-2*r;
		int x=0;
		int y=r;

		double xend=r/Math.sqrt(2) +0.5;
		plotCircle(g,h,k,x,y);
		for(x+=1;x<(int)xend;x++){
			if(p<0){
				p=p+2*x+6;
			}else{
				p=p+2*(x-y)+10;
				y=y-1;
			}
			plotCircle(g,h,k,x,y);
		}
	}

	public void paint(Graphics g){
		initgr();
		drawCircle(g,centerX,centerY,100);
	}

}

/*<applet code="BresenhamsCircle.class" width="1000" height="1000"></applet>*/