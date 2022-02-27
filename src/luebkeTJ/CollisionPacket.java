package luebkeTJ;

public class CollisionPacket {
	Vector eRadius = new Vector();
	
	Vector R3Velocity = new Vector();
	Vector R3Position = new Vector();
	
	Vector velocity = new Vector();
	Vector normalizedVelocity = new Vector();
	Vector BasePoint = new Vector();
	
	boolean foundCollision;
	double nearestDistance;
	Vector intersectionPoint = new Vector();
}
