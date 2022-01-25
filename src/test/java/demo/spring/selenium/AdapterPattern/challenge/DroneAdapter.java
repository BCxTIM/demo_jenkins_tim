package demo.spring.selenium.AdapterPattern.challenge;

import demo.spring.selenium.AdapterPattern.Duck;

public class DroneAdapter implements Duck {
	Drone drone;
 
	public DroneAdapter(Drone drone) {
		this.drone = drone;
	}
    
	public void quack() {
		drone.beep();
	}
  
	public void fly() {
		drone.spin_rotors();
		drone.take_off();
	}
}
