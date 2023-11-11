import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

            /////////////////// main //////////////////

            // Créez un tableau multidimensionnel de 3*3 avec des -
            char[][] plan = new char[3][3];
            for (int i = 0; i < plan.length; i++) {
                for (int j = 0; j < plan[i].length; j++) {
                    plan[i][j] = '-';
                }
            }
            // message bienvenue
            Bienvenue();
            //enregistrer le nom des joueurs
            String joueur1 = joueur1();
            String joueur2 = joueur2();

            //booléen pour changer de joueur
            boolean joueur1AJoue = false;

            // compter le nombre de tours de jeu
            int tour = 0;

            // afficher le tableau
            for (int i = 0; i < plan.length; i++) {
                for (int j = 0; j < plan[i].length; j++) {
                    System.out.print(plan[i][j]);
                }
                System.out.println("");
            }

            boolean finPartie = false;

            while (finPartie == false) {

                // demander à l'utilisateur de choisir une ligne et une colonne
                if (joueur1AJoue== false) {
                    System.out.println(joueur1 +" , choisissez une case:");

                }else {
                    System.out.println( joueur2+" , choisissez une case:");
                }
                int choixLigne = ligne();
                int choixColonne = colonne();

                // récupérer le résultat ligne et colonne et inscrire X ou O selon le joueur
                if (plan[choixLigne - 1][choixColonne - 1] != '-') {
                    System.out.println("Veuillez saisir une autre case, celle-ci est déja occupée");
                } else {
                    if (joueur1AJoue == false) {
                        plan[choixLigne - 1][choixColonne - 1] = 'X';
                        tour += 1;
                        joueur1AJoue = true;
                    } else {
                        plan[choixLigne - 1][choixColonne - 1] = 'O';
                        tour += 1;
                        joueur1AJoue = false;
                    }
                }

                // afficher le tableau
                for (int i = 0; i < plan.length; i++) {
                    for (int j = 0; j < plan[i].length; j++) {
                        System.out.print(plan[i][j]);
                    }
                    System.out.println("");
                }

                // conditions de sortie du jeu
                // si on a fait 9 tours, on a rempli la grille
                if (tour == 9) {
                    finPartie = true;
                    System.out.println("Match nul !!");
                }

                // Vérifier les lignes
                for (int i = 0; i < 3; i++) {
                    if (plan[i][0] == plan[i][1] && plan[i][1] == plan[i][2] && plan[i][0] != '-') {
                        finPartie = true;
                        if (joueur1AJoue==true) {
                            System.out.println("Fin de la partie !! Victoire de " +joueur1);
                        }else {
                            System.out.println("Fin de la partie !! Victoire de "+ joueur2);
                        }
                    }
                }

                // Vérifier les colonnes
                for (int j = 0; j < 3; j++) {
                    if (plan[0][j] == plan[1][j] && plan[1][j] == plan[2][j] && plan[0][j] != '-') {
                        finPartie = true;
                        if (joueur1AJoue==true) {
                            System.out.println("Fin de la partie !! Victoire de " +joueur1);
                        }else {
                            System.out.println("Fin de la partie !! Victoire de "+ joueur2);
                        }
                    }

                    // Vérifier les diagonales
                    if ((plan[0][0] == plan[1][1] && plan[1][1] == plan[2][2] && plan[0][0] != '-')
                            || (plan[0][2] == plan[1][1] && plan[1][1] == plan[2][0] && plan[0][2] != '-')) {
                        finPartie = true;
                        if (joueur1AJoue==true) {
                            System.out.println("Fin de la partie !! Victoire de " +joueur1);
                        }else {
                            System.out.println("Fin de la partie !! Victoire de "+ joueur2);
                        }
                    }
                }
            }

        }// fin du main

        ///////////////////// fonctions //////////////////////

        // message de bienvenue
        public static void Bienvenue() {
            System.out.println("Voici la grille de morpion, bonne partie !");
        }
        //recupérer nom joueur1
        public static String joueur1() {
            System.out.println("Joueur 1, saisissez votre nom:");
            String nomJoueur1 = scan.nextLine();
            return nomJoueur1;
        }
        //récupérer nom joueur2
        public static String joueur2() {
            System.out.println("Joueur 2, saisissez votre nom:");
            String nomJoueur2 = scan.nextLine();
            return nomJoueur2;
        }

        // récupérer la ligne
        public static int ligne() {
            System.out.print("Choisissez une ligne: ");
            int ligne = scan.nextInt();
            return ligne;
        }

        // récupérer la colonne
        public static int colonne() {
            System.out.print("Choisissez une colonne: ");
            int colonne = scan.nextInt();
            return colonne;       }

}



