import java.applet.*;
import java.awt.*;
import java.util.*;

public class Transform extends Applet{
	int centerX, centerY, dGrid = 1, maxX, maxY;
    
void initgr() {
	Dimension d;
	d = getSize();
	maxX = d.width - 1; 
	maxY = d.height - 1;
	centerX = maxX/2; centerY = maxY/2;
   	}
	
void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
    int dx, dy, p, x, y;
 	dx=Math.abs(x1-x0);
	dy=Math.abs(y1-y0);
 	x=x0;
	y=y0;
 
	if(Math.abs(dx)>Math.abs(dy)){
		p=2*dy-dx;
 		if(x0>x1){
 			x=x1;
 			x1=x0;

 			y=y1;
 			y1=y0;
 		}

		while(x<x1)
		{
			if(p>=0)
			{
				g.fillOval((int)x,(int)y,5,5);
				if(y>y1){
					y=y+1;
				}else{
					y=y-1;
				}
				
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
 		if(y0>y1){
 			x=x1;
 			x1=x0;

 			y=y1;
 			y1=y0;
 		}
		while(Math.abs(y)<Math.abs(y1))
		{
			if(p>=0)
			{
				g.fillOval((int)x,(int)y,5,5);
				if(x>x1){
					x=x+1;
				}else{
					x=x-1;
				}
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
	public void translate(Graphics g,int x[],int y[],int tx,int ty){
		int rectangleX[]=x;
		int rectangleY[]=y;
		for(int i=0;i<x.length;i++){
			rectangleX[i]+=tx;
			rectangleY[i]+=ty;
		}

		//drawRectangle(g,rectangleX,rectangleY);

	}

	public void scale(Graphics g,int x[],int y[],int sx,int sy){
		int rectangleX[]=x;
		int rectangleY[]=y;
		for(int i=0;i<x.length;i++){
			rectangleX[i]*=sx;
			rectangleY[i]*=sy;
		}

		//drawRectangle(g,rectangleX,rectangleY);
	}

	public void rotate(Graphics g,int x[],int y[],int pivoteX,int pivoteY,int angle){
		int rectangleX[]=new int[2];
		int rectangleY[]=new int[2];

		for(int i=0;i<2;i++){
			rectangleX[i]=(int)((x[i]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[i]-pivoteY)*Math.sin((Math.toRadians(angle)))));
			rectangleX[i]=(int)((x[i]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[i]-pivoteY)*Math.sin((Math.toRadians(angle)))));
		}

		/*int rectangleX[]=new int[4];
		int rectangleY[]=new int[4];
		rectangleX[0]=(int)((x[0]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[0]-pivoteY)*Math.sin((Math.toRadians(angle)))));
		rectangleX[1]=(int)((x[1]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[1]-pivoteY)*Math.sin((Math.toRadians(angle)))));
		rectangleX[2]=(int)((x[0]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[1]-pivoteY)*Math.sin((Math.toRadians(angle)))));
		rectangleX[3]=(int)((x[1]-pivoteX)*Math.cos((Math.toRadians(angle))-(y[0]-pivoteY)*Math.sin((Math.toRadians(angle)))));
		
		rectangleY[0]=(int)((x[0]-pivoteX)*Math.sin((Math.toRadians(angle))+(y[0]-pivoteY)*Math.cos((Math.toRadians(angle)))));
		rectangleY[1]=(int)((x[1]-pivoteX)*Math.sin((Math.toRadians(angle))+(y[1]-pivoteY)*Math.cos((Math.toRadians(angle)))));
		rectangleY[2]=(int)((x[0]-pivoteX)*Math.sin((Math.toRadians(angle))+(y[1]-pivoteY)*Math.cos((Math.toRadians(angle)))));
		rectangleY[3]=(int)((x[1]-pivoteX)*Math.sin((Math.toRadians(angle))+(y[0]-pivoteY)*Math.cos((Math.toRadians(angle)))));
		
		drawLine(g, centerX+rectangleX[0], centerY+rectangleY[0], centerX+rectangleX[2], centerY+rectangleY[2]);
		drawLine(g, centerX+rectangleX[0], centerY+rectangleY[0], centerX+rectangleX[3], centerY+rectangleY[3]);
		drawLine(g, centerX+rectangleX[2], centerY+rectangleY[2], centerX+rectangleX[1], centerY+rectangleY[1]);
		drawLine(g, centerX+rectangleX[3], centerY+rectangleY[3], centerX+rectangleX[1], centerY+rectangleY[1]);
		*/
		
	}

	public void reflectY(Graphics g,int x[],int y[]){
		int rectangleX[]=x;
		int rectangleY[]=y;
		for(int i=0;i<2;i++){
			rectangleX[i]*=-1;
		}
	}

	public void drawRectangle(Graphics g,int rectangleX[],int rectangleY[]){
		drawLine(g, centerX+rectangleX[0], centerY+rectangleY[0], centerX+rectangleX[1], centerY+rectangleY[0]);
		drawLine(g, centerX+rectangleX[0], centerY+rectangleY[0], centerX+rectangleX[0], centerY+rectangleY[1]);
		drawLine(g, centerX+rectangleX[1], centerY+rectangleY[0], centerX+rectangleX[1], centerY+rectangleY[1]);
		drawLine(g, centerX+rectangleX[0], centerY+rectangleY[1], centerX+rectangleX[1], centerY+rectangleY[1]);
	}
	public void paint(Graphics g){
		initgr();
		int rectangleX[]={50,100};
		int rectangleY[]={50,100};
		/*Graphics2D graphic=(Graphics2D)g;
		

		drawRectangle(g,rectangleX,rectangleY);
		graphic.draw(new Rectangle(centerX, centerY, 100,100));
		graphic.rotate(Math.toRadians(45), centerX, centerY);
		graphic.draw(new Rectangle(centerX, centerY, 100,100));

		graphic.scale(2,2);
		graphic.draw                                                                                                                    (new Rectangle(centerX, centerY, 200,200));
		*/


		drawRectangle(g,rectangleX,rectangleY);
		reflectY(g,rectangleX,rectangleY);

		drawRectangle(g,rectangleX,rectangleY);
		//graphic.translate(50,50);
		//graphic.draw(new Rectangle(centerX, centerY, 100,100));
		//scale(g,rectangleX,rectangleY,2,2);
		//drawRectangle(g,rectangleX,rectangleY);
		//translate(g,rectangleX,rectangleY,100,100);
		//drawRectangle(g,rectangleX,rectangleY);
		//rotate(g,rectangleX,rectangleY,0,0,60);
		//drawRectangle(g,rectangleX,rectangleY);
	}	

}

/*<applet code="Transform.class" width="1000" height="1000">
 </applet>

 */