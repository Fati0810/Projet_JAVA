import java.util.Scanner;

public class Morpiontp {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char joueur = 'X';
        char monTableau[][] = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        int tours = 0;
        boolean victoire = false;


        while (!victoire && tours < 9) {
            afficherPlateau(monTableau);
            System.out.println("Joueur " + joueur + ", entrez vos coordonnées (x et y entre 0,1 et 2) :");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(monTableau[x][y] == ' ' ){
                monTableau[x][y] = joueur;

                victoire = verifieVictoire(monTableau, joueur);

                if(victoire) {
                    afficherPlateau(monTableau);
                    System.out.println("Félicitations ! Joueur " + joueur + " a gagné !");
                }else if(tours == 9){
                    afficherPlateau(monTableau);
                    System.out.println("Match nul !");
                }else{
                    //changer de joueur
                    joueur = (joueur == 'X') ? 'O' : 'X';
                }

            }else {
                System.out.println("Cette case est déja remplie. Choisissez une autre case");
            }
        }

        scanner.close();
    }

    public static void afficherPlateau(char[][] monTableau){
        //afficher les valeurs
        for(int i = 0; i < monTableau.length; i++){
            for(int j = 0; j < monTableau[i].length; j++){
                System.out.print(monTableau[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean verifieVictoire(char[][] monTableau, char joueur){
        for (int i = 0; i < 3; i++) {
            if (monTableau[i][0] == joueur && monTableau[i][1] == joueur && monTableau[i][2] == joueur) return true;
            if (monTableau[0][i] == joueur && monTableau[1][i] == joueur && monTableau[2][i] == joueur) return true;
        }
        if (monTableau[0][0] == joueur && monTableau[1][1] == joueur && monTableau[2][2] == joueur) return true;
        if (monTableau[0][2] == joueur && monTableau[1][1] == joueur && monTableau[2][0] == joueur) return true;

        return false;
    }
}  
    
