

import java.util.List;

public class Penguin {
	
	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;
	
	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

	@Override
	public String toString() {
		return "Penguin{" +
				"name='" + name + '\'' +
				", race=" + race +
				", age=" + age +
				", matingPartners=" + matingPartners +
				'}';
	}

	public double getPenguinMatesAverageAge(){
		List<Penguin> penguins = this.getMatingPartners();
		double averageAge = 0;
		for (Penguin penguin : penguins) {
			averageAge += penguin.getAge();
		}
		return penguins.size() / averageAge;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Penguin penguin = (Penguin) o;

		if (Double.compare(penguin.age, age) != 0) return false;
		if (name != null ? !name.equals(penguin.name) : penguin.name != null) return false;
		if (race != penguin.race) return false;
		return matingPartners != null ? matingPartners.equals(penguin.matingPartners) : penguin.matingPartners == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name != null ? name.hashCode() : 0;
		result = 31 * result + (race != null ? race.hashCode() : 0);
		temp = Double.doubleToLongBits(age);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (matingPartners != null ? matingPartners.hashCode() : 0);
		return result;
	}
}
