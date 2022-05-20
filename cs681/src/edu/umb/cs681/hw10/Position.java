package edu.umb.cs681.hw10;

public final class Position {
	private final double latitude, longitude, altitude;
	
	public Position(int latitude, int longitude, int altitude){
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude; 
	}
	
	
	public class Aircraft {
		private Position position; 
		
		public Aircraft(Position pos){ 
			position = pos; 
		}
		public void setPosition(Position pos){
			position = pos; 
		}
		public Position getPosition(){ 
			return position;
		} 
	}
	
	
}
