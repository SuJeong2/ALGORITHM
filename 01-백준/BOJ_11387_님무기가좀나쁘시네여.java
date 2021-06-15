package com.ssafy.Jun.day0615;

import java.util.Scanner;

public class BOJ_11387_님무기가좀나쁘시네여 {

	static class infos{
		int attack;
		int power;
		float critical;
		float ciritical_damage;
		float speed;
		
		public infos() {
			super();
		}
		public infos(int attack, int power, float critical, float ciritical_damage, float speed) {
			super();
			this.attack = attack;
			this.power = power;
			this.critical = (float) (critical*0.01);
			this.ciritical_damage = (float) (ciritical_damage*0.01);
			this.speed = (float) (speed*0.01);
		}
		@Override
		public String toString() {
			return "infos [attack=" + attack + ", power=" + power + ", critical=" + critical + ", ciritical_damage="
					+ ciritical_damage + ", speed=" + speed + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		infos[] info = new infos[4];
		for(int i=0; i<4; i++) {
			info[i]=new infos(sc.nextInt(), sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		compare(info[0],info[2],info[3]);
		compare(info[1],info[3],info[2]);
	}

	private static void compare(infos infos, infos infos2, infos infos3) {
		float original_power = getFightPower(infos);
		
		//자신의 현재 증가한 값을 빼주고 다른 사람의 무기를 장착했을 때 값을 증가시켜줌
		infos temp = new infos();
		temp.attack = infos.attack-infos2.attack+infos3.attack;
		temp.power = infos.power-infos2.power+infos3.power;
		temp.critical = infos.critical-infos2.critical+infos3.critical;
		temp.ciritical_damage = infos.ciritical_damage-infos2.ciritical_damage+infos3.ciritical_damage;
		temp.speed = infos.speed-infos2.speed+infos3.speed;
		
		float change_power = getFightPower(temp); //무기를 바꾼 다음 전투력 값
		
		//원래의 전투력과 무기를 바꾼 후의 전투력을 비교
		int result = Float.compare(original_power, change_power);
		
		if(result == 0) System.out.println(0);
		else if(result > 0) System.out.println("-");
		else System.out.println("+");
	}

	private static float getFightPower(infos infos) {
		float cal_power = 0;
		
		float t1=0;
		if(infos.power==0) t1=0;
		else t1 = (float)(infos.power)/(float)100;
		
		cal_power = infos.attack*(1+t1)* ((1-Math.min(1, infos.critical)) 
				+ Math.min(1, infos.critical) * infos.ciritical_damage) * (1+infos.speed);
		
		return cal_power;
	}

}
