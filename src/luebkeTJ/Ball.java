package luebkeTJ;

import java.util.ArrayList;
import java.util.List;

public class Ball {
	boolean lastTouching = false;
	int lastTouchingTime = 0;
	Vector pos = new Vector();
	Vector velo = new Vector();
	List<Vector> goTo = new ArrayList<Vector>();
	List<Data> points = new ArrayList<Data>();
	Vector lastPos = new Vector();
	int goToOn = 0;
	boolean Popped = false;
}
