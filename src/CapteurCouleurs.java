
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class CapteurCouleurs {

	private static EV3LargeRegulatedMotor elr2;
	private static EV3LargeRegulatedMotor elr1;
	private static SampleProvider color;

	public static void main(String[] args) {
		color = new EV3ColorSensor(SensorPort.S2);
		float[] sample = new float[color.sampleSize()];
		color.fetchSample(sample, 0);
		LCD.drawString(Float.toString(sample[0]), 0, 0);
		
		elr1 = new EV3LargeRegulatedMotor(MotorPort.B);
		elr2 = new EV3LargeRegulatedMotor(MotorPort.C);
		elr1.setSpeed(200);
		elr2.setSpeed(200);

		while (true) {
			color.fetchSample(sample, 0);
			LCD.drawString(Float.toString(sample[0]), 0, 0);

			if (sample[0] == Color.WHITE) {
				elr1.rotate(15);

			} else {
				elr2.rotate(15);

			}

		}

	}
}
