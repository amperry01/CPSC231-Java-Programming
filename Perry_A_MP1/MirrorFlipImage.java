public class MirrorFlipImage{

    // take 2D char array as input and print it (output to console)
    private static void displayImage(char[][] image){
        for (int row =  0; row < image.length; ++row){
            for (int col = 0; col < image[0].length; ++col){
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }
        // for formatting purposes in console
        System.out.println();
    }

    // flip image horizontally; replaces beginning of columns with end
    private static char[][] horizontalMirror(char[][] image){
        char[][] horizArr = new char[image.length][image[0].length];

        for (int col = 0; col < image[0].length; ++col){
            int idx = image.length - 1;
            for (int row = 0; row < image.length; ++row){
                horizArr[row][col] = image[idx][col];
                idx--;
            }
        }

        return horizArr;
    }

    // flip image vertically; replaces beggining of rows with end
    private static char[][] verticalMirror(char[][] image){
        char[][] vertArr = new char[image.length][image[0].length];

        for (int row = 0; row < image.length; ++row){
            int idx = image[0].length - 1;
            for (int col = 0; col < image[0].length; ++col){
                vertArr[row][col] = image[row][idx];
                idx--;
            }
        }
        return  vertArr;
    }

    // main method
    public static void main(String[] args){
        // formatting so the print statements happen with a line between commands and output in console
        System.out.println();

        // create a 2D array of chars called image (hard coded, no user input)
    char[][] image = {
                {'#', 'x', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', ' ', 'E', ' ', '#'},
                {'*', ' ', ' ', ' ', '|'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', 'y', '#'}
            };

        // call displayImage method
        System.out.println("Original image:");
        displayImage(image);

        // call horizontalMirror method
        System.out.println("Horizontally flipped image:");
        displayImage(horizontalMirror(image));

        // call verticalMirror method
        System.out.println("Vertically flipped image:");
        displayImage(verticalMirror(image));

        // call displayImage method with resulting horizontally and vertically flipped image
        System.out.println("Horizontally and then Vertically flipped image:");
        displayImage(verticalMirror(horizontalMirror(image)));
    }
}