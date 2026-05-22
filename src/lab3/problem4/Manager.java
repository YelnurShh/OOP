package lab3.problem4;

import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {
	Vector<Employee> team;
	double bonus;

	Manager() {
		super();
		team = new Vector<>();
		bonus = 0;
	}

	Manager(String n, double s, Date h, String i, double b) {
		super(n, s, h, i);
		team = new Vector<>();
		bonus = b;
	}

	double getBonus() {
		return bonus;
	}

	void setBonus(double b) {
		bonus = b;
	}

	Vector<Employee> getTeam() {
		return team;
	}

	void addEmployee(Employee e) {
		team.add(e);
	}

	public String toString() {
		return "Manager{" + name + ", sal=" + salary + ", bonus=" + bonus + ", team=" + team.size() + "}";
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Manager))
			return false;
		Manager m = (Manager) o;
		return super.equals(m) && bonus == m.bonus;
	}

	public int compareTo(Employee e) {
		if (!(e instanceof Manager))
			return super.compareTo(e);
		int r = Double.compare(salary, e.salary);
		return r != 0 ? r : Double.compare(bonus, ((Manager) e).bonus);
	}

	public Manager clone() throws CloneNotSupportedException {
		Manager c = (Manager) super.clone();
		c.team = new Vector<>();
		for (Employee e : team)
			c.team.add(e.clone());
		return c;
	}
}
