package game;

public class Settings {
    //Player
//    public final int
    //Tile && MAP
    public static final int TILE_DIMENSIONS = 30;
    public static final int IS_GOAL_TILE = 4;
    public static final int IS_CHECKPOINT_TILE = 5;
    public static final int IS_START_TILE = 3;

    public static final int IS_TILE = 1;
    public static final int IS_COIN = 2;

    //These are used only in class Tile
    public static final int IS_WHITE_TILE = 2;
    public static final int IS_BLUE_TILE = 1;
    //VLine
    public static final int LINE_LENGTH = 30;
    //Dot

    //Game
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    //Map
    public static final int WAY_SIZE = 30;
    //    public static final int NUMBER_OF_COLS = GAME_WIDTH / WAY_SIZE;
//    public static final int NUMBER_OF_ROWS = GAME_HEIGHT / WAY_SIZE;
    public static final int NUMBER_OF_COLS = 15;
    public static final int NUMBER_OF_ROWS = 10;
    public static final int TILE_START_X = (GAME_WIDTH - NUMBER_OF_COLS * WAY_SIZE) / 2;
    public static final int TILE_START_Y = (GAME_HEIGHT - NUMBER_OF_ROWS * WAY_SIZE) / 2;

    //Map1
    public static int[][] map1 = new int[NUMBER_OF_COLS][NUMBER_OF_ROWS];
    public static String s =
            "000000000000000" +
                    "333001011001111" +
                    "333111111111111" +
                    "333111111111111" +
                    "111111133111111" +
                    "111111111114444" +
                    "111121111114444" +
                    "111111111114444" +
                    "111111111114444" +
                    "000000000010000";
    public static void setMapTiles(){


    }
}