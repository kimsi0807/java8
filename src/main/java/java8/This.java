package java8;

public class This {
	public final int value = 1;
	public void doIt() {
		int value = 2;
		Runnable runnable = new Runnable() {
			public final int value =3;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 4;
				System.out.println(this.value);	//3
				System.out.println(value);	//4
			}
		};
		runnable.run();
	}
	public static void main(String ...args) {
		This m = new This();
		System.out.println(m.value);	//1
		m.doIt();
	}
}
