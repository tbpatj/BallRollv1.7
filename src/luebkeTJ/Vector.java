package luebkeTJ;

public class Vector {
	double x;
	double y;
	double z;

	public boolean equals(Vector v)
	{
		//Distance = Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y-y2)) + ((z - z2) * (z - z2)));
		
		
		if(v.x == this.x && v.y == this.y && v.z == this.z)
		{
			return true;
		}
		
		return false;
	}
	public double magnitude()
	{
		//remove if it returns wrong value
		/**
		if((Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z))) == 0)
		{
			return 1;
		}
		*/
			return (Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z)));
		
	}
	static Vector newVector(double x, double y, double z)
	{
		Vector v = new Vector();
		v.x = x;
		v.y = y;
		v.z = z;
		return v;
	}
	public double length()
	{
		return (((this.x * this.x) + (this.y * this.y) + (this.z * this.z)));
	}
	public double dot( Vector w)
	{
		return (this.x * w.x) + (this.y * w.y) + (this.z * w.z);
	}
	public Vector subtract(Vector v2)
	{
		Vector v = new Vector();
		v.x = this.x - v2.x;
		v.y = this.y - v2.y;
		v.z = this.z - v2.z;
		return v;
	}
	
	static Vector closestPointOnLine(Vector a, Vector b, Vector p)
	{
		Vector c = b.subtract(a);
		Vector v = p.subtract(a);
		double d = v.magnitude();
		v = v.normalize();
		double t = v.dot(c);
		
		if(t < 0.0f)
		{
			return (a);
		}
		if(t > d)
		{
			return (b);
		}
		v.x = v.x * t;
		v.y = v.y * t;
		v.z = v.z * t;
		return (a.add( v));
	}
	
	static Vector closestPointOnTriangle(Vector a, Vector b, Vector c, Vector p)
	{
		Vector Rab = closestPointOnLine(a,b,p);
		Vector Rbc = closestPointOnLine(b,c,p);
		Vector Rca = closestPointOnLine(c,a,p);
		
		double dAB = (p.subtract(Rab)).magnitude();
		double dBC = (p.subtract(Rbc)).magnitude();
		double dCA = (p.subtract(Rca)).magnitude();
		
		double min = dAB;
		Vector result = Rab;
		
		if(dBC < min)
		{
			min = dBC;
			result = Rbc;
		}
		if(dCA < min)
		{
			min = dBC;
			result = Rca;
		}
		return (result);
	}
	public Vector add(Vector v2)
	{
		Vector v = new Vector();
		v.x = this.x + v2.x;
		v.y = this.y + v2.y;
		v.z = this.z + v2.z;
		return v;
	}
	public Vector multiply(Vector v2)
	{
		Vector v = new Vector();
		v.x = this.x * v2.x;
		v.y = this.y * v2.y;
		v.z = this.z * v2.z;
		return v;
	}
	public double squaredLength()
	{
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}
	public Vector setLength(double d)
	{
		Vector v = this.normalize();
		v.x = v.x * d;
		v.y = v.y * d;
		v.z = v.z * d;
		return v;
	}
	public Vector subtractNonVec(double sub)
	{
		Vector v = new Vector();
		v.x = this.x - sub;
		v.y = this.y - sub;
		v.z = this.z - sub;
		return v;
	}
	public Vector divide(Vector sub)
	{
		Vector v = new Vector();
		v.x = this.x / sub.x;
		v.y = this.y / sub.y;
		v.z = this.z / sub.z;
		return v;
	}
	public Vector divideNon(double sub)
	{
		Vector v = new Vector();
		v.x = this.x / sub;
		v.y = this.y / sub;
		v.z = this.z / sub;
		return v;
	}
	public Vector addNonVec(double sub)
	{
		Vector v = new Vector();
		v.x = this.x + sub;
		v.y = this.y + sub;
		v.z = this.z + sub;
		return v;
	}
	public Vector multiplyNonVec(double sub)
	{
		Vector v = new Vector();
		v.x = this.x * sub;
		v.y = this.y * sub;
		v.z = this.z * sub;
		return v;
	}
	public Vector normalize()
	{
		Vector v1 = this;
		Vector v = new Vector();
		v.x = this.x / v1.magnitude();
		v.y = this.y / v1.magnitude();
		v.z = this.z / v1.magnitude();
		return v;
	}
	public double distanceTo(Vector To)
	{
		return Math.sqrt(((To.x - this.x) * (To.x - this.x)) + ((To.y - this.y) * (To.y - this.y)) + ((To.z - this.z) * (To.z - this.z)));
	}
	static Vector scale(double s, Vector right)
	{
		Vector v = new Vector();
		v.x = s * right.x;
		v.y = s * right.y;
		v.z = s * right.z;
		return v;
	}
	public Vector Perpendicular()
	{
		Vector v = new Vector();
		v.x = this.x;
		v.y = this.y;
		v.z = this.z;
		return v;
	}
	public Vector crossProduct( Vector v2)
	{
		Vector v = new Vector();
		v.x = (this.y * v2.z) - (this.z * v2.y);
		v.y = (this.z * v2.x) - (this.x * v2.z);
		v.z = (this.x * v2.y) - (this.y * v2.x);
		return v;
	}
	
	public Vector cross(Vector t)
	{
		Vector v = new Vector();
		v.x = this.x * t.y;
		v.z = this.z * t.y;
		v.y = this.y * ((t.x + t.z) / 2);
		
		return v;
	}
	static public double anglePhi(Vector v, Vector w)
	{
		return ((v.x * w.x) + (v.y * w.y) + (v.z * w.z)) / (Math.sqrt((v.x * v.x) + (v.y * v.y) + (v.z * v.z)) * Math.sqrt((w.x * w.x) + (w.y * w.y) + (w.z * w.z))); 
	}
	
}
