import java.util.Random;

public class Game {
	private Input input = new Input();
	private Cell[][] cell = new Cell[10][10];
	private Ladder[] ladder;
	private Snake[] snake;
	private Player r1 = new Player("r1");
	private Player r2 = new Player("r2");
	private Random r = new Random();
	static int nL;
	static int nS;

	public void setBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cell[i][j] = new Cell();
				cell[i][j].setTypeCell(" 0");
				if ((i % 2) == 0) {
					int a = ((9 - i) * 10) + (10 - j);
					cell[i][j].setNumberCell(a);
				} else {
					int a = ((9 - i) * 10) + (j + 1);
					cell[i][j].setNumberCell(a);
				}
			}
			// System.out.println();
		}
	}

	public void setGame() {
		input.setNumberLadder();
		nL = input.getNumberLadder();
		ladder = new Ladder[nL];

		for (int i = 0; i < ladder.length; i++) {
			ladder[i] = new Ladder();
			ladder[i].setLadder();
		}

		input.setNumberSnake();
		nS = input.getNumberSnake();
		snake = new Snake[nS];

		for (int i = 0; i < snake.length; i++) {
			snake[i] = new Snake();
			snake[i].setSnake();
		}

		System.out
				.println("Now Play and Enjoy!"
						+ "\n"
						+ "HELP:\nInter r1 for player 1\nInter r2 for player 2\nInter print for show play borad");
	}

	public void setCell() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cell[i][j].setTypeCell(" 0");
			}
		}
	}

	public void playGame() {
		while (r1.getPlacePlayer() != 100 && r2.getPlacePlayer() != 100) {
			this.setCell();
			input.setPlay();
			String str = input.getPlay();
			int x = 1;
			if (r1.getNamePlayer().equals(str)) {
				r1.setPlacePlayer((r.nextInt(6) + 1));
				// System.out.println(r1.getPlacePlayer());
				while (x != 0) {
					for (int i = 0; i < ladder.length; i++) {
						if (r1.getPlacePlayer() == ladder[i].getStartLadder()) {
							r1.climbLadder(ladder[i].getEndLadder());
							// System.out.println("r1 = " +
							// r1.getPlacePlayer());
							x = 1;
							i = ladder.length;
							// System.out.println("xl = " + x);
						} else {
							x = 0;
							// System.out.println("xl0 = " + x);
						}
					}
					for (int i = 0; i < snake.length; i++) {
						if (r1.getPlacePlayer() == snake[i].getStartSnake()) {
							r1.snakeBite(snake[i].getEndSnake());
							// System.out.println("r1 = " +
							// r1.getPlacePlayer());
							x = 1;
							i = ladder.length;
							// System.out.println("xs = " + x);
						} else {
							x = 0;
							// System.out.println("x20 = " + x);
						}
					}
					// System.out.println("x = " + x);
				}
				// System.out.println(r1.getPlacePlayer());
				if (r1.getPlacePlayer() == r2.getPlacePlayer()) {
					r2.goFirst();
				}
			} else if (r2.getNamePlayer().equals(str)) {
				r2.setPlacePlayer((r.nextInt(6) + 1));
				// System.out.println(r2.getPlacePlayer());
				while (x != 0) {
					for (int i = 0; i < ladder.length; i++) {
						if (r2.getPlacePlayer() == ladder[i].getStartLadder()) {
							r2.climbLadder(ladder[i].getEndLadder());
							x = 1;
							i = ladder.length;
						} else {
							x = 0;
						}
					}
					for (int i = 0; i < snake.length; i++) {
						if (r2.getPlacePlayer() == snake[i].getStartSnake()) {
							r2.snakeBite(snake[i].getEndSnake());
							x = 1;
							i = ladder.length;
						} else {
							x = 0;
						}
					}
				}
				// System.out.println(r2.getPlacePlayer());
				if (r1.getPlacePlayer() == r2.getPlacePlayer()) {
					r1.goFirst();
				}
			}
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					if (r1.getPlacePlayer() == cell[i][j].getNumberCell())
						cell[i][j].setTypeCell(" 1");
				}
			}
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					if (r2.getPlacePlayer() == cell[i][j].getNumberCell())
						cell[i][j].setTypeCell(" 2");
				}
			}
			if (str.equals("print")) {
				for (int i = 0; i < cell.length; i++) {
					for (int j = 0; j < cell.length; j++) {
						System.out.print(cell[i][j].getTypeCell());
					}
					System.out.println();
				}
			}
		}
		if (r1.getPlacePlayer() == 100) {
			System.out.println("*** r1 Winner ***");
		} else if (r2.getPlacePlayer() == 100) {
			System.out.println("*** r2 Winner ***");
		}
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j].getTypeCell());
			}
			System.out.println();
		}
	}
}
