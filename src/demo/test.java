package demo;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 0
		for (int n1 = 1; n1 <= 5; n1++) {
			for (int n2 = 1; n2 <= 5; n2++) {
				for (int n3 = 1; n3 <= 5; n3++) {
					for (int n4 = 1; n4 <= 5; n4++) {
						for (int n5 = 1; n5 <= 5; n5++) {
							for (int n6 = 1; n6 <= 5; n6++) {
								if (n1 - n2 == 1 || n2 - n1 == 1) {
									if (n2 - n3 == 1 || n3 - n2 == 1) {
										if (n3 - n4 == 1 || n4 - n3 == 1) {
											if (n4 - n5 == 1 || n5 - n4 == 1) {
												if (n5 - n6 == 1 || n6 - n5 == 1) {
													System.out.println(String.format("%d %d %d %d %d %d", n1, n2, n3, n4, n5, n6));
													number++;
												}
											}
										}
									}
								}

							}
						}
					}
				}

			}
		}
		System.out.println("共有：" + number);

	}

}
