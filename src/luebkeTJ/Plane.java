package luebkeTJ;

public class Plane {
	double equation[] = {0,0,0,0};
	Vector orgin = new Vector();
	Vector normal = new Vector();
	
	Plane returnPlane(Vector orgin, Vector normal)
	{
		Plane p = new Plane();
		p.normal = normal;
		p.orgin = orgin;
		p.equation[0] = normal.x;
		p.equation[1] = normal.y;
		p.equation[2] = normal.z;
		p.equation[3] = -(normal.x * orgin.x + normal.y * orgin.y + normal.z * orgin.z);
		return p;
	}
	Plane fromTri(Vector p1, Vector p2, Vector p3)
	{
		Vector p4 = new Vector();
		p4 = p2.subtract(p1);
		p2 = p3.subtract(p1);
		Plane p = new Plane();
		p.normal = p4.crossProduct(p2);
		p.normal = p.normal.normalize();
		p.orgin = p1;
		p.equation[0] = p.normal.x;
		p.equation[1] = p.normal.y;
		p.equation[2] = p.normal.z;
		p.equation[3] = -(p.normal.x * p.orgin.x + p.normal.y * p.orgin.y + p.normal.z * p.orgin.z);
		return p;
	}
	boolean isFrontFactingTo(Vector direction)
	{
		double dot = this.normal.dot(direction);
		return (dot <= 0);
	}
	double signedDistanceTo(Vector point)
	{
		return ((point.dot(this.normal)) + this.equation[3]);
	}
	
}
