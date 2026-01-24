public class Movie {
    private final String Title;
    private final int YearOfRelease;
    private final String Genre1;
    private final String Genre2;
    private final String Genre3;
    private final int RunningTime;
    private final String ProductionCompany;
    private final int Budget;
    private final int Revenue;

    public String getTitle() {
        return Title;
    }

    public int getYearOfRelease() {
        return YearOfRelease;
    }

    public int getBudget() {
        return Budget;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public int getRevenue() {
        return Revenue;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public Movie(String name, int year, String gen1, String gen2, String gen3, int time, String company, int Budget, int Revenue ){
        Title= name;
        YearOfRelease= year;
        Genre1= gen1;
        Genre2= gen2;
        Genre3= gen3;
        RunningTime= time;
        ProductionCompany= company;
        this.Budget= Budget;
        this.Revenue= Revenue;
    }

    public void PrintMovie(){
        System.out.println(Title+", "+YearOfRelease+", "+Genre1+", "+Genre2+", "+Genre3+", "+RunningTime+", "+ProductionCompany+", "+Budget+", "+Revenue);
    }

}


