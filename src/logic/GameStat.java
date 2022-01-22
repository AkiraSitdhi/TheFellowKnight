package logic;

public class GameStat {

	public static int enemyKilled = 0;
	public static int waveCount = 0;
	public static boolean isGameOver = false;
	public static boolean isVictory = false;
	public static String defeatReason = "";
	public static double knightHp=1;
	public static double wizardHp=1;
	public static double bomberHp=1;
	public static double archerHp=1;
	public static double executionerHp=1;
	

	public static void reset() {
		enemyKilled = 0;
		waveCount = 0;
		isGameOver = false;
		isVictory = false;
		defeatReason = "";
		knightHp=1;
		wizardHp=1;
		bomberHp=1;
		archerHp=1;
		executionerHp=1;
	}

	public static void increaseEnemyKill() {
		enemyKilled += 1;
	}

}
