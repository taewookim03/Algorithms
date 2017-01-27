package CTCI.p5;

class p5_8_draw_line {
    static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        if (x1 > x2){
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }

        //get byte indices in which x1 and x2 reside
        int b1 = (y * width + x1) / 8;
        int b2 = (y * width + x2) / 8;

        //set all those bytes
        for (int i = b1; i <= b2; i++){
            screen[i] = (byte)0xff;//all 1s
        }

        //mask left and right of the 1s
        x1 %= 8;
        x2 %= 8;
        screen[b1] &= ((1 << (8 - x1)) - 1);
        screen[b2] &= (-1 << (7 - x2));
    }

    public static void main(String[] args){
        byte[] screen = new byte[9];
        drawLine(screen, 24, 2, 3, 1);
        drawLine(screen, 24, 2, 13, 2);
        for (int i = 0; i < screen.length; i++){
            System.out.print(Integer.toBinaryString(0x100 | (screen[i] & 0xff)).substring(1));
            if ((i+1) % 3 == 0) System.out.println();
        }
    }
}
