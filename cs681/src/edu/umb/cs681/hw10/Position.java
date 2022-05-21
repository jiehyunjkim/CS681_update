package edu.umb.cs681.hw10;

public final class Position {
	private final double latitude, longitude, altitude;
	
	public Position(double latitude, double longitude, double altitude){
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude; 
	}
	
	public String toString(){
		return ("(" +latitude + ", " + longitude + ", " + altitude + ")");
	}
		
		
	public boolean equals(Position p){
		return (latitude == p.latitude && longitude == p.longitude && altitude == p.altitude);
	}
		
	public Position changeLat(double newLat){
		return new Position(newLat, this.longitude, this.altitude); 
	}
	
	public Position changeLon(double newLon) {
		return new Position(this.latitude, newLon, this.altitude);
	}
	
	public Position changeAlt(double newAlt) {
		return new Position(this.latitude, this.longitude, newAlt);
	};
	
	
	
}
