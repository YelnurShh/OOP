package Practice2;

public class Time {
	
	public static void main(String[] args) {
		Timet t = new Timet(23, 5, 6);
		System.out.println("Universal: " + t.toUniversal());
		System.out.println("Standard: " + t.toStandard());
		
		Timet t2 = new Timet(4, 24, 33);

		Timet t3 = t.add(t2); 
		
		System.out.println("T1 + T2: " + t3.toUniversal());
	}
}


	class Timet{
		
		private int hour;
		private int minute;
		private int second;
		
		public Timet(int h, int m, int s) {
			this.hour = h;
			this.minute = m;
			this.second = s;
		}
		
		public String toUniversal() {
			StringBuilder sb = new StringBuilder();
			
			if(hour < 10) sb.append("0").append(hour).append(":");
			else sb.append(hour).append(":");
			
			if(minute < 10) sb.append("0").append(minute).append(":");
			else sb.append(minute).append(":");
			
			if(second < 10) sb.append("0").append(second);
			else sb.append(second);
			
			return sb.toString();
		}
		
		public String toStandard() {
			 
			String unit = " AM";
			
			if(this.hour >= 12) {
				unit = " PM";
				if(this.hour > 12) this.hour -= 12;
			}
			if(this.hour == 0) this.hour = 12; 

			StringBuilder sb = new StringBuilder();
			
			if(this.hour < 10) sb.append("0").append(this.hour).append(":");
			else sb.append(this.hour).append(":");
			
			if(minute < 10) sb.append("0").append(minute).append(":");
			else sb.append(minute).append(":");
			
			if(second < 10) sb.append("0").append(second);
			else sb.append(second);
			
			sb.append(unit);
			
			return sb.toString();
		}
		
		public Timet add(Timet t2) {
		    int newHour = this.hour + t2.hour;
		    int newMinute = this.minute + t2.minute;
		    int newSecond = this.second + t2.second;

		    if (newSecond >= 60) {
		        newSecond -= 60;
		        newMinute++;
		    }

		    if (newMinute >= 60) {
		        newMinute -= 60;
		        newHour++;
		    }

		    if (newHour >= 24) {
		        newHour %= 24; 
		    }

		    return new Timet(newHour, newMinute, newSecond);
		}
		
	}