package java8;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Transaction {

	private Trader trader;
	private int year;
	private int value;
}
