package com.cmuhatia.playground;

public class RobotMoves {

    public static void main(String[] args){
        int x = 2;
        int y = 1;
        int dx = 1;
        int dy = 1;
        Robot firstRobot = new Robot();
        firstRobot.printCurrentCoordinates();

        Robot secondRobot = new Robot(x, y);
        secondRobot.printCurrentCoordinates();

        for (int i = 1; i < 3; i++) {
            secondRobot.moveX(dx);
            secondRobot.printLastMove();
            secondRobot.printCurrentCoordinates();
            secondRobot.moveY(dy);
            secondRobot.printLastCoordinates();

            dx += i * i;
            dy -= i * i;
        }
    }

    /**
     * Maintains robot movements
     */
    public static class Robot{
        /**
         * Current x coordinate. Default is 0
         */
        private int currentX = 0;
        /**
         * Current y coordinate. Default is 5
         */
        private int currentY = 5;
        /**
         * Previous robot x coordinate
         */
        private int previousX;
        /**
         * Previous robot y coordinate
         */
        private int previousY;
        /**
         * Used to flag last move
         */
        private LastMove lastMove;

        /**
         * Default constructor
         */
        public Robot(){

        }

        /**
         * Initializes current x and y coordinates
         *
         * @param currentX current x coordinates
         * @param currentY current y coordinates
         */
        public Robot(int currentX, int currentY) {
            this.previousX = this.currentX;
            this.previousY = this.currentY;
            this.currentX = currentX;
            this.currentY = currentY;
            this.lastMove = LastMove.DY;
        }

        /**
         * Move x from current position to new position of dx units
         * @param dx units to be moved
         */
        public void moveX(int dx){
            this.previousX = this.currentX;
            this.previousY = this.currentY;
            this.currentX += dx;
            this.lastMove = LastMove.DX;
        }

        /**
         * Move y from current position to new position of dy units
         * @param dy units to be moved
         */
        public void moveY(int dy){
            this.previousY = this.currentY;
            this.previousX = this.currentX;
            this.currentY += dy;
            this.lastMove = LastMove.DY;
        }

        /**
         * Prints current (x y) location of the robot
         */
        public void printCurrentCoordinates(){
            System.out.printf("%d  %d\n", this.currentX, this.currentY);
        }

        /**
         * Prints previous (x y) location of the robot
         */
        public void printLastCoordinates(){
            System.out.printf("%d  %d\n", this.previousX, this.previousY);
        }

        /**
         * Prints last robot movement
         */
        public void printLastMove(){
            if(lastMove.equals(LastMove.DY)){
                System.out.printf("y  %d\n", (currentY - previousY));
            } else if(lastMove.equals(LastMove.DX)) {
                System.out.printf("x  %d\n", (currentX - previousX));
            }
        }
    }

    /**
     * Used to flag last movement
     */
    public enum LastMove{
        /**
         * Change in x coordinates
         */
        DX,
        /**
         * Change in y coordinates
         */
        DY
    }
}


