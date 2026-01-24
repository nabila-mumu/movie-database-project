import java.util.List;
import java.util.Scanner;

public class Menu {
    public int MenuCounter;
    Menu() throws Exception {
        this.MenuCounter = 0;
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {

            if (MenuCounter == 0) {

                System.out.println("Main Menu:");
                System.out.println("1. Search Movies");
                System.out.println("2. Search Production Companies");
                System.out.println("3. Add Movie");
                System.out.println("4. Exit System");
                System.out.println("Enter your option: ");

                MenuCounter = scan.nextInt();
                if(MenuCounter >4) {
                    System.out.println("Input is not valid");
                    MenuCounter =0;
                }
            }
            //case 4: System.exit(0);

            else if (MenuCounter == 1) {
                System.out.println("Movie Searching Option:");
                System.out.println("1. By Movie Title");
                System.out.println("2. By Release Year");
                System.out.println("3. By Genre");
                System.out.println("4. By Production Company");
                System.out.println("5. By Running Time");
                System.out.println("6. Top 10 Movies");
                System.out.println("7. Back to Main Menu");
                System.out.println("Enter your choice: ");
                int Choice = scan.nextInt();
                if (Choice == 1) MenuCounter = 11;
                else if (Choice == 2) MenuCounter = 12;
                else if (Choice == 3) MenuCounter = 13;
                else if (Choice == 4) MenuCounter = 14;
                else if (Choice == 5) MenuCounter = 15;
                else if (Choice == 6) MenuCounter = 16;
                else if (Choice == 7) MenuCounter = 0;
                else System.out.println("Input is not valid");
            } else if (MenuCounter == 11) {
                System.out.print("Enter Movie Name: ");
                scan.nextLine();
                String name = scan.nextLine();
               Movie m= FileOperation.searchByName(name);
                assert m != null;
                m.PrintMovie();
                MenuCounter = 1;
            } else if (MenuCounter == 12) {
                System.out.println("Enter Release Year: ");
                int year = scan.nextInt();
                List<Movie> arrayList;
                arrayList=FileOperation.searchByReleaseYear(year);
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie with this year");
                        break;
                    }
                    else m.PrintMovie();
                }
                MenuCounter = 1;
            } else if (MenuCounter == 13) {
                System.out.println("Enter Movie genre: ");
                String genre = scan.next();
                List<Movie> arrayList;
                arrayList=FileOperation.searchByGenre(genre);
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie with this genre");
                        break;
                    }
                    else m.PrintMovie();
                }
                MenuCounter = 1;
            }
            else if(MenuCounter ==14){
                System.out.println("Enter Production Company: ");
                scan.nextLine();
                String company= scan.nextLine();
                List<Movie> arrayList;
                arrayList=FileOperation.searchByProductionCompany(company);
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie with this production company");
                        break;
                    }
                    else m.PrintMovie();
                }

                MenuCounter =1;
            }
            else if(MenuCounter ==15){
                System.out.println("Enter Running time lower limit: ");
                int low=scan.nextInt();
                System.out.println("Enter running time upper limit: ");
                int high= scan.nextInt();
                List<Movie> arrayList;
                arrayList=FileOperation.searchByRunTime(low,high);
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie within this running time limit");
                        break;
                    }
                    else m.PrintMovie();
                }
                MenuCounter =1;
            }
            else if(MenuCounter ==16){
                System.out.println("Top ten movies based on the profit: ");
                FileOperation.topTenMovies();
                MenuCounter =1;
            }
            else if(MenuCounter ==2){
                System.out.println("Production Company Searching Options: ");
                System.out.println("1. Most Recent Movies ");
                System.out.println("2. Movies with the Maximum Revenue");
                System.out.println("3. Total Profit");
                System.out.println("4. List of Production Companies and the Count of their Produced Movies");
                System.out.println("5. Back to Main Menu");
                System.out.println("Enter your choice: ");
                int Choice = scan.nextInt();
                if (Choice == 1) MenuCounter = 21;
                else if (Choice == 2) MenuCounter = 22;
                else if (Choice == 3) MenuCounter = 23;
                else if (Choice == 4) MenuCounter = 24;
                else if (Choice == 5) MenuCounter = 0;
                else System.out.println("Input is not valid");
            }
            else if(MenuCounter ==21){
                System.out.println("Enter a production company: ");
                scan.nextLine();
                String company = scan.nextLine();
                List<Movie> arrayList;
                arrayList= FileOperation.mostRecentMovies(company);
                assert arrayList != null;
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie with this production company");
                        break;
                    }
                    else m.PrintMovie();
                }
                MenuCounter =2;
            }
            else if(MenuCounter ==22){
                System.out.println("Enter a production company: ");
                scan.nextLine();
                String company = scan.nextLine();
                List<Movie> arrayList;
                arrayList=FileOperation.mostRevenueMovie(company);
                for(Movie m:arrayList){
                    if (arrayList.size()==0) {
                        System.out.println("There is no movie with this production company");
                        break;
                    }
                    else m.PrintMovie();
                }

                MenuCounter =2;
            }
            else if(MenuCounter ==23){
                System.out.println("Enter a production company: ");
                scan.nextLine();
                String company = scan.nextLine();
               int profit= FileOperation.totalProfit(company);
                if (profit == 0) System.out.println("There is no such company");
                if (profit < 0) System.out.println("Profit: " + profit * (-1));
                else if (profit > 0) System.out.println("Profit: " + profit);
                MenuCounter =2;
            }
            else if(MenuCounter ==24){
                System.out.println("All the production companies and the total number of movies they produced");
                FileOperation.allProductionCompany();
                MenuCounter =2;
            }
            else if(MenuCounter ==3){
                System.out.println("Enter movie name:");
                scan.nextLine();
                String name=scan.nextLine();
                for(int i=0; i<FileOperation.movieList.size(); ++i){
                    if(FileOperation.movieList.get(i).getTitle().equalsIgnoreCase(name)){
                        System.out.println("Movie already exists");
                        MenuCounter =0;
                    }
                }
                System.out.println("Enter release year: ");
                int year=scan.nextInt();
                System.out.println("Enter Genre1: ");
                scan.nextLine();
                String gen1= scan.nextLine();
                System.out.println("Enter Genre2: ");
                String gen2= scan.nextLine();
                System.out.println("Enter Genre3: ");
                String gen3= scan.nextLine();
                System.out.println("Enter Running Time: ");
                int time=scan.nextInt();
                System.out.println("Enter Production company: ");
                scan.nextLine();
                String company= scan.nextLine();
                System.out.println("Enter Budget: ");
                int budget=scan.nextInt();
                System.out.println("Enter revenue: ");
                int revenue=scan.nextInt();
                Movie m=new Movie(name,year,gen1,gen2,gen3,time,company,budget,revenue);
                FileOperation.movieList.add(m);
                MenuCounter =0;
            }
            else if(MenuCounter ==4){
                FileOperation.fileWriter();
                System.exit(0);
            }

        }


        scan.close();


    }
}

