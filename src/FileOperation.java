import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class FileOperation {

    private static final String INPUT_FILE_NAME = "movies.txt";
    //private static final String OUTPUT_FILE_NAME = "out.txt";
    public static List<Movie> movieList = new ArrayList<>();

    public static Movie makeMovieObject(String[] stt) {
        String Name = stt[0];
        int year = Integer.parseInt(stt[1]);
        String gen1 = stt[2];
        String gen2 = stt[3];
        String gen3 = stt[4];
        int time = Integer.parseInt(stt[5]);
        String company = stt[6];
        int budget = Integer.parseInt(stt[7]);
        int revenue = Integer.parseInt(stt[8]);
        return new Movie(Name, year, gen1, gen2, gen3, time, company, budget, revenue);
    }

    public static Movie searchByName(String name) {
        for (Movie m : movieList) {
            if (m.getTitle().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public static List<Movie> searchByReleaseYear(int year) {
        List<Movie> arrayList= new ArrayList<>();

        for (Movie m : movieList) {
            if (m.getYearOfRelease()== year) arrayList.add(m);
        }
        return arrayList;
    }

    public static List<Movie> searchByGenre(String gen) {
        List<Movie> arrayList= new ArrayList<>();

        for (Movie m : movieList) {
            if (m.getGenre1().equalsIgnoreCase(gen) || m.getGenre2().equalsIgnoreCase(gen) || m.getGenre3().equalsIgnoreCase(gen))
                arrayList.add(m);
        }
        return arrayList;
    }

    public static List<Movie> searchByProductionCompany(String company) {
        List<Movie> arrayList= new ArrayList<>();

        for (Movie m : movieList) {
            if ( m.getProductionCompany().equalsIgnoreCase(company))
                arrayList.add(m);
        }
        return arrayList;
    }

    public static List<Movie> searchByRunTime(int lowTime, int highTime) {
        List<Movie> arrayList= new ArrayList<>();

        for (Movie m : movieList) {
            if (m.getRunningTime() <= highTime && m.getRunningTime() >= lowTime) arrayList.add(m);
        }
        return arrayList;
    }

    public static void topTenMovies() {
        List<Integer> profit = new ArrayList<>();
        for (Movie m : movieList) {
            profit.add(m.getRevenue() - m.getBudget());
        }
        PriorityQueue<Integer> maximum = new PriorityQueue<>();
        profit.forEach(number -> {
            maximum.add(number);

            if (maximum.size() > 10) {
                maximum.poll();
            }
        });

        List<Integer> top10List = new ArrayList<>(maximum);
        Collections.reverse(top10List);
        for (Movie m : movieList) {
            for (Integer integer : top10List) {
                if ((m.getRevenue() - m.getBudget()) == integer) m.PrintMovie();
            }
        }

    }

    public static List<Movie> mostRecentMovies(String Name) {
        int recentYear = 0;
        List<Movie> arrayList= new ArrayList<>();
        List<Movie> recentList= new ArrayList<>();

        for (Movie m : movieList) {
            if (m.getProductionCompany().equalsIgnoreCase(Name)) arrayList.add(m);
        }
        if (arrayList.size()== 0) {
            System.out.println("There is no movie with this Production Company");
            return null;
        }
        for (Movie m:arrayList) {
            if (m.getYearOfRelease() >= recentYear) recentYear = m.getYearOfRelease();
        }
        for (Movie m:arrayList) {
            //if (array == null) System.out.println("There is no such movie");
            if (m.getYearOfRelease() == recentYear) recentList.add(m);
        }

        return recentList;
    }

    public static List<Movie> mostRevenueMovie(String name) {
        int highRevenue = 0;
        List<Movie> arrayList= new ArrayList<>();
        List<Movie> resultList= new ArrayList<>();

        for (Movie m : movieList) {
            if (m.getProductionCompany().equalsIgnoreCase(name)) arrayList.add(m);
        }
        for (Movie m:arrayList) {
            if (m.getRevenue() >= highRevenue) highRevenue =m.getRevenue();
        }
        for (Movie m:arrayList) {
             if (m.getRevenue() == highRevenue) resultList.add(m);
        }

        return resultList;
    }

    public static int totalProfit(String name) {
        int profit = 0;
        for (Movie m : movieList) {
            if (m.getProductionCompany().equalsIgnoreCase(name)) profit = profit + m.getRevenue() - m.getBudget();
        }
        return profit;
    }

    public static void allProductionCompany() {
        List<String> PDName = new ArrayList<>();
        List<String> PDNameNew = new ArrayList<>();
        for (Movie movie : movieList) {
            PDName.add(movie.getProductionCompany());
        }
        for (String s : PDName) {
            if (!PDNameNew.contains(s)) PDNameNew.add(s);
        }
        for (String s : PDNameNew) {
            System.out.println("Company: " + s + " , Total Movies: " + Collections.frequency(PDName, s));
        }

    }

    public static void fileWriter() throws Exception {
        String OUTPUT_FILE_NAME = "movies.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Movie movie : movieList) {
            bw.write(movie.getTitle() + "," + movie.getYearOfRelease() + "," + movie.getGenre1() + "," + movie.getGenre2() + "," + movie.getGenre3() + "," + movie.getRunningTime() + "," + movie.getProductionCompany() + "," + movie.getBudget() + "," + movie.getRevenue());
            bw.write(System.lineSeparator());
        }
        bw.close();

    }

    public static List<Movie> getMovieList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] st = line.split(",");
            Movie m = makeMovieObject(st);
            movieList.add(m);
        }
        br.close();
        return movieList;
    }

    public static void main(String[] args) throws Exception {

        getMovieList();
         new Menu();

    }
}


