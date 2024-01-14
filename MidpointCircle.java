import java.util.*;
import java.awt.*;
import java.applet.*;

public class MidpointCircle extends Applet{
	int centerX,centerY;
	void initgr(){
		Dimension d;
		d=getSize();
		centerX=(d.width-1)/2;
		centerY=(d.height-1)/2;
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

	public void drawCircle(Graphics g,int h,int k,int radias){
		int x=0;
		int y=radias;
		int p=(5/4-radias);
		plotCircle(g,h,k,x,y);
		while(x<=y){
			if(p<0){
				p=p*2*x;
			}else{
				p=p*2*x-2*y;
				y-=1;
			}
			x+=1;

			plotCircle(g,h,k,x,y);
		}
	}

	public void paint(Graphics g){
		initgr();
		drawCircle(g,centerX,centerY,100);
	}
}

/*<applet code="MidpointCircle.class" width="1000" height="1000"></applet>*/