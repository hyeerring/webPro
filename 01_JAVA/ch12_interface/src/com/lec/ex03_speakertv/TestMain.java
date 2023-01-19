package com.lec.ex03_speakertv;

public class TestMain {

	public static void main(String[] args) {
		IVolume speaker = new Speaker();
		IVolume tv = new TV();
		IVolume[] devices = { speaker, tv };

		for (IVolume device : devices) {
			device.volumedown();
			device.volumedown(10);
			device.setMute(true);
			device.setMute(false);
			device.volumeUp();
			device.volumeUp(20);
			System.out.println("----------");
		}
		speaker.setMute(true);
		IVolume.chargeBattery();
	}

}
