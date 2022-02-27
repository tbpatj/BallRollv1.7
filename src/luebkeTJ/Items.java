package luebkeTJ;

import java.util.ArrayList;
import java.util.List;

public class Items {
	int Type = 0;
	boolean NoMore = true;
	MyTime coolDown = new MyTime();
	Vector rotation = new Vector();
	Rotators rotate = new Rotators();
	double changeY = -0.01;
	double changedY = 0;
	static List<Data> settingUpItem = new ArrayList<Data>();
	Vector pos = new Vector();
	public List<Data> returnItemToDraw(Items item)
	{
		return settingUpItem;
	}
	
	static void setUpTriangle(Vector rot,Vector pos,double x, double y, double z,double x2, double y2, double z2, double x3, double y3, double z3,double Red, double Green, double Blue,boolean collide)
	{
		Data d = new Data();
		d.v1.x = x;
		d.v1.y = y;
		d.v1.z = z;
		d.v2.x = x2;
		d.v2.y = y2;
		d.v2.z = z2;
		d.v3.x = x3;
		d.v3.y = y3;
		d.v3.z = z3;
		
		d.mid.x = (d.v1.x + d.v2.x + d.v3.x) / 3;
		d.mid.y = (d.v1.y + d.v2.y + d.v3.y) / 3;
		d.mid.z = (d.v1.z + d.v2.z + d.v3.z) / 3;
		d.Red = Red;
		d.Green = Green;
		d.Blue = Blue;
		d.v1Normal = getSurfaceNormal(d);
		d.v2Normal = d.v1Normal;
		d.v3Normal = d.v1Normal;
		d.normal = d.v1Normal;
		d.Collide = collide;
		
		settingUpItem.add(d);
	}
	static Vector getSurfaceNormal(Data d)
	{
			Vector v1 = d.v2.subtract( d.v1);
			Vector v2 = d.v3.subtract(d.v1);
			Vector normal = v1.crossProduct(v2);
			normal = normal.normalize();
			return normal;
	}
}
