package reports.shame;

/**
 * Created by Maxon on 21.05.2017.
 */
public class Prepods {
    private String FIO;
    private double summa;

    public Prepods(String FIO, double summa) {
        this.FIO = FIO;
        this.summa = summa;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }
}
