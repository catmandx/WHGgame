package game;

public class Settings {
    //Player
    public static final int PLAYER_DIMENSION = 17;
    //Dot
    public static final int DOT_DIMENSION = 10;
    //Enemy
    public static final int ENEMY_DIMENSION = 15;
    public static final int ENEMY_SPEED = 4;
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
    //Game
    public static int NUMBER_OF_DEATHS = 0;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    //map
    public static final int TILE_SIZE = 30;
    public static final int WALL_THICKNESS = 4;
    //    public static final int NUMBER_OF_COLS = GAME_WIDTH / TILE_SIZE;
//    public static final int NUMBER_OF_ROWS = GAME_HEIGHT / TILE_SIZE;
    public static int NUMBER_OF_COLS = 20;
    public static int NUMBER_OF_ROWS = 10;
    public static int TILE_START_X = (GAME_WIDTH - NUMBER_OF_COLS * TILE_SIZE) / 2;
    public static int TILE_START_Y = (GAME_HEIGHT - NUMBER_OF_ROWS * TILE_SIZE) / 2;

    //Map1
    public static int[][] mapMatrix = new int[NUMBER_OF_COLS][NUMBER_OF_ROWS];


}