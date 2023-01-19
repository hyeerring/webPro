package com.lec.ex03_speakertv;

public class TV implements IVolume {

	private int volumeLevel;
	private final int MAX_VOLUME = 30;
	private final int MIN_VOLUME = 0;

	public TV() {
		volumeLevel = 5;
	}

	@Override
	public void volumeUp() {
		// 볼륨 레벨 ++
		if (volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨이 1 올라갔습니다. 현재 볼륨: " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 최대치(" + MAX_VOLUME + ") 입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		// 볼륨 레벨을 level만큼 ++
		if (volumeLevel + level < MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨이 " + level + "올라갔습니다. 현재 볼륨: " + volumeLevel);
		} else {
			int tempLevel = MAX_VOLUME - volumeLevel;
			volumeLevel = MAX_VOLUME;
			System.out.println("TV 볼륨이 " + tempLevel + "만큼 올라가 최대치(" + MAX_VOLUME + ") 입니다.");
		}
	}

	@Override
	public void volumedown() {
		// 볼륨 레벨 --
		if (volumeLevel > MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨이 1 내려갔습니다. 현재 볼륨: " + volumeLevel);
		} else {
			System.out.println("더이상 볼륨을 내릴 수 없습니다.");
		}
	}

	@Override
	public void volumedown(int level) {
		// 볼륨 레벨을 level만큼 --
		if (volumeLevel - level > MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 " + level + "만큼 내렸습니다. 현재볼륨: " + volumeLevel);
		} else {
			int tempLevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("TV 볼륨을 " + tempLevel + "만큼 내렸습니다. 더이상 볼륨을 내릴 수 없습니다.");
		}
	}

}
