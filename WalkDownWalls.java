import becker.robots.*;

// Create a new type of robot, named RobotThatCanWalkDownWalls on the next line(s)

class RobotThatCanWalkDownWalls extends Robot {
	// constructor
	public RobotThatCanWalkDownWalls(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	// You should create a new service named walkDownWall here:

	public void walkDownWall() {
		this.move();
		this.turnRight();
		this.move();
		this.move();
		this.move();
		this.turnLeft();
	}

}

public class WalkDownWalls extends Object {
	public static void main(String[] args) {
		City wallingford = new City();
		RobotThatCanWalkDownWalls jo = new RobotThatCanWalkDownWalls(wallingford, 0, 1, Direction.EAST, 0);
		// build the tower
		new Wall(wallingford, 0, 1, Direction.SOUTH);
		new Wall(wallingford, 1, 1, Direction.EAST);
		new Wall(wallingford, 2, 1, Direction.EAST);
		new Wall(wallingford, 3, 1, Direction.EAST);
		new Wall(wallingford, 3, 2, Direction.SOUTH);
		new Wall(wallingford, 4, 2, Direction.EAST);
		new Wall(wallingford, 5, 2, Direction.EAST);
		new Wall(wallingford, 6, 2, Direction.EAST);
		new Wall(wallingford, 6, 3, Direction.SOUTH);
		// Add a thing
		new Thing(wallingford, 3, 2);

		jo.walkDownWall();
		jo.pickThing();
		jo.walkDownWall();
		jo.move();
		jo.putThing();
	}
}
