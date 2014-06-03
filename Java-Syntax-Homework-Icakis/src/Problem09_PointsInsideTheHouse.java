import java.util.Locale;
import java.util.Scanner;


public class Problem09_PointsInsideTheHouse {

	public static boolean onTheRightSide(double [] firstPoint,double[]secondPoint,double X,double Y){
		
		if((secondPoint[0]-firstPoint[0])*(Y-firstPoint[1])-(secondPoint[1]-firstPoint[1])*(X-firstPoint[0])<0){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		double x = 0;
		double y= 0;
		while(!Pass){
			try {
				System.out.print("Input point coordinates (x,y):");
				Scanner input = new Scanner(System.in);
				x = input.nextDouble();
				y = input.nextDouble();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		//check first rectangle (bigger one)
		boolean rect1 = false;
		if(x<=17.5 && x>=12.5 && y<=13.5 && y>=8.5){
			rect1 =true;
		}
		//check second rectangle 
		boolean rect2 = false;
		if(x<=22.5 && x>=20 && y<=13.5 && y>=8.5){
			rect2 =true;
		}
		boolean triangle = false;
		//check triangle
		double[]pointA={12.5,8.5};
		double[]pointB={17.5,3.5};
		double[]pointC={22.5,8.5};
		//Test Input- 12.5 6 -Wrong!It's Outside -look the picture
		if(onTheRightSide(pointA,pointB,x,y) && onTheRightSide(pointB,pointC,x,y) && onTheRightSide(pointC,pointA,x,y)){
			triangle = true;
		}
		if(rect1||rect2||triangle){
			System.out.println("Inside");
		}
		else{
			System.out.println("Outside");
		}
	}

}
