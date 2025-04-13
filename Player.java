package Lab3;

import java.util.Random;

public class Player {
	private int number;
	private float x;
	private float y;
	private float z = 0.0f;

	public Player(int number, float x, float y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}

	public float getZ() {
		return z;
	}

	public void move(float xDisp, float yDisp) {
		this.x += xDisp;
		this.y += yDisp;
	}

	public void jump(float zDisp) {
		this.z += zDisp;
	}

	public Boolean near(Ball2 ball) {
		float distance = (float) Math.sqrt(Math.pow(this.x - ball.getX(), 2) + Math.pow(this.y - ball.getY(), 2)
				+ Math.pow(this.z - ball.getZ(), 2));
		return distance < 8;
	}

	public void kick(Ball2 ball) {
		Random rand = new Random();
		ball.setX(ball.getX() + rand.nextInt(20));
		ball.setY(ball.getY() + rand.nextInt(20));
		ball.setZ(ball.getZ() + rand.nextInt(5));
	}

}