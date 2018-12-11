package java8;

import java.util.Optional;

public class OptionalMain {

	public String getCarInsuraceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
					.flatMap(Car::getInsurance)
					.map(Insurance::getName)
					.orElse("unKonwn..");
	}
}
